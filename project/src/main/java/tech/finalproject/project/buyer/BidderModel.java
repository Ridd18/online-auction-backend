package tech.finalproject.project.buyer;

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
@Table(name = "bidder_model")
public class BidderModel implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @NotNull
    @Pattern(regexp = "[a-zA-Z]*")
    private String name;

    @NotNull
    @NotBlank(message = "UserName is mandatory")
    @Pattern(regexp = "[a-zA-Z0-9]*")
    private String username;

    @NotNull
    @Size(min = 8, message = "Password should have min 8 characters")
    private String password;

    @NotNull
    @Pattern(regexp="(^$|[0-9]{10})")
    private String phoneNo;

    @NotNull
    @Pattern (regexp = "(^(.+)@(\\S+)$)")
    private String email;

}
