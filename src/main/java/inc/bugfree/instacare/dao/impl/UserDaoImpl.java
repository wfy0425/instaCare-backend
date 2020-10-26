package inc.bugfree.instacare.dao.impl;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import inc.bugfree.instacare.bean.UserBean;
import inc.bugfree.instacare.dao.UserDao;
import inc.bugfree.instacare.service.FirebaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class UserDaoImpl implements UserDao {

    @Autowired
    private FirebaseService db;

    @Override
    public List<UserBean> findAll() throws Exception {
        List<UserBean> userList = new ArrayList<UserBean>();
        Firestore firestore = db.getFirestore();
        CollectionReference employee = firestore.collection("users");
        ApiFuture<QuerySnapshot> future = employee.get();
        for (QueryDocumentSnapshot document : future.get().getDocuments()) {
            UserBean user = document.toObject(UserBean.class);
            userList.add(user);
        }
        return userList;
    }

    @Override
    public List<UserBean> getByCourse(String department, String courseCode) {
        return null;
    }


}
