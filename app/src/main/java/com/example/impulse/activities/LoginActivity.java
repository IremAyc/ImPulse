package com.example.impulse.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.impulse.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    private EditText userEmailEt,userPasswordEt;
    private Button loginBtn;
    private FirebaseAuth mAuth;
//irem deneme push commenti
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
       /* if (mAuth.getCurrentUser() != null) {
            startActivity(new Intent(LoginActivity.this, UsersActivity.class));
            finish();
        } */
        userEmailEt = (EditText) findViewById(R.id.user_email_login_et);
        userPasswordEt = (EditText) findViewById(R.id.user_password_login_et);
        loginBtn = (Button) findViewById(R.id.button_login);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = userEmailEt.getText().toString().trim();
                final String password = userPasswordEt.getText().toString().trim();
                if (!email.isEmpty() && !password.isEmpty()) {
                    login(email, password);
                } else {
                    Toast.makeText(getApplicationContext(), "Email ya da Parola boş bırakılamaz!", Toast.LENGTH_LONG).show();
                    mAuth.signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    // If sign in fails, display a message to the user. If sign in succeeds
                                    // the auth state listener will be notified and logic to handle the
                                    // signed in user can be handled in the listener.
                                    if (!task.isSuccessful()) {
                                        // there was an error
                                        if (password.length() < 6) {
                                            userPasswordEt.setError(getString(R.string.minimum_password));
                                        } else {
                                            Toast.makeText(LoginActivity.this, getString(R.string.auth_failed), Toast.LENGTH_LONG).show();
                                        }
                                    } else {
                                        Intent intentLogin = new Intent(LoginActivity.this, UsersActivity.class);
                                        startActivity(intentLogin);
                                        finish();
                                    }
                                }
                            });
                }
            }
        });

    }
    private void login(String userEmail, String userPassword) {
        startActivity(new Intent(LoginActivity.this, UsersActivity.class));
        finish();
    }
}

