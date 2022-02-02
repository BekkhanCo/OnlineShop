package com.example.onlineshopping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.onlineshopping.mySqlDatabase.CollectionMijoz;
import com.example.onlineshopping.ui.ShopActivity;
import com.example.onlineshopping.objects.MijozModel;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {
    Button mLoginButton;
    EditText eEmail, ePassword;
    TextView tRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mLoginButton = findViewById(R.id.loginBtn);
        eEmail = findViewById(R.id.emailEt);
        ePassword = findViewById(R.id.passwordEt);
        tRegister = findViewById(R.id.registerTv);

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = eEmail.getText().toString();
                String parol = ePassword.getText().toString();
                ArrayList<MijozModel> mijozModels = CollectionMijoz.getMijoz();
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    eEmail.setError("Invalid Email");
                    eEmail.setFocusable(true);
                }
                if (ePassword.length() < 6) {
                    ePassword.setError("Password length");
                    ePassword.setFocusable(true);
                }

                boolean a = false;
                for (int i = 0; i < mijozModels.size(); i++) {
                    if (eEmail.getText().toString().equals(mijozModels.get(i).getEmail())) {
                        if (ePassword.getText().toString().equals(mijozModels.get(i).getParol())) {
                            a = true;
                            break;

                        }
                    }

                }
                if (a) {
                    Intent intent = new Intent(LoginActivity.this, ShopActivity.class);
                    intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TASK | intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);

                } else {
                    Toast.makeText(LoginActivity.this, "parol yoki login hato", Toast.LENGTH_SHORT).show();
                }

            }
        });


        tRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

    }
}