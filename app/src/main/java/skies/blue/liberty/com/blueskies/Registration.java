package skies.blue.liberty.com.blueskies;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import skies.blue.liberty.com.blueskies.models.*;

/**
 * Created by simthembile on 2017/09/30.
 */

public class Registration extends AppCompatActivity {

    EditText email;
    EditText password;
    EditText confirmPassword;
    TextView error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);

        email = (EditText) findViewById(R.id.user_email);
         password = (EditText) findViewById(R.id.txtPassword);
         confirmPassword = (EditText) findViewById(R.id.txtConfirm);
        error = (TextView) findViewById(R.id.txtError);
    }

    public void btnJoin(View view) {
        Intent intent = new Intent(this, Landing.class);

        System.out.println("PASSWORD: " + password.getText() + "   " + confirmPassword.getText());
//         check if password march
        if(password.getText().toString().equals(confirmPassword.getText().toString())) {
            // create user
            UserRegistration userRegistration = new UserRegistration(email.getText().toString(), password.getText().toString());
            Log.w("USER", userRegistration.toString());
            // register user
            registerUser(userRegistration);
            Log.w("REGISTRATION IF", "SUCCESS");
            startActivity(intent);
        } else {
            error.setText("Sorry, Error Occured. Password Does Not Match.");
            Log.e("REGISTRATION ELSE", "ERROR");
        }


    }
    private void registerUser(UserRegistration userRegistration) {
        final FirebaseUser firebaseUser;

        try {
            final FirebaseAuth auth = FirebaseAuth.getInstance();
            auth.createUserWithEmailAndPassword(userRegistration.getEmail(), userRegistration.getPassword())
                    .addOnSuccessListener(this, new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            FirebaseUser user = auth.getCurrentUser();
                        }

                    })
                    .addOnFailureListener(this, new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            error.setText("Couldn't Register You because: " + e.getMessage());
                        }
                    });

        } catch (Exception dbExe) {
            Log.e("REGISTRATION", "ERROR");
            Log.e("DB ERROR: ", dbExe.getMessage());
        }
    }
}
