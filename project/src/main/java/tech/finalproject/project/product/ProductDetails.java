package tech.finalproject.project.product;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.File;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table
public class ProductDetails implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String productName;
    private String categoryName;
    private String productDescription;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="MM-dd-yyyy")
    private Date startDate;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="MM-dd-yyyy")
    private Date endDate;
    private Long startBid;

//    private File productImage;

    public ProductDetails() {
    }

    public ProductDetails(Long id, String productName, String categoryName, String productDescription, Date startDate, Date endDate, Long startBid, File productImage) {
        this.id = id;
        this.productName = productName;
        this.categoryName = categoryName;
        this.productDescription = productDescription;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startBid = startBid;
//        this.productImage = productImage;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Long getStartBid() {
        return startBid;
    }

    public void setStartBid(Long startBid) {
        this.startBid = startBid;
    }

//    public File getProductImage() {
//        return productImage;
//    }
//
//    public void setProductImage(File productImage) {
//        this.productImage = productImage;
//    }

    @Override
    public String toString() {
        return "ProductDetails{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", startBid=" + startBid +
                '}';
    }

//
//    @Override
//    public String toString() {
//        return "ProductDetails{" +
//                "productId=" + id +
//                ", productName='" + productName + '\'' +
//                ", categoryName='" + categoryName + '\'' +
//                ", productDescription='" + productDescription + '\'' +
//                ", startDate=" + startDate +
//                ", endDate=" + endDate +
//                ", startBid=" + startBid +
////                ", productImage=" + productImage +
//                '}';
//    }
}
