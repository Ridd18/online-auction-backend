package tech.finalproject.project.product;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.*;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Entity
@Table(name = "product_model")
public class ProductModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false , name = "product_id")
    private Long id;

    @NotNull
    @NotBlank
    @Pattern(regexp = "[a-zA-Z]*")
    private String productName;

    @NotBlank
    @Pattern(regexp = "[a-zA-Z]*")
    private String categoryName;

    @NotNull
    @NotBlank
    private String productDescription;

    @NotNull
    @NotBlank
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date startDate;

    @NotNull
    @NotBlank
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date endDate;

    @NotNull
    @NotBlank
    private Long startBid;

    @NotNull
    @NotBlank
    @Column(name = "ImageName")
    private String productImageName;

}
