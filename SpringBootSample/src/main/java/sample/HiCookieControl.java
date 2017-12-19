package sample;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.jscookie.javacookie.Cookies;

@RestController
public class HiCookieControl {

	   @RequestMapping("/hiCookie")
	    public void hiCookie(HttpServletRequest request,HttpServletResponse response) {
	      
		   Cookies cookies = Cookies.initFromServlet( request, response );
		   cookies.set( "name", "value" );
		   cookies.set("sun", "ning");
		   
		  System.out.println(cookies.toString());
		   
	    }
}
