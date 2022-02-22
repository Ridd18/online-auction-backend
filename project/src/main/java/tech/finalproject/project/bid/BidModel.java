package tech.finalproject.project.bid;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Entity
public class BidModel implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @NotNull
    @Pattern(regexp = "[a-zA-Z]*")
    private String bidderName;

    @NotNull
    @Pattern(regexp = "[0-9]*")
    private String bidAmount;

    @NotNull
    @Pattern(regexp = "[a-zA-Z]*")
    private String productName;

    @NotNull
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date endDate;

    @NotNull
    private Long productId;

}
