package inc.bugfree.instacare.service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.InputStream;

@Service
public class FirebaseService {

    @PostConstruct
    public void initializer() throws Exception {
        InputStream serviceAccount = this.getClass().getClassLoader().getResourceAsStream("./serviceAccountKey.json");
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://cse110-elderly-care.firebaseio.com")
                .build();

        FirebaseApp.initializeApp(options);
    }

    public Firestore getFirestore(){
        return FirestoreClient.getFirestore();
    }

}
