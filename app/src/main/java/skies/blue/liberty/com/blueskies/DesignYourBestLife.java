package skies.blue.liberty.com.blueskies;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import skies.blue.liberty.com.blueskies.models.DesignYourBestLifeModel;
import skies.blue.liberty.com.blueskies.models.Utils;

/**
 * Created by simthembile on 2017/09/30.
 */

public class DesignYourBestLife extends AppCompatActivity {

    EditText home;
    EditText health;
    EditText finance;
//    TextView userEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.design_best_life);

        home = (EditText)findViewById(R.id.txtHome);
        health = (EditText)findViewById(R.id.txtHealth);
        finance = (EditText)findViewById(R.id.txtFinance);
//        userEmail = (TextView)findViewById(R.id.userEmail);
//        userEmail.setText(Utils.readSharedSetting(getApplicationContext(), "email", "liberty-user"));

    }

    public void profile(View view) {
        final Intent intent = new Intent(this, Profile.class);
        if(home.getText().toString() != null && health.getText().toString() != null && finance.getText().toString() != null) {

            DesignYourBestLifeModel designYourBestLifeModel = new DesignYourBestLifeModel(home.getText().toString(),
                    health.getText().toString(), finance.getText().toString(), "simtyuku@gmail.com");

            try {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference ref = database.getReference();
                DatabaseReference bestLifeRef = ref.child("customers");

                DatabaseReference bestNodePushRef = bestLifeRef.push();

                bestNodePushRef.setValue( designYourBestLifeModel);



            } catch (Exception firebaseDatabase) {

            }

        }
        intent.putExtra("Profile", "Profile");
        startActivity(intent);
    }
}
