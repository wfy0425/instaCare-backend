package inc.bugfree.instacare.bean;

import com.google.cloud.firestore.annotation.PropertyName;

import java.util.Date;
import java.util.List;

public class RequestBean {
    private String id;
    private String seniorId;
    private String volunteerId;
    private String volunteer;
    private String title;
    private String phoneNumber;
    private String requestContent;
    private Integer commentsId;
    private List<Integer> tagsId;
    private List<String> tags;
    private Integer type;
    private Integer status;
    private Date createTime;
    private Date pendingTime;
    private Date openTime;
    private boolean neededPhysicalContact;
    private boolean maskedPhoneNumber;
    private Integer ratingId;
    private Integer addressID;
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getVolunteer() {
        return volunteer;
    }

    public void setVolunteer(String volunteer) {
        this.volunteer = volunteer;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @PropertyName("senior_id")
    public String getSeniorId() {
        return seniorId;
    }

    @PropertyName("senior_id")
    public void setSeniorId(String seniorId) {
        this.seniorId = seniorId;
    }

    @PropertyName("volunteer_id")

    public String getVolunteerId() {
        return volunteerId;
    }

    @PropertyName("volunteer_id")
    public void setVolunteerId(String volunteerId) {
        this.volunteerId = volunteerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @PropertyName("phone_number")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @PropertyName("phone_number")
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @PropertyName("request_content")
    public String getRequestContent() {
        return requestContent;
    }

    @PropertyName("request_content")
    public void setRequestContent(String requestContent) {
        this.requestContent = requestContent;
    }

    @PropertyName("comments_id")
    public Integer getCommentsId() {
        return commentsId;
    }

    @PropertyName("comments_id")
    public void setCommentsId(Integer commentsId) {
        this.commentsId = commentsId;
    }

    @PropertyName("tags_id")
    public List<Integer> getTagsId() {
        return tagsId;
    }

    @PropertyName("tags_id")
    public void setTagsId(List<Integer> tagsId) {
        this.tagsId = tagsId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @PropertyName("create_time")
    public Date getCreateTime() {
        return createTime;
    }

    @PropertyName("create_time")
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @PropertyName("pending_time")
    public Date getPendingTime() {
        return pendingTime;
    }

    @PropertyName("pending_time")
    public void setPendingTime(Date pendingTime) {
        this.pendingTime = pendingTime;
    }

    @PropertyName("open_time")
    public Date getOpenTime() {
        return openTime;
    }

    @PropertyName("open_time")
    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    @PropertyName("needed_physical_contact")
    public boolean isNeededPhysicalContact() {
        return neededPhysicalContact;
    }

    @PropertyName("needed_physical_contact")
    public void setNeededPhysicalContact(boolean neededPhysicalContact) {
        this.neededPhysicalContact = neededPhysicalContact;
    }

    @PropertyName("masked_phone_number")
    public boolean isMaskedPhoneNumber() {
        return maskedPhoneNumber;
    }

    @PropertyName("masked_phone_number")
    public void setMaskedPhoneNumber(boolean maskedPhoneNumber) {
        this.maskedPhoneNumber = maskedPhoneNumber;
    }

    @PropertyName("rating_id")
    public Integer getRatingId() {
        return ratingId;
    }

    @PropertyName("rating_id")
    public void setRatingId(Integer ratingId) {
        this.ratingId = ratingId;
    }

    public Integer getAddressID() {
        return addressID;
    }

    public void setAddressID(Integer addressID) {
        this.addressID = addressID;
    }

    @Override
    public String toString() {
        return "RequestBean{" +
                "id='" + id + '\'' +
                ", seniorId='" + seniorId + '\'' +
                ", volunteerId='" + volunteerId + '\'' +
                ", volunteer='" + volunteer + '\'' +
                ", title='" + title + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", requestContent='" + requestContent + '\'' +
                ", commentsId=" + commentsId +
                ", tagsId=" + tagsId +
                ", tags=" + tags +
                ", type=" + type +
                ", status=" + status +
                ", createTime=" + createTime +
                ", pendingTime=" + pendingTime +
                ", openTime=" + openTime +
                ", neededPhysicalContact=" + neededPhysicalContact +
                ", maskedPhoneNumber=" + maskedPhoneNumber +
                ", ratingId=" + ratingId +
                ", addressID=" + addressID +
                ", address='" + address + '\'' +
                '}';
    }
}
