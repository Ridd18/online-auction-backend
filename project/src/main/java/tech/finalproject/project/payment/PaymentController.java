package tech.finalproject.project.payment;

import com.stripe.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import tech.finalproject.project.buyer.BidderModel;
import tech.finalproject.project.buyer.BuyerService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

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

