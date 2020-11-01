package inc.bugfree.instacare.dao.impl;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import inc.bugfree.instacare.bean.UserBean;
import inc.bugfree.instacare.dao.UserDao;
import inc.bugfree.instacare.service.FirebaseService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Component
public class UserDaoImpl implements UserDao {

    @Autowired
    private FirebaseService db;

    @Override
    public List<UserBean> findAll() throws Exception {
        List<UserBean> userList = new ArrayList<UserBean>();
        Firestore firestore = db.getFirestore();
        CollectionReference users = firestore.collection("users");
        ApiFuture<QuerySnapshot> apiFuture = users.get();
        for (QueryDocumentSnapshot document : apiFuture.get().getDocuments()) {
            UserBean user = document.toObject(UserBean.class);
            userList.add(user);
        }
        return userList;
    }

    @Override
    public List<UserBean> getByCourse(String department, String courseCode) {
        return null;
    }

    @Override
    public void saveUserType(UserBean user){
        Firestore firestore = db.getFirestore();
        CollectionReference users = firestore.collection("users");
        HashMap<String, Integer> map = new HashMap<>();
        map.put("userType", user.getUserType());
        users.document().set(map);
    }
}
