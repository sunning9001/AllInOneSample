package sample;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiSessionControl {

	  @RequestMapping("/HiSession")
	    public void HiSession(HttpServletRequest request,HttpServletResponse response) {
	      
		    HttpSession session = request.getSession();
		    
		  
		    session.setAttribute("sun", "ning");
		    
		    
	    }
}
