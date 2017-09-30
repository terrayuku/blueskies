package skies.blue.liberty.com.blueskies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void login(View view) {
        Intent intent = new Intent(this, Login.class);
        intent.putExtra("Login", "Login");
        startActivity(intent);
    }

    public void register(View view) {
        Intent intent = new Intent(this, Registration.class);
        intent.putExtra("Registration", "Registration");
        startActivity(intent);
    }
}
