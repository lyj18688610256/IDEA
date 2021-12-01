package org.clyze.jinfoflowbench.application.event_based;

import org.clyze.jinfoflowbench.eventframework.Event;
import org.clyze.jinfoflowbench.eventframework.EventDriver;
import org.clyze.jinfoflowbench.eventframework.EventHandler;
import org.clyze.jinfoflowbench.eventframework.UninitialisedEvent;
import org.clyze.jinfoflowbench.events.NewEntityEvent;
import org.clyze.jinfoflowbench.events.NewTransactionEvent;

import java.io.*;

/**
 * Created by neville on 01/11/2016.
 */
public class Events5 implements EventHandler{

    PrintWriter writer = new PrintWriter(new FileWriter("sink"));
    BufferedReader reader = new BufferedReader(new FileReader("source"));

    class AnotherEventHandler implements EventHandler {
        private PrintWriter writer;

        AnotherEventHandler(PrintWriter writer) {
            this.writer = writer;
        }
        public void handleNewTransaction(NewTransactionEvent e) throws IOException {
            writer.println(e.getDestinationEntityId()); // bad
        }
    }

    public Events5() throws IOException{
        writer = new PrintWriter(new FileWriter("sink"));
        reader = new BufferedReader(new FileReader("source"));
    }

    public void start() throws IOException {
        EventDriver driver = new EventDriver();
        driver.registerAsEventHandler(this);
        AnotherEventHandler anotherEventHandler = new AnotherEventHandler(writer);
        // succinct way of invoking event
        driver.createEvent("NewTransaction").apply("setDestinationEntityId", reader.readLine()).raiseEvent();
    }

    public static void main(String[] args) throws IOException {
        Events5 app = new Events5();
        app.start();

    }

    public void handleNewTransaction(NewTransactionEvent e) throws IOException {
        writer.println("foo"); // ok
    }

}
