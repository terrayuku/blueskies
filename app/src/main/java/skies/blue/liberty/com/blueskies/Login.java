package skies.blue.liberty.com.blueskies;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import skies.blue.liberty.com.blueskies.models.UserRegistration;
import skies.blue.liberty.com.blueskies.models.Utils;

/**
 * Created by simthembile on 2017/09/30.
 */

public class Login extends AppCompatActivity {

    EditText email;
    EditText password;
    TextView error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        email = (EditText)findViewById(R.id.txtEmail);
        password = (EditText)findViewById(R.id.txtPassword);
        error = (TextView) findViewById(R.id.txtError);
    }

    public void landing(View view) {
        if(password.getText().toString() != null && email.getText().toString() != null) {
            // create user
            UserRegistration userRegistration = new UserRegistration(email.getText().toString(), password.getText().toString());
            Log.w("USER", userRegistration.toString());
            // login user
            try {
                final FirebaseAuth auth = FirebaseAuth.getInstance();
                auth.signInWithEmailAndPassword(userRegistration.getEmail(), userRegistration.getPassword())
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                final FirebaseUser user = auth.getCurrentUser();

                            }
                        })
                        .addOnSuccessListener(this, new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                final FirebaseUser user = auth.getCurrentUser();
                                Utils.saveSharedSetting(getApplicationContext(), "email", user.getEmail());
                                Intent intents = new Intent(Login.this, Landing.class);
                                startActivity(intents);
                            }
                        })
                        .addOnFailureListener(this, new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                error.setText("Error Occure Because: " + e.getMessage());
                            }
                        });
            } catch (Exception e){
                Log.e("LOGIN ERROR", e.getMessage());
            }

        } else {
            error.setText("Sorry, Error Occured. Password Does Not Match.");
            Log.e("REGISTRATION ELSE", "ERROR");
        }
//        startActivity(intent);
    }

    private boolean login(UserRegistration userRegistration) {
        try {
            final FirebaseAuth auth = FirebaseAuth.getInstance();
            auth.signInWithEmailAndPassword(userRegistration.getEmail(), userRegistration.getPassword())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            final FirebaseUser user = auth.getCurrentUser();
//                            return true;
                        }
                    })
                    .addOnFailureListener(this, new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            error.setText("Error Occure Because: " + e.getMessage());
                        }
                    });
            return true;
        } catch (Exception e){
            Log.e("LOGIN ERROR", e.getMessage());
        }
        return false;
    }


}
