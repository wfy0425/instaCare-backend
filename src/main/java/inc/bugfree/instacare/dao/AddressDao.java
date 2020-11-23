package inc.bugfree.instacare.dao;


import inc.bugfree.instacare.bean.AddressBean;
import inc.bugfree.instacare.bean.UserBean;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Repository
public interface AddressDao {
    AddressBean getAddressByAddressId(String userId,String addressId) throws InterruptedException, ExecutionException;

    List<AddressBean> getAddressByUserId(String userId) throws InterruptedException, ExecutionException;

    String insertAddress(AddressBean addressBean) throws InterruptedException, ExecutionException;
    String updateAddress(String userId, String addressId, Map<String, Object> updateData) throws ExecutionException, InterruptedException;
}