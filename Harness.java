
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Harness {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Example mExample=new Example();
		HttpServletRequest mRequest =new mRequest();
		HttpServletResponse mResponse =new mResponse();
		mExample.doGet(mRequest, mResponse);
	}

}
