package tech.finalproject.project.payment;

import com.stripe.Stripe;
import com.stripe.model.*;
import com.stripe.param.ChargeCreateParams;
import com.stripe.param.CustomerCreateParams;
import com.stripe.param.PaymentIntentCreateParams;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class StripeClient {
//
//    @Autowired
//    StripeClient() {
//        Stripe.apiKey = "sk_test_51KUrCWSGmt3oFQM9Pi9lBV8NJHqc5eZhEXFqgLz8mdwv8Yv3fKI4g9zfe7VAdk8ozx4JyEVASDxXGEIHFFOKws9300JFnpk9vL";
//    }


    public PaymentIntent chargeCreditCard(String token, Double amount) throws Exception {

        Stripe.apiKey = "sk_test_51KUrCWSGmt3oFQM9Pi9lBV8NJHqc5eZhEXFqgLz8mdwv8Yv3fKI4g9zfe7VAdk8ozx4JyEVASDxXGEIHFFOKws9300JFnpk9vL";

        CustomerCreateParams customerCreateParams =
                CustomerCreateParams.builder()
                        .build();

        Customer customer = Customer.create(customerCreateParams);


//        Map<String, Object> sourceParams = new HashMap<>();
//        sourceParams.put("type" , "ideal");
//        sourceParams.put("currency", "USD");
//        sourceParams.put("redirect", "https://localhost:4200/home");
////        Map<String, Object> ownerParams = new HashMap<>();
////        ownerParams.put("email", "jennyosen@example.com");
////        sourceParams.put("owner", ownerParams);
//
//
//       Source source = Source.create(sourceParams);
//        System.out.println(source);

//
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("amount", (int)(amount * 100));
        params.put("currency", "INR");
        params.put("source",token);
        System.out.println(token);

//
        PaymentIntent payment = PaymentIntent.create(params);
////
//        Charge charge = Charge.create(params);


        return payment;
//        return charge;

    }
    public Customer createCustomer(String token, String email) throws Exception {
        Map<String, Object> customerParams = new HashMap<String, Object>();
        customerParams.put("email", email);
        customerParams.put("source", token);
        return Customer.create(customerParams);
    }

    public Charge chargeCustomerCard(String customerId, Double amount) throws Exception {

        Stripe.apiKey = "sk_test_51KUrCWSGmt3oFQM9Pi9lBV8NJHqc5eZhEXFqgLz8mdwv8Yv3fKI4g9zfe7VAdk8ozx4JyEVASDxXGEIHFFOKws9300JFnpk9vL";


        String sourceCard = Customer.retrieve(customerId).getDefaultSource();
        Map<String, Object> chargeParams = new HashMap<String, Object>();
        chargeParams.put("amount", amount);
        chargeParams.put("currency", "USD");
        chargeParams.put("customer", customerId);
        chargeParams.put("source", sourceCard);
        Charge charge = Charge.create(chargeParams);
        return charge;
    }
}