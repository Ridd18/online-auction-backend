package tech.finalproject.project.payment;

import com.paypal.api.payments.*;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import com.stripe.Stripe;
import com.stripe.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class StripeClient {

    @Autowired
    StripeClient() {
        Stripe.apiKey = "sk_test_51KUrCWSGmt3oFQM9Pi9lBV8NJHqc5eZhEXFqgLz8mdwv8Yv3fKI4g9zfe7VAdk8ozx4JyEVASDxXGEIHFFOKws9300JFnpk9vL";
    }

    public PaymentIntent chargeCreditCard(String token, double amount) throws Exception {

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("amount", (int)(amount * 100));
        params.put("currency", "USD");
        System.out.println(token);
//        String tokenn = token;
//        System.out.println(tokenn);
//        Token token1 = Token.retrieve(tokenn);
//        System.out.println(token1);
//        Source source = Source.retrieve(token);
//        System.out.println(source);
        params.put("token", token);

        PaymentIntent payment = PaymentIntent.create(params);

        return payment;

    }
    public Customer createCustomer(String token, String email) throws Exception {
        Map<String, Object> customerParams = new HashMap<String, Object>();
        customerParams.put("email", email);
        customerParams.put("source", token);
        return Customer.create(customerParams);
    }

}