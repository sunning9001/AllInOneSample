package sk.bsmk.fileupload.controllers;

import java.io.IOException;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AjaxControl {

	  @RequestMapping(value = "/test")
	  @ResponseBody
	  public String ajax(HttpServletRequest request) throws IOException {
		  

		  
		 ServletInputStream is = request.getInputStream();
		 int l = is.available();
		  byte[] bt =new byte[l];
		  
		  is.read(bt);
		  System.out.println(new String(bt));
		 return "";
	  }

}
