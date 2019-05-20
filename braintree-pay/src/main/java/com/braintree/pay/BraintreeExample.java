package com.braintree.pay;

import java.math.BigDecimal;

import com.braintreegateway.BraintreeGateway;
import com.braintreegateway.Environment;
import com.braintreegateway.PaymentMethodNonce;
import com.braintreegateway.Result;
import com.braintreegateway.Transaction;
import com.braintreegateway.TransactionRequest;
import com.braintreegateway.ValidationError;

/**
 * Hello world!
 *
 */
public class BraintreeExample 
{
	public static void main(String[] args) {
        BraintreeGateway gateway = new BraintreeGateway(
            Environment.SANDBOX,
            "kvqtk9z9tdx97kby",
            "ftfptw98jwjxkkzr",
            "de56b139e42fd3eead3b8d04a2fb99ee"
        );
        

       
        		

        TransactionRequest request = new TransactionRequest()
            .amount(new BigDecimal("1000.00"))
            .paymentMethodNonce("fake-valid-nonce")
            .options()
                .submitForSettlement(true)
                .done();

        Result<Transaction> result = gateway.transaction().sale(request);

        if (result.isSuccess()) {
            Transaction transaction = result.getTarget();
            System.out.println("Success!: " + transaction.getId());
        } else if (result.getTransaction() != null) {
            Transaction transaction = result.getTransaction();
            System.out.println("Error processing transaction:");
            System.out.println("  Status: " + transaction.getStatus());
            System.out.println("  Code: " + transaction.getProcessorResponseCode());
            System.out.println("  Text: " + transaction.getProcessorResponseText());
        } else {
            for (ValidationError error : result.getErrors().getAllDeepValidationErrors()) {
               System.out.println("Attribute: " + error.getAttribute());
               System.out.println("  Code: " + error.getCode());
               System.out.println("  Message: " + error.getMessage());
            }
        }
    }
}
