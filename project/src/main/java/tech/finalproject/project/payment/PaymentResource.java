package tech.finalproject.project.payment;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import tech.finalproject.project.buyer.BidderModel;
import tech.finalproject.project.buyer.BuyerService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/auction")
public class PaymentResource {

        private final PaymentService paymentService;

        public PaymentResource(PaymentService paymentService)
        {
            this.paymentService = paymentService;
        }

    @GetMapping("/payment/all")
        public ResponseEntity<List<PaymentModel>> getAllPayments()
        {
            List<PaymentModel> payment = paymentService.findAllBuyers();
            return new ResponseEntity<>(payment, HttpStatus.OK);
        }

        @GetMapping("/payment/find/{id}")
        public ResponseEntity<PaymentModel> getPaymentById(@PathVariable("id") Long id)
        {
            PaymentModel payment = paymentService.findPaymentById(id);
            return new ResponseEntity<>(payment, HttpStatus.OK);
        }


        @PostMapping("/payment/add")
        public ResponseEntity<PaymentModel> addPayment(@RequestBody PaymentModel paymentModel)
        {

            paymentModel.setPaymentId(UUID.randomUUID().toString());
            PaymentModel newPayment = paymentService.addPayment(paymentModel);
            return new ResponseEntity<>(newPayment, HttpStatus.CREATED);
        }



        @PutMapping("/payment/update")
        public ResponseEntity<PaymentModel> updatePayment(@RequestBody PaymentModel paymentModel)
        {
            PaymentModel updatePayment = paymentService.updatePayment(paymentModel);
            return new ResponseEntity<>(updatePayment, HttpStatus.OK );
        }

        @Transactional
        @DeleteMapping("/payment/delete/{id}")
        public ResponseEntity<?> deletePayment(@PathVariable("id") Long id)
        {
            paymentService.deletePayment(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }

    }
