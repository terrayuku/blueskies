package skies.blue.liberty.com.blueskies;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by simthembile on 2017/09/30.
 */

public class Continue extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.continue_profile);
    }

    public void blue_life(View view) {
        Intent intent = new Intent(this, BestLife.class);
        intent.putExtra("Best Life", "Best Life");
        startActivity(intent);
    }
}
