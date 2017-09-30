package skies.blue.liberty.com.blueskies;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by simthembile on 2017/09/30.
 */

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
    }

    public void landing(View view) {
        Intent intent = new Intent(this, Landing.class);
        intent.putExtra("Landing", "Landing");
        startActivity(intent);
    }


}
