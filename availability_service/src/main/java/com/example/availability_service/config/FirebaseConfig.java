package com.example.availability_service.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.FirebaseDatabase;   
import com.google.firebase.auth.FirebaseAuth;
import java.io.InputStream;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseOptions;
import java.io.IOException;
import com.google.firebase.database.DatabaseReference;

@Configuration
public class FirebaseConfig {

    @Bean
    public FirebaseApp firebaseApp() throws IOException {
        try {
            // Don't include 'resources' in the path
            InputStream serviceAccount = getClass().getClassLoader().getResourceAsStream("serviceAccountKey.json");

            if (serviceAccount == null) {
                throw new IOException("Firebase serviceAccountKey.json not found in resources folder.");
            }

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://cafe-app-963c3-default-rtdb.asia-southeast1.firebasedatabase.app/")
                    .build();

            return FirebaseApp.initializeApp(options);
        } catch (IllegalStateException e) {
            // FirebaseApp is already initialized
            return FirebaseApp.getInstance();
        }
    }

    @Bean
    public FirebaseAuth firebaseAuth(FirebaseApp firebaseApp) {
        return FirebaseAuth.getInstance(firebaseApp);
    }

    @Bean
    public DatabaseReference databaseReference(FirebaseApp firebaseApp) {
        return FirebaseDatabase.getInstance(firebaseApp).getReference();
    }
}
