package com.panli.paypal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Details;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.PayerInfo;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.Constants;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class PayPalStep1Main {

	public static void main(String[] args) {
		
		
		// Set payer details
		Payer payer = new Payer();
		payer.setPaymentMethod("paypal");

		// Set redirect URLs
		RedirectUrls redirectUrls = new RedirectUrls();
		redirectUrls.setCancelUrl("http://test.ngrok.yugyg.com:8000/cancel");
		redirectUrls.setReturnUrl("http://test.ngrok.yugyg.com:8000/process");

		// Set payment details
		Details details = new Details();
		details.setShipping("1");
		details.setSubtotal("5");
		details.setTax("1");

		// Payment amount
		Amount amount = new Amount();
		amount.setCurrency("USD");
		// Total must be equal to sum of shipping, tax and subtotal.
		amount.setTotal("7");
		amount.setDetails(details);

		// Transaction information
		Transaction transaction = new Transaction();
		transaction.setAmount(amount);
		transaction
		  .setDescription("This is the payment transaction description.");

		// Add transaction to a list
		List<Transaction> transactions = new ArrayList<Transaction>();
		transactions.add(transaction);

		// Add payment details
		Payment payment = new Payment();
		payment.setIntent("sale");
		payment.setPayer(payer);
		payment.setRedirectUrls(redirectUrls);
		payment.setTransactions(transactions);
		
		
	      // Replace these values with your clientId and secret. You can use these to get started right now.
        String clientId = "Ae1W4TjVCqlxmAlePCvHON3d1iCeKdd5tJUcbAZNvNaNJx5vU_eKHOvxT1sWMx-A-vmYJqj8m7layDFe";
        String clientSecret = "ELpEq4kI7kpVnJ2L7-jlGPSqoA-95tU6LYFA8oVTVPW7wJ7Oa8HbpqKOI2rUY_BqN_Q6VlVVLiXMEkhD";
        
        
        
		
        APIContext apiContext = new APIContext(clientId, clientSecret, Constants.SANDBOX);
		
		
		// Create payment
		try {
		  Payment createdPayment = payment.create(apiContext);

		  String payMentId = createdPayment.getId();
		  
		  System.out.println("payMentId = " +  payMentId);
		  
		  Iterator<Links> links = createdPayment.getLinks().iterator();
		  while (links.hasNext()) {
		    Links link = links.next();
		    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
		    System.out.println(" Rel  =" +link.getRel() + "Href = " +  link.getHref());
		
		    if (link.getRel().equalsIgnoreCase("approval_url")) {
		      // Redirect the customer to link.getHref()
		    	
		    //http://test.ngrok.yugyg.com:8000/process?paymentId=PAYID-LSM67BY0LD9241740002064R&token=EC-5W4228141X7541201&PayerID=EHDYS3UH6TZEE
		    }
		  }
		} catch (PayPalRESTException e) {
		    System.err.println(e.getDetails());
		}
		
		//payment ID and payer ID.
		
	}
}
