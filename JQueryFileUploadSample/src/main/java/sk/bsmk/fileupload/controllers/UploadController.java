package sk.bsmk.fileupload.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * Created by bsmk on 9/7/14.
 */
@RestController
public class UploadController {

  @RequestMapping(method = RequestMethod.POST, value = "/file-upload")
  public ResponseEntity<String> upload(MultipartHttpServletRequest request) {
	  System.out.println("-------upload-----");
    return new ResponseEntity<String>(String.format("total: %d", request.getMultiFileMap().size()), HttpStatus.OK);
  }

}
