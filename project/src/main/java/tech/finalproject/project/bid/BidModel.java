package tech.finalproject.project.bid;

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

    private Date startDate;

    public BidModel() {
    }

    public BidModel(Long id, String bidderName, String bidAmount, String productName, Date startDate) {
        this.id = id;
        this.bidderName = bidderName;
        this.bidAmount = bidAmount;
        this.productName = productName;
        this.startDate = startDate;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "Model{" +
                "id=" + id +
                ", bidderName='" + bidderName + '\'' +
                ", bidAmount='" + bidAmount + '\'' +
                ", productName='" + productName + '\'' +
                ", startDate=" + startDate +
                '}';
    }
}
