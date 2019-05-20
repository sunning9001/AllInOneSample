package com.panli.paypal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Details;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentExecution;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.Constants;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;

public class PayPalStep2Main {

	public static void main(String[] args) {
	
		
	      // Replace these values with your clientId and secret. You can use these to get started right now.
        String clientId = "Ae1W4TjVCqlxmAlePCvHON3d1iCeKdd5tJUcbAZNvNaNJx5vU_eKHOvxT1sWMx-A-vmYJqj8m7layDFe";
        String clientSecret = "ELpEq4kI7kpVnJ2L7-jlGPSqoA-95tU6LYFA8oVTVPW7wJ7Oa8HbpqKOI2rUY_BqN_Q6VlVVLiXMEkhD";
        
        
        
		
        APIContext apiContext = new APIContext(clientId, clientSecret, Constants.SANDBOX);
		
		
        
        Payment payment = new Payment();
	
       
        //http://test.ngrok.yugyg.com:8000/process?paymentId=PAYID-LS74WBI4MJ61330X1055034K&token=EC-1EC764126K1363403&PayerID=UFBUTRYQKJNRL
        payment.setId("PAYID-LS74WBI4MJ61330X1055034");

        PaymentExecution paymentExecution = new PaymentExecution();
        paymentExecution.setPayerId("UFBUTRYQKJNRL");
        try {
          Payment createdPayment = payment.execute(apiContext, paymentExecution);
          System.out.println(createdPayment);
        } catch (PayPalRESTException e) {
          System.err.println(e.getDetails());
        }
		
		//payment ID and payer ID.
		
	}
}
