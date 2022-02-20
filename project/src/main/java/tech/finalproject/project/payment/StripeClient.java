package tech.finalproject.project.payment;

import com.paypal.api.payments.*;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import com.stripe.Stripe;
import com.stripe.model.*;
import com.stripe.param.PaymentIntentCreateParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class StripeClient {
//
//    @Autowired
//    StripeClient() {
//        Stripe.apiKey = "sk_test_51KUrCWSGmt3oFQM9Pi9lBV8NJHqc5eZhEXFqgLz8mdwv8Yv3fKI4g9zfe7VAdk8ozx4JyEVASDxXGEIHFFOKws9300JFnpk9vL";
//    }


    public Charge chargeCreditCard(String token, Double amount) throws Exception {

        Stripe.apiKey = "sk_test_51KUrCWSGmt3oFQM9Pi9lBV8NJHqc5eZhEXFqgLz8mdwv8Yv3fKI4g9zfe7VAdk8ozx4JyEVASDxXGEIHFFOKws9300JFnpk9vL";

//        Map<String, Object> sourceParams = new HashMap<>();
//        sourceParams.put("type" , "ideal");
//        sourceParams.put("currency", "USD");
//        sourceParams.put("redirect", "https://localhost:4200/home");
////        Map<String, Object> ownerParams = new HashMap<>();
////        ownerParams.put("email", "jennyosen@example.com");
////        sourceParams.put("owner", ownerParams);
//
//       Source source = Source.create(sourceParams);
//        System.out.println(source);


        List<Object> paymentMethodTypes = new ArrayList<>();
        paymentMethodTypes.add("card");

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("amount", (int)(amount * 100));
        params.put("currency", "USD");
        params.put("payment_method_types" , paymentMethodTypes);
        params.put("source" , token);

        System.out.println(token);

        PaymentIntent payment = PaymentIntent.create(params);

        Charge charge = Charge.create(params);

        SetupIntent setupIntent = SetupIntent.create(params);

//        return setupIntent;
//        return payment;
        return charge;

    }
    public Customer createCustomer(String token, String email) throws Exception {
        Map<String, Object> customerParams = new HashMap<String, Object>();
        customerParams.put("email", email);
        customerParams.put("source", token);
        return Customer.create(customerParams);
    }

}