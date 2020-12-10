package inc.bugfree.instacare.service;

import inc.bugfree.instacare.bean.AddressBean;
import inc.bugfree.instacare.bean.UserBean;
import inc.bugfree.instacare.dao.AddressDao;
import inc.bugfree.instacare.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;


@Service
public class AddressService {

    private UserDao userDao = null;
    private AddressDao addressDao = null;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
    public void setAddressDao(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    public AddressBean getAddressByAddressId(String userId,String addressId) throws InterruptedException, ExecutionException {
        return addressDao.getAddressByAddressId(userId,addressId);
    }

    public String updateDefaultAddress(String userId, String defaultAddressId)  throws InterruptedException, ExecutionException {
        Map<String, Object> updateData = new HashMap<>();
        updateData.put("defaultAddressId",defaultAddressId);
        return userDao.updateUser(userId, updateData);
    }

    public List<AddressBean> getAddressByUserId(String userId) throws InterruptedException, ExecutionException {
        return addressDao.getAddressByUserId(userId);
    }

    public AddressBean getDefaultAddressByUserId(String userId) throws InterruptedException, ExecutionException {
        UserBean userBean = userDao.getUserById(userId);

        return this.getAddressByAddressId(userBean.getId(),userBean.getDefaultAddressId());
    }

    public String insertAddress(String userId, AddressBean addressBean) throws InterruptedException, ExecutionException {
//        UserBean userBean = new UserBean();
        addressBean.setUserId(userId);
//        userBean.setUserType(userType);
        return addressDao.insertAddress(addressBean);
    }

    public String updateAddress(String userId, String addressId, Map<String, Object> updateData) throws ExecutionException, InterruptedException {
        return addressDao.updateAddress(userId, addressId, updateData);
    }

    public String deleteAddress(String userId, String addressId) throws ExecutionException, InterruptedException {
        return addressDao.deleteAddress(userId, addressId);
    }
}
