package skies.blue.liberty.com.blueskies;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import skies.blue.liberty.com.blueskies.models.DesignYourBestLifeModel;
import skies.blue.liberty.com.blueskies.models.ProfileModel;
import skies.blue.liberty.com.blueskies.models.Utils;

/**
 * Created by simthembile on 2017/09/30.
 */

public class Profile extends AppCompatActivity {

    EditText fullName;
    EditText age;
    EditText proffession;
    EditText annualIncome;
    TextView userEmail;
    CheckBox car;
    CheckBox owningHouse;
    CheckBox permanent;

    boolean isCar;
    boolean isOwningHouse;
    boolean isPermanent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        fullName = (EditText)findViewById(R.id.txtName);
        age = (EditText)findViewById(R.id.editText2);
        proffession = (EditText)findViewById(R.id.txtproffession);
        annualIncome = (EditText)findViewById(R.id.txtIncome);
        userEmail = (TextView)findViewById(R.id.userEmail);
        userEmail.setText(Utils.readSharedSetting(getApplicationContext(), "email", "liberty-user"));

        car = (CheckBox)findViewById(R.id.ckCar);
        owningHouse = (CheckBox)findViewById(R.id.ckHouse);
        permanent = (CheckBox)findViewById(R.id.ckPermanent);

        car.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                Toast.makeText(getApplicationContext() , b + "" , Toast.LENGTH_SHORT).show();
                isCar = b;
            }
        });

        owningHouse.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                Toast.makeText(getApplicationContext() , b + "" , Toast.LENGTH_SHORT).show();
                isOwningHouse = b;
            }
        });

        permanent.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                Toast.makeText(getApplicationContext() , b + "" , Toast.LENGTH_SHORT).show();
                isPermanent = b;
            }
        });
    }

    public void btnContinue(View view) {
        Intent intent = new Intent(this, BestLife.class);

        if(fullName.getText().toString() != null && age.getText().toString() != null && proffession.getText().toString() != null
                && annualIncome.getText().toString() != null) {

            ProfileModel userProfile = new ProfileModel(fullName.getText().toString(),
                    age.getText().toString(), proffession.getText().toString(), annualIncome.getText().toString(), userEmail.getText().toString(),
                    isCar, isOwningHouse, isPermanent);

            try {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference ref = database.getReference();
                DatabaseReference bestLifeRef = ref.child("profiles");

                DatabaseReference bestNodePushRef = bestLifeRef.push();

                bestNodePushRef.setValue( userProfile);



            } catch (Exception firebaseDatabase) {

            }

        }
        intent.putExtra("Best Life", "Best Life");
        startActivity(intent);
    }
}
