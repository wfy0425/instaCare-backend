package inc.bugfree.instacare.bean;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.google.cloud.firestore.annotation.PropertyName;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;


//@AllArgsConstructor
//@NoArgsConstructor
public class UserBean  implements UserDetails {

    private Integer id;
    private String fullName;
    private Date createdAt;
    private Integer userType;
    private String email;
    private String password;
    private String avatar;
    private Integer rating;
    private List<Integer> requestList;
    private String description;
    private String phone;
    private List<String> addressList;
    private Integer accumulativeRating;
    private Integer numOfRating;
    private String blacklisted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @PropertyName("full_name")
    public String getFullName() {
        return fullName;
    }

    @PropertyName("full_name")
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @PropertyName("created_at")
    public Date getCreatedAt() {
        return createdAt;
    }

    @PropertyName("created_at")
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @PropertyName("usertype")
    public Integer getUserType() {
        return userType;
    }

    @PropertyName("usertype")
    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list = new ArrayList<>();
        list.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                switch (userType) {
                    case 1:
                        return "ADMIN";
                    default:
                        return "USER";
                }

            }
        });
        return list;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @PropertyName("request_list")
    public List<Integer> getRequestList() {
        return requestList;
    }

    @PropertyName("request_list")
    public void setRequestList(List<Integer> requestList) {
        this.requestList = requestList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @PropertyName("address_list")
    public List<String> getAddressList() {
        return addressList;
    }

    @PropertyName("address_list")
    public void setAddressList(List<String> addressList) {
        this.addressList = addressList;
    }

    @PropertyName("accumulative_rating")
    public Integer getAccumulativeRating() {
        return accumulativeRating;
    }

    @PropertyName("accumulative_rating")
    public void setAccumulativeRating(Integer accumulativeRating) {
        this.accumulativeRating = accumulativeRating;
    }

    @PropertyName("num_of_rating")
    public Integer getNumOfRating() {
        return numOfRating;
    }

    @PropertyName("num_of_rating")
    public void setNumOfRating(Integer numOfRating) {
        this.numOfRating = numOfRating;
    }

    public String getBlacklisted() {
        return blacklisted;
    }

    public void setBlacklisted(String blacklisted) {
        this.blacklisted = blacklisted;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", createdAt=" + createdAt +
                ", userType=" + userType +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", avatar='" + avatar + '\'' +
                ", rating=" + rating +
                ", requestList=" + requestList +
                ", description='" + description + '\'' +
                ", phone='" + phone + '\'' +
                ", addressList=" + addressList +
                ", accumulativeRating=" + accumulativeRating +
                ", numOfRating=" + numOfRating +
                ", blacklisted='" + blacklisted + '\'' +
                '}';
    }
}
