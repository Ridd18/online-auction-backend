package tech.finalproject.project.buyer;

import javax.management.relation.Role;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table()
public class BuyerLoginDetails implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    @NotNull
    private String username;

    @NotNull
    @Size(min = 8, message = "Password should have min 8 characters")
    private String password;

    @Pattern(regexp="(^$|[0-9]{10})")
    private String phoneNo;

    private String email;

    private boolean isActive;
    private boolean isNotLocked;

    private String roles;
//    @ManyToMany(fetch = FetchType.EAGER)
//    private Collection<Role> roles = new ArrayList<>();

    public BuyerLoginDetails(Long id, String name, String username, String password, String phoneNo, String email, boolean isActive, boolean isNotLocked, String roles) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.phoneNo = phoneNo;
        this.email = email;
        this.isActive = isActive;
        this.isNotLocked = isNotLocked;
        this.roles = roles;
    }

    public BuyerLoginDetails() {
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }






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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isNotLocked() {
        return isNotLocked;
    }

    public void setNotLocked(boolean notLocked) {
        isNotLocked = notLocked;
    }


    @Override
    public String toString() {
        return "BuyerLoginDetails{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", email='" + email + '\'' +
                ", isActive=" + isActive +
                ", isNotLocked=" + isNotLocked +
                ", roles='" + roles + '\'' +
                '}';
    }
}
