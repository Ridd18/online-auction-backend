package tech.finalproject.project.bid;

import com.fasterxml.jackson.annotation.JsonFormat;
import tech.finalproject.project.product.ProductDetails;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.Date;


@Entity
public class BidModel implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    private String bidderName;

    private String bidAmount;

    private String productName;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date endDate;

    private Long productId;


    public BidModel() {
    }

    public BidModel(Long id, String bidderName, String bidAmount, String productName, Date endDate, Long productId) {
        this.id = id;
        this.bidderName = bidderName;
        this.bidAmount = bidAmount;
        this.productName = productName;
        this.endDate = endDate;
        this.productId = productId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBidderName() {
        return bidderName;
    }

    public void setBidderName(String bidderName) {
        this.bidderName = bidderName;
    }

    public String getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(String bidAmount) {
        this.bidAmount = bidAmount;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "BidModel{" +
                "id=" + id +
                ", bidderName='" + bidderName + '\'' +
                ", bidAmount='" + bidAmount + '\'' +
                ", productName='" + productName + '\'' +
                ", endDate=" + endDate +
                ", productId=" + productId +
                '}';
    }
}
