package tech.finalproject.project.bid;

import java.util.Date;

public class BidResponse {

    private String bidderName;

    private String bidAmount;

    private String productName;

    private Date startDate;

    public BidResponse(String bidderName, String bidAmount, String productName, Date startDate) {
        this.bidderName = bidderName;
        this.bidAmount = bidAmount;
        this.productName = productName;
        this.startDate = startDate;
    }

    public BidResponse() {
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
        return "BidResponse{" +
                "bidderName='" + bidderName + '\'' +
                ", bidAmount='" + bidAmount + '\'' +
                ", productName='" + productName + '\'' +
                ", startDate=" + startDate +
                '}';
    }
}
