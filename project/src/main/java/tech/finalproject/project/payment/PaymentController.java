package tech.finalproject.project.payment;

import com.stripe.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PaymentController {

    private StripeClient stripeClient;


    @Autowired
    PaymentController(StripeClient stripeClient) {
        this.stripeClient = stripeClient;
    }



    @PostMapping("/auction/payments/charge")
    public PaymentIntent chargeCard(HttpServletRequest request) throws Exception {
        String token = request.getHeader("token");
        Double amount = Double.parseDouble(request.getHeader("amount"));
          return stripeClient.chargeCreditCard(token, amount);
//        return stripeClient.chargeCustomerCard(token, amount);
    }



}

