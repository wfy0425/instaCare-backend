package inc.bugfree.instacare.bean;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.google.cloud.firestore.annotation.PropertyName;

import java.util.Date;
import java.util.List;


//@AllArgsConstructor
//@NoArgsConstructor
public class UserBean {

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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvater() {
        return avater;
    }

    public void setAvater(String avater) {
        this.avater = avater;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public List<Integer> getRequestList() {
        return requestList;
    }

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

    public List<String> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<String> addressList) {
        this.addressList = addressList;
    }

    public Integer getAccumulativeRating() {
        return accumulativeRating;
    }

    public void setAccumulativeRating(Integer accumulativeRating) {
        this.accumulativeRating = accumulativeRating;
    }

    public Integer getNumOfRating() {
        return numOfRating;
    }

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
                ", avater='" + avater + '\'' +
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
