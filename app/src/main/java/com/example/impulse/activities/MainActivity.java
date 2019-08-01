package com.example.impulse.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.impulse.R;

public class MainActivity extends AppCompatActivity {
    private Button btnWelcomeLogin, btnWelcomeRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnWelcomeLogin=(Button)findViewById(R.id.btnWelcomeLogin);
        btnWelcomeRegister=(Button)findViewById(R.id.btnWelcomeRegister);
        btnWelcomeLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLogin=new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intentLogin);
            }
        });
        btnWelcomeRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentRegister=new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intentRegister);

            }
        });
    }
}
