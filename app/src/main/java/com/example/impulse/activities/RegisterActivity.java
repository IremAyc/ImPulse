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

public class RegisterActivity extends AppCompatActivity {
    private EditText userNameRegisterEt,userEmailRegisterEt,userPasswordRegisterEt, userBirthDayRegisterEt,
            userSeriNoRegisterEt,userSeriNoPasswordRegisterdEt;
    private Button btnRegisterLogin;
    private String name,email,password,birthDay,seriNo,seriNoPassword;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();
        userNameRegisterEt=(EditText)findViewById(R.id.user_name_register_et);
        userEmailRegisterEt=(EditText)findViewById(R.id.user_email_register_et);
        userPasswordRegisterEt=(EditText)findViewById(R.id.user_password_register_et);
        userBirthDayRegisterEt=(EditText)findViewById(R.id.user_birthday_register_et);
        userSeriNoRegisterEt=(EditText)findViewById(R.id.user_seri_no_register_et);
       userSeriNoPasswordRegisterdEt=(EditText)findViewById(R.id.user_seri_password_register_et);
        btnRegisterLogin=(Button)findViewById(R.id.btnRegisterLogin);
        btnRegisterLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getUserInfoAndRegister();
            }
        });

    }

    private void getUserInfoAndRegister() {
        name=userNameRegisterEt.getText().toString().trim();
        email = userEmailRegisterEt.getText().toString().trim();
        password = userPasswordRegisterEt.getText().toString().trim();
        birthDay= userBirthDayRegisterEt.getText().toString().trim();
        seriNo=userSeriNoRegisterEt.getText().toString().trim();
        seriNoPassword=userSeriNoPasswordRegisterdEt.getText().toString();


        if(!email.isEmpty() && !password.isEmpty() && !name.isEmpty() && !birthDay.isEmpty() && !seriNo.isEmpty()
        && !seriNoPassword.isEmpty()){
            register();
            if (password.length() < 6) {
                Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
                return;
            }
        }else
            Toast.makeText(getApplicationContext(), "Kayıt için tüm alanları doldurunuz!", Toast.LENGTH_LONG).show();
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Toast.makeText(RegisterActivity.this, "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Toast.makeText(RegisterActivity.this, "Authentication failed." + task.getException(),
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                            getUserInfoAndRegister();
                        }
                    }
                });

    }
    private void register() {
       Toast.makeText(getApplicationContext(), "Kayıt İşlemi Başarılı", Toast.LENGTH_SHORT).show();
       Intent registerIntent = new Intent(RegisterActivity.this, LoginActivity.class);
       startActivity(registerIntent);
    }
}

