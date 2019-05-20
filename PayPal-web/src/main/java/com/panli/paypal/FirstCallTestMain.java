/**
 * @CreateTime: sunning2019年3月21日
 * @CreateUser: sunning
 * @Copyright: http://www.yugyg.com 无锡愚公网络科技有限公司 Inc. All rights reserved.
 */

package com.panli.paypal;

import java.util.ArrayList;
import java.util.List;

import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.Constants;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;

/**
 * @author sunning
 * @date 2019/03/21
 */
public class FirstCallTestMain {
    public static void main(String[] args) {

        
        // Replace these values with your clientId and secret. You can use these to get started right now.
        String clientId = "Ae1W4TjVCqlxmAlePCvHON3d1iCeKdd5tJUcbAZNvNaNJx5vU_eKHOvxT1sWMx-A-vmYJqj8m7layDFe";
        String clientSecret = "ELpEq4kI7kpVnJ2L7-jlGPSqoA-95tU6LYFA8oVTVPW7wJ7Oa8HbpqKOI2rUY_BqN_Q6VlVVLiXMEkhD";
        
        
        //Create a Payment object.
        Amount amount = new Amount();
        amount.setCurrency("USD");
        amount.setTotal("1.00");

        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        List<Transaction> transactions = new ArrayList<Transaction>();
        transactions.add(transaction);

        Payer payer = new Payer();
        payer.setPaymentMethod("paypal");

        Payment payment = new Payment();
        payment.setIntent("sale");
        payment.setPayer(payer);
        payment.setTransactions(transactions);

        RedirectUrls redirectUrls = new RedirectUrls();
        redirectUrls.setCancelUrl("http://www.baidu.com");
        redirectUrls.setReturnUrl("http://www.baidu.com");
        payment.setRedirectUrls(redirectUrls);
        
        //Create an APIContext object with proper configurations. Make sure to create one for each request. 
        //Make a create call and use the createdPayment object to get the approval URL.
        
        System.out.println(payment.toJSON());
        
        try {
            System.out.println("=========debugdebugdebug===========1===");
            APIContext apiContext = new APIContext(clientId, clientSecret, Constants.SANDBOX);
            Payment createdPayment = payment.create(apiContext);
            // For debug purposes only: 
            System.out.println("=========debugdebugdebug===========2===");
            System.out.println(createdPayment.toString());
        } catch (PayPalRESTException e) {
            // Handle errors
            
            System.out.println("e = " + e);
            
        } catch (Exception ex) {
            System.out.println("ex = " + ex);
            // Handle errors
        }
        
        
    }
}
