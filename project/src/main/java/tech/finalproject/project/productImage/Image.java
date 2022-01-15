package tech.finalproject.project.productImage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.finalproject.project.product.ProductDetails;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "image")
@Builder
public class Image {
    @Id
    @Column(name = "image_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "path")
    private String path;

    @Column(name = "type")
    private String type;

    @Column(name = "image", unique = false, nullable = true, length = 10000000)
    private byte[] image;


    @ManyToOne()
    @JoinColumn(name = "product_id")
    private ProductDetails product;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public ProductDetails getProduct() {
        return product;
    }

    public void setProduct(ProductDetails product) {
        this.product = product;
    }

    public Image() {
    }

    public Image(Long id, String name, String path, String type, byte[] image, ProductDetails product) {
        this.id = id;
        this.name = name;
        this.path = path;
        this.type = type;
        this.image = image;
        this.product = product;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", type='" + type + '\'' +
                ", image=" + Arrays.toString(image) +
                ", product=" + product +
                '}';
    }

}


//

//@Entity
//@Table(name = "image")
//public class Image {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(nullable = false, updatable = false)
//    private Long id;
//
//    private String imageName;
//
//    private byte[] image;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getImageName() {
//        return imageName;
//    }
//
//    public void setImageName(String imageName) {
//        this.imageName = imageName;
//    }
//
//
//    public byte[] getImage() {
//        return image;
//    }
//    public void setImage(byte[] image) {
//        this.image = image;
//    }
//
//    public Image(String imageName, byte[] image) {
//        this.imageName = imageName;
//        this.image = image;
//    }
//
//    public Image() {
//
//    }
//
//    @Override
//    public String toString() {
//        return "Image{" +
//                "id=" + this.id +
//                ", imageName='" + this.imageName + '\'' +
//                ", image=" + Arrays.toString(this.image) +
//                '}';
//    }
//}
