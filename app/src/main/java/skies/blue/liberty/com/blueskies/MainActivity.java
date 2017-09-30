package skies.blue.liberty.com.blueskies;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import skies.blue.liberty.com.blueskies.models.Utils;

public class MainActivity extends AppCompatActivity {

//    CallbackManager mCallbackManager;

    AccessToken accessToken;
    AccessTokenTracker accessTokenTracker;
    FirebaseAuth mAuth;

    CallbackManager mCallbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FacebookSdk.sdkInitialize(this.getApplicationContext());

        accessToken = AccessToken.getCurrentAccessToken();

        // Initialize Facebook Login button
        mCallbackManager = CallbackManager.Factory.create();

        accessTokenTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {

            }
        };

//        accessToken = AccessToken.getCurrentAccessToken();


        LoginButton loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions("email", "public_profile");
        loginButton.registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.d("FB-LOGIN", "facebook:onSuccess:" + loginResult);
                mAuth = FirebaseAuth.getInstance();
                handleFacebookAccessToken(loginResult.getAccessToken());
            }

            @Override
            public void onCancel() {
                Log.d("LOGIN_CANCEL", "facebook:onCancel");
                // ...
            }

            @Override
            public void onError(FacebookException error) {
                Log.d("FB-ERROR", "facebook:onError", error);
                // ...
            }
        });
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Pass the activity result back to the Facebook SDK
        mCallbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        accessTokenTracker.startTracking();
    }

    private void handleFacebookAccessToken(AccessToken token) {
        Log.d("ACCESS_TOKEN", "handleFacebookAccessToken:" + token);

        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("SIGN-IN", "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Utils.saveSharedSetting(getApplicationContext(), "email", user.getEmail());
//                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("FAILURE", "signInWithCredential:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Authenticate Failed", Toast.LENGTH_SHORT).show();
//                            updateUI(null);
                        }

                        // ...
                    }
                });
    }
}
