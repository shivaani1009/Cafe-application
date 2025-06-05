package com.example.availability_service.config;


@Configuration
public class FirebaseConfig {

    @Bean
    public FirebaseApp firebaseApp() {
        try {
            InputStream serviceAccount = getClass().getResourceAsStream("/resources/serviceAccountKey.json");
            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://cafe-app-963c3-default-rtdb.asia-southeast1.firebasedatabase.app/")
                    .build();
            return FirebaseApp.initializeApp();
        } catch (IllegalStateException e) {
            // FirebaseApp is already initialized
            return FirebaseApp.getInstance();
        }
    }

    @Bean
    public FirebaseAuth firebaseAuth(FirebaseApp firebaseApp) {
        return FirebaseAuth.getInstance(firebaseApp);
    }
}