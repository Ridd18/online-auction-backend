package tech.finalproject.project.payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
@Table(name = "payment_model")
public class PaymentModel implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @NotNull
    @NotBlank(message = "Name is mandatory")
    @Pattern(regexp = "[a-zA-Z]*")
    private String name;


    private Number bidAmount;

    @NotNull
    @NotBlank
    private String cardNumber;

    @NotNull
    @NotBlank
//    @Max(2)
    private String month;

    @NotNull
    @NotBlank
//    @Max(2)
    private String year;

    @NotNull
    @NotBlank
//    @Max(3)
    private String cvv;

    @NotNull
    @NotBlank
    @Column(nullable = false, updatable = false)
    private String paymentId;


}
