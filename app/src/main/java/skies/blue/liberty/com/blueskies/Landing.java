package skies.blue.liberty.com.blueskies;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by simthembile on 2017/09/30.
 */

public class Landing extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.landing_page);
    }

    public void design_best_life(View view) {
        Intent intent = new Intent(this, DesignYourBestLife.class);
        intent.putExtra("Design", "Design");
        startActivity(intent);
    }

    public void completeProfile(View view) {
        Intent intent = new Intent(this, Profile.class);
        intent.putExtra("Profile", "Profile");
        startActivity(intent);
    }

    public void bestLife(View view) {
        Intent intent = new Intent(this, BestLife.class);
        intent.putExtra("Design", "Design");
        startActivity(intent);
    }

}
