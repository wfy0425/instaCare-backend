package inc.bugfree.instacare.bean;

import com.google.cloud.firestore.annotation.PropertyName;

public class AddressBean {
    private String addressId;
    private String userId;
    private String geolocation;
    private String zipCode;
    private String streetAddressL1;
    private String streetAddressL2;
    private String state;
    private String city;

    @Deprecated
    private Boolean isDefault;

//    @PropertyName("address_id")
    public String getAddressId() {
        return addressId;
    }

//    @PropertyName("address_id")
    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

//    @PropertyName("user_id")
    public String getUserId() {
        return userId;
    }

//    @PropertyName("user_id")
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGeolocation() {
        return geolocation;
    }

    public void setGeolocation(String geolocation) {
        this.geolocation = geolocation;
    }

//    @PropertyName("zip_code")
    public String getZipCode() {
        return zipCode;
    }

//    @PropertyName("zip_code")
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

//    @PropertyName("street_address_l1")
    public String getStreetAddressL1() {
        return streetAddressL1;
    }

//    @PropertyName("street_address_l1")
    public void setStreetAddressL1(String streetAddressL1) {
        this.streetAddressL1 = streetAddressL1;
    }

//    @PropertyName("street_address_l2")
    public String getStreetAddressL2() {
        return streetAddressL2;
    }

//    @PropertyName("street_address_l2")
    public void setStreetAddressL2(String streetAddressL2) {
        this.streetAddressL2 = streetAddressL2;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Deprecated
//    @PropertyName("default")
    public Boolean getDefault() {
        return isDefault;
    }

    @Deprecated
//    @PropertyName("default")
    public void setDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    @Override
    public String toString() {
        return "AddressBean{" +
                "addressId=" + addressId +
                ", userId=" + userId +
                ", geolocation='" + geolocation + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", streetAddressL1='" + streetAddressL1 + '\'' +
                ", streetAddressL2='" + streetAddressL2 + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", isDefault=" + isDefault +
                '}';
    }
}
