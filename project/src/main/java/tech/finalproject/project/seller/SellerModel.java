package tech.finalproject.project.seller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
@Table(name = "seller_model")
public class SellerModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @NotNull
    @NotBlank
    @Pattern(regexp = "[a-zA-Z]*")
    private String name;

    @NotNull
    @NotBlank(message = "UserName is mandatory")
    @Pattern(regexp = "[a-zA-Z0-9]*")
    private String username;

    @NotNull
    @NotBlank
    @Size(min = 8, message = "Password should have min 8 characters")
    private String password;

    @NotNull
    @NotBlank
    @Pattern(regexp="(^$|[0-9]{10})")
    private String phoneNo;

    @NotNull
    @NotBlank
    @Pattern (regexp = "(^(.+)@(\\S+)$)")
    private String email;


}
