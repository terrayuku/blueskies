package skies.blue.liberty.com.blueskies;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by simthembile on 2017/09/30.
 */

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
    }

    public void btnContinue(View view) {
        Intent intent = new Intent(this, Continue.class);
        intent.putExtra("Continue", "Continue");
        startActivity(intent);
    }
}
