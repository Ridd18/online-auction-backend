package tech.finalproject.project.product;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
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
    @Pattern(regexp = "[a-zA-Z]*")
    private String productName;

    @Pattern(regexp = "[a-zA-Z]*")
    private String categoryName;

    @NotNull
    private String productDescription;

    @NotNull
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date startDate;

    @NotNull
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date endDate;

    @NotNull
    private Long startBid;

    @NotNull
    @Column(name = "ImageName")
    private String productImageName;

}
