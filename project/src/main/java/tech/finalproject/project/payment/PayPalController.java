//package tech.finalproject.project.payment;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.Map;
//
//@RestController
//@RequestMapping(value = "/paypal")
//public class PayPalController {
//
//
//        private final PayPalClient payPalClient;
//        @Autowired
//        PayPalController(PayPalClient payPalClient){
//            this.payPalClient = payPalClient;
//        }
//
//        @PostMapping(value = "auction/make/payment")
//        public Map<String, Object> makePayment(@RequestParam("sum") String sum){
//            return payPalClient.createPayment(sum);
//        }
//
//        @PostMapping(value = "auction/complete/payment")
//        public Map<String, Object> completePayment(HttpServletRequest request){
//            return payPalClient.completePayment(request);
//        }
//}
