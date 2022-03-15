package tech.finalproject.project.payment;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.finalproject.project.buyer.BidderModel;

import java.util.Optional;

public interface PaymentRepo extends JpaRepository<PaymentModel , Long> {

    void deletePaymentById(Long id);


    Optional<PaymentModel> findPaymentById(Long id);

}
