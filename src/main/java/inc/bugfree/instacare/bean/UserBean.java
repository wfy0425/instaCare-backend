package inc.bugfree.instacare.bean;

import com.google.gson.annotations.SerializedName;
import com.google.cloud.firestore.annotation.PropertyName;

import java.util.Date;
import java.util.List;


//@AllArgsConstructor
//@NoArgsConstructor
public class UserBean {

    private String id;
    private String fullName;
    private Date createdAt;
    private Integer userType;
    private String email;
    @Deprecated
    private String password;
    private String avatar;
    private Integer rating;
    @Deprecated
    private List<Integer> requestList;
    private String description;
    private String phone;
    //TODO deprecated
    private List<String> addressList;
    private String defaultAddressId;
    private Integer accumulativeRating;
    private Integer numOfRating;
    private String blacklisted;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

//    @PropertyName("full_name")
    public String getFullName() {
        return fullName;
    }

//    @PropertyName("full_name")
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

//    @PropertyName("created_at")
    public Date getCreatedAt() {
        return createdAt;
    }

//    @PropertyName("created_at")
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

//    @PropertyName("usertype")
    public Integer getUserType() {
        return userType;
    }

//    @PropertyName("usertype")
    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Deprecated
    public String getPassword() {
        return password;
    }

    @Deprecated
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

    @Deprecated
//    @PropertyName("request_list")
    public List<Integer> getRequestList() {
        return requestList;
    }

    @Deprecated
//    @PropertyName("request_list")
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

//    @PropertyName("address_list")
    public List<String> getAddressList() {
        return addressList;
    }

//    @PropertyName("address_list")
    public void setAddressList(List<String> addressList) {
        this.addressList = addressList;
    }

//    @PropertyName("accumulative_rating")
    public Integer getAccumulativeRating() {
        return accumulativeRating;
    }

//    @PropertyName("accumulative_rating")
    public void setAccumulativeRating(Integer accumulativeRating) {
        this.accumulativeRating = accumulativeRating;
    }

//    @PropertyName("num_of_rating")
    public Integer getNumOfRating() {
        return numOfRating;
    }

//    @PropertyName("num_of_rating")
    public void setNumOfRating(Integer numOfRating) {
        this.numOfRating = numOfRating;
    }

    public String getBlacklisted() {
        return blacklisted;
    }

    public void setBlacklisted(String blacklisted) {
        this.blacklisted = blacklisted;
    }

//    @PropertyName("default_address_id")
    public String getDefaultAddressId() {
        return defaultAddressId;
    }

//    @PropertyName("default_address_id")
    public void setDefaultAddressId(String defaultAddressId) {
        this.defaultAddressId = defaultAddressId;
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
