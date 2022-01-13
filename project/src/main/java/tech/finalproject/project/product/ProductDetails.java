package tech.finalproject.project.product;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import tech.finalproject.project.productImage.Image;

import javax.persistence.*;
import java.io.File;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "product_details")
public class ProductDetails implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false , name = "product_id")
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


//    @OneToOne(mappedBy = "image_id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Image image;

    private String productImage;


//    private File productImage;

    public ProductDetails() {
    }

    public ProductDetails(Long id, String productName, String categoryName, String productDescription, Date startDate, Date endDate, Long startBid , String productImage) {
        this.id = id;
        this.productName = productName;
        this.categoryName = categoryName;
        this.productDescription = productDescription;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startBid = startBid;
        this.productImage = productImage;
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

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

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
                ", productImage='" + productImage + '\'' +
                '}';
    }


//    public File getProductImage() {
//        return productImage;
//    }
//
//    public void setProductImage(File productImage) {
//        this.productImage = productImage;
//    }


}
