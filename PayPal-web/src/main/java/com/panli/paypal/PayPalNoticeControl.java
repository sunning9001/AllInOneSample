/**
 * @CreateTime: sunning2019年3月18日
 * @CreateUser: sunning
 * @Copyright: http://www.yugyg.com 无锡愚公网络科技有限公司 Inc. All rights reserved.
 */

package com.panli.paypal;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

/**
 * @author sunning
 * @date 2019/03/18
 */
@RestController
public class PayPalNoticeControl {

    @RequestMapping("/process")
    public void process(@RequestBody String body, HttpSession session, HttpServletResponse response,
        HttpEntity<byte[]> requestEntity, WebRequest request) {
     	System.out.println("=====process==========");
        Map<String, String[]> pMap = request.getParameterMap();

        for (Map.Entry<String, String[]> k : pMap.entrySet()) {

            System.out.println(" k=" + k.getKey());

            String[] vv = k.getValue();

            for (String v : vv) {
               System.out.println("v ="+ v);
            }
        }
    }
    @RequestMapping("/cancel")
    public void cancel(@RequestBody String body, HttpSession session, HttpServletResponse response,
    		HttpEntity<byte[]> requestEntity, WebRequest request) {
    	
    	System.out.println("=====cancel==========");
    	Map<String, String[]> pMap = request.getParameterMap();
    	
    	for (Map.Entry<String, String[]> k : pMap.entrySet()) {
    		
    		System.out.println(" k=" + k.getKey());
    		
    		String[] vv = k.getValue();
    		
    		for (String v : vv) {
    			System.out.println("v ="+ v);
    		}
    	}
    }
    
}
