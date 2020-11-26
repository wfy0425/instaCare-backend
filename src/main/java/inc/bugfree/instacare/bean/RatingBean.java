package inc.bugfree.instacare.bean;

import com.google.cloud.firestore.annotation.PropertyName;

public class RatingBean {
    private String id;
    private Integer userRating;
    private String userComment;
    private Integer volunteerRating;
    private String volunteerComment;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

//    @PropertyName("user_rating")
    public Integer getUserRating() {
        return userRating;
    }

//    @PropertyName("user_rating")
    public void setUserRating(Integer userRating) {
        this.userRating = userRating;
    }

//    @PropertyName("user_comment")
    public String getUserComment() {
        return userComment;
    }

//    @PropertyName("user_comment")
    public void setUserComment(String userComment) {
        this.userComment = userComment;
    }

//    @PropertyName("volunteer_rating")
    public Integer getVolunteerRating() {
        return volunteerRating;
    }

//    @PropertyName("volunteer_rating")
    public void setVolunteerRating(Integer volunteerRating) {
        this.volunteerRating = volunteerRating;
    }

//    @PropertyName("volunteer_comment")
    public String getVolunteerComment() {
        return volunteerComment;
    }

//    @PropertyName("volunteer_comment")
    public void setVolunteerComment(String volunteerComment) {
        this.volunteerComment = volunteerComment;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "id=" + id +
                ", userRating=" + userRating +
                ", userComment='" + userComment + '\'' +
                ", volunteerRating=" + volunteerRating +
                ", volunteerComment='" + volunteerComment + '\'' +
                '}';
    }
}
