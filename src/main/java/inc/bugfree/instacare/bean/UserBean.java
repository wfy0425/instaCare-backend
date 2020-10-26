package inc.bugfree.instacare.bean;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
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

}
