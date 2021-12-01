

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Example {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		    String name = req.getParameter("name");
	        foo(name, "abc", req, resp);
	    }
	
    void foo(String str1, String str2, ServletRequest req, ServletResponse resp) throws IOException {
    	PrintWriter writer = resp.getWriter();
    	Data d = new Data();
    	d.value1 = str1;
        d.value2 = str2;
        writer.println(d.value1);                   /* BAD */
        writer.println(d.value2);                   /* OK */
    }
}
class Data {	
    String value1;
    String value2;
}