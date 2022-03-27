package tech.finalproject.project.payment;

import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import tech.finalproject.project.buyer.BidderModel;
import tech.finalproject.project.buyer.BuyerNotFoundException;

import java.util.List;
import java.util.UUID;

@Service
public class PaymentService {

    private final PaymentRepo paymentRepo;

    public PaymentService(PaymentRepo paymentRepo) {
        this.paymentRepo = paymentRepo;
    }


    public PaymentModel addPayment(PaymentModel paymentModel)
    {
//        paymentModel.setPaymentId(UUID.randomUUID().toString());
        return paymentRepo.save(paymentModel);
    }


    public List<PaymentModel> findAllBuyers()
    {

        return paymentRepo.findAll();
    }

    public PaymentModel updatePayment(PaymentModel paymentModel)
    {

        return paymentRepo.save(paymentModel);
    }

    public PaymentModel findPaymentById(Long id)
    {
        return paymentRepo.findPaymentById(id).
                orElseThrow(()-> new BuyerNotFoundException("Buyer by id" + id + "was not found"));
    }


    public void deletePayment(Long id)
    {

        paymentRepo.deletePaymentById(id);
    }

    public long countPayments()
    {
        return paymentRepo.count();
    }

}
