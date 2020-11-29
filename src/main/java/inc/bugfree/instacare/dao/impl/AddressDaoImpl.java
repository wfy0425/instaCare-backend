package inc.bugfree.instacare.dao.impl;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import inc.bugfree.instacare.bean.AddressBean;
import inc.bugfree.instacare.bean.RequestBean;
import inc.bugfree.instacare.bean.UserBean;
import inc.bugfree.instacare.dao.AddressDao;
import inc.bugfree.instacare.dao.UserDao;
import inc.bugfree.instacare.service.FirebaseService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Component
public class AddressDaoImpl implements AddressDao {

    private final FirebaseService db;

    public AddressDaoImpl(FirebaseService db) {
        this.db = db;
    }

    @Override
    public AddressBean getAddressByAddressId(String userId,String addressId) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = db.getFirestore();
        DocumentReference documentReference = dbFirestore.collection("users").document(userId)
                .collection("address").document(addressId);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();

        if(document.exists()) {
            return document.toObject(AddressBean.class);
        }else {
            return null;
        }
    }

    @Override
    public List<AddressBean> getAddressByUserId(String userId) throws InterruptedException, ExecutionException {
        List<AddressBean> list = new ArrayList<>();
        Firestore dbFirestore = db.getFirestore();
        CollectionReference colRef = dbFirestore.collection("users").document(userId)
                .collection("address");
        ApiFuture<QuerySnapshot> apiFuture = colRef.get();
        for (QueryDocumentSnapshot document : apiFuture.get().getDocuments()) {
            AddressBean addressBean = document.toObject(AddressBean.class);
            list.add(addressBean);
        }
        return list;
    }

    @Override
    public String insertAddress(AddressBean addressBean) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = db.getFirestore();
        DocumentReference docRef = dbFirestore.collection("users").document(addressBean.getUserId())
                .collection("address").document();
        addressBean.setAddressId(docRef.getId());
        ApiFuture<WriteResult> result = docRef.create(addressBean);
        return docRef.getId();
    }


    @Override
    public String updateAddress(String userId, String addressId, Map<String, Object> updateData) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = db.getFirestore();
        DocumentReference docRef = dbFirestore.collection("users").document(userId)
                .collection("address").document(addressId);
        ApiFuture<WriteResult> result = docRef.update(updateData);
        return result.get().getUpdateTime().toString();
    }
}
