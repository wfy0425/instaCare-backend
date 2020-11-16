package inc.bugfree.instacare.dao.impl;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import inc.bugfree.instacare.bean.RequestBean;
import inc.bugfree.instacare.bean.UserBean;
import inc.bugfree.instacare.dao.UserDao;
import inc.bugfree.instacare.service.FirebaseService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Component
public class UserDaoImpl implements UserDao {

    private final FirebaseService db;

    public UserDaoImpl(FirebaseService db) {
        this.db = db;
    }

    @Override
    public List<UserBean> getAll() throws Exception {
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

//     @Override
//     public void saveUserType(UserBean user){
//         Firestore firestore = db.getFirestore();
//         CollectionReference users = firestore.collection("users");
//         HashMap<String, Integer> map = new HashMap<>();
//         map.put("userType", user.getUserType());
//         users.document().set(map);
//     }

    @Override
    public UserBean getUserById(String id)  throws InterruptedException, ExecutionException {
        Firestore dbFirestore = db.getFirestore();
         DocumentReference documentReference = dbFirestore.collection("users").document(id);
//        DocumentReference userProfile = documentReference.collection("userProfile").document(id);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();

//        UserBean userBean = null;

        if(document.exists()) {
            return document.toObject(UserBean.class);
        }else {
            return null;
        }
    }

    @Override
    public String addUser(UserBean userBean) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = db.getFirestore();
         DocumentReference docRef = dbFirestore.collection("users").document(userBean.getId());
//        DocumentReference userProfile = docRef.collection("userProfile").document(userBean.getId());
        ApiFuture<WriteResult> result = docRef.create(userBean);
        return result.get().getUpdateTime().toString();
    }

    @Override
    public String updateUser(String userId, Map<String, Object> updateData) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = db.getFirestore();
        DocumentReference docRef = dbFirestore.collection("users").document(userId);
        ApiFuture<WriteResult> result = docRef.update(updateData);
        return result.get().getUpdateTime().toString();
    }

//    @Override
//    public String setUser(UserBean userBean) throws ExecutionException, InterruptedException {
//        Firestore dbFirestore = db.getFirestore();
//        DocumentReference docRef = dbFirestore.collection("users").document(userBean.getId());
//        ApiFuture<WriteResult> result = docRef.set(userBean);
//        return result.get().getUpdateTime().toString();
//    }
}
