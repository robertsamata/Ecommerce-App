package com.example.ecommerce;
import android.os.Bundle;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Callback;
import okhttp3.Call;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.content.Intent;
import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {
    private static final String PREFS_NAME = "MyPrefs";
    private static final String KEY_USERNAME = "robert";
    private static final String KEY_PASSWORD = "wqewqe";
    private EditText usernameEditText, passwordEditText;
    private Button loginButton;

    private Button mapsButton;
    private SharedPreferences sharedPreferences;

    private Realm realm;
    private OkHttpClient client;

    private Button servici;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button mapsButton = findViewById(R.id.mapsButton);
        mapsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, NavigateActivity.class);
                startActivity(intent);
            }});
        realm = Realm.getDefaultInstance();
        // Exemplu de inserare a unui utilizator in baza de date
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                User user = new User();
                user.setId("1");
                user.setUsername("robert");
                user.setPassword("wqewqe");
                realm.copyToRealmOrUpdate(user);
            }
        });
        // Exemplu de interogare a utilizatorilor si afisare a numarului de utilizatori în baza de date
        long userCount = realm.where(User.class).count();
        Toast.makeText(this, "Numărul de utilizatori: " + userCount, Toast.LENGTH_SHORT).show();

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);
        client = new OkHttpClient();

        servici = findViewById(R.id.servici);
        servici.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = "Servici";
                String message = "Serviciul a pornit";

                // Cream și pornim serviciul pentru a afișa notificarea
                Intent intent = new Intent(MainActivity.this, NotificationService.class);
                intent.putExtra("title", title);
                intent.putExtra("message", message);
                startService(intent);}});

        sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        Button showNotificationButton = findViewById(R.id.show_notification_button);
        showNotificationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationHelper notificationHelper = new NotificationHelper();
                notificationHelper.createNotification(MainActivity.this, "Notificare", "Reduceri", DestinationActivity.class);
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                performServerRequest();
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if (validateLogin(username, password)) {
                    Intent intent = new Intent(MainActivity.this, ProductActivity.class);
                    startActivity(intent);
                    saveLoginDetails(username, password);
                    // Navigare catre pagina principala sau alta activitate după autentificare cu succes
                } else {
                    Toast.makeText(MainActivity.this, "Autentificare eșuată. Verifică datele de autentificare.", Toast.LENGTH_SHORT).show();
                    // Afișeaza un mesaj de eroare
                }
            }
        }

        );
    }
@Override
    protected void onDestroy() {
    super.onDestroy();
    realm.close();
}
    private void performServerRequest(){
        String url = "https://ecomerce.com/login";
        Request request = new Request.Builder()
                .url(url)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, "Cererea a eșuat", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                // Manipulați răspunsul de la server
                final String responseBody = response.body().string();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // Actualizam interfata utilizatorului cu rezultatul raspunsului
                        Toast.makeText(MainActivity.this, "Functioneaza " + responseBody, Toast.LENGTH_SHORT).show();
                    }
                });
            }
}
        );}

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    };

    private boolean validateLogin(String username, String password) {
        RealmResults<User> results = realm.where(User.class)
                .equalTo("username", username)
                .equalTo("password", password)
                .findAll();
        return results.size()>0;
    }

    private void saveLoginDetails(String username, String password) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_USERNAME, username);
        editor.putString(KEY_PASSWORD, password);
        editor.apply();
    }

    // Metoda pentru a verifica dacă utilizatorul este deja autentificat
    private boolean isLoggedIn() {
        String username = sharedPreferences.getString(KEY_USERNAME, null);
        String password = sharedPreferences.getString(KEY_PASSWORD, null);
        return username != null && password != null;
    }
}
