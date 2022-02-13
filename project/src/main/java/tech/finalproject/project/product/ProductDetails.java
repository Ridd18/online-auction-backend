package tech.finalproject.project.product;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import tech.finalproject.project.bid.BidModel;
import tech.finalproject.project.productImage.Image;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.Serializable;
import java.util.*;

@Entity

@Table(name = "product_details")
public class ProductDetails implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false , name = "product_id")
    private Long id;
    @NotNull
    private String productName;
    private String categoryName;
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

//    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private Collection<Image> images = new ArrayList<Image>();


//    private String productImage;


//    private File productImage;
//
    @Column(name = "name")
    private String productImageName;

//
//    @Column(name = "type")
//    private String ProductImageType;
//
//    @Column(name = "image", unique = false, nullable = false, length = 10000000)
//    private byte[] ProductImage;


    public ProductDetails() {
    }


    public ProductDetails(Long id, String productName, String categoryName, String productDescription, Date startDate, Date endDate, Long startBid, String productImageName) {
        this.id = id;
        this.productName = productName;
        this.categoryName = categoryName;
        this.productDescription = productDescription;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startBid = startBid;
        this.productImageName = productImageName;
    }


    public String getProductImageName() {
        return productImageName;
    }

    public void setProductImageName(String productImageName) {
        this.productImageName = productImageName;
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

    
//
//    public Set<BidModel> getBids() {
//        return bids;
//    }
//
//    public void setBids(Set<BidModel> bids) {
//        this.bids = bids;
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
                ", productImageName='" + productImageName + '\'' +
//                ", bids=" + bids +
                '}';
    }


}
