package com.example.onlineshopping;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.onlineshopping.mySqlDatabase.CollectionMijoz;
import com.example.onlineshopping.mySqlDatabase.InsertMijoz;
import com.example.onlineshopping.ui.ShopActivity;

import java.sql.SQLException;

public class RegisterActivity extends AppCompatActivity {
    EditText emailEt, passwordEt, nameEt, phoneEt;
    Button registerBtn;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        emailEt = findViewById(R.id.emailEt);
        passwordEt = findViewById(R.id.passwordEt);
        nameEt = findViewById(R.id.nameEt);
        phoneEt = findViewById(R.id.phoneEt);
        registerBtn = findViewById(R.id.registerBtn);
        pd = new ProgressDialog(this);
        pd.setMessage("Register User...");

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd.dismiss();
                String email = emailEt.getText().toString();
                String parol = passwordEt.getText().toString();
                String name = nameEt.getText().toString();
                String phone = phoneEt.getText().toString();


                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    emailEt.setError("Invalid Email");
                    emailEt.setFocusable(true);
                }
                if (passwordEt.length() < 6) {
                    passwordEt.setError("Password length");
                    passwordEt.setFocusable(true);
                }
                if (nameEt.equals("")) {
                    nameEt.setError("First name is empty");
                    nameEt.setFocusable(true);
                }
                if (phone.equals("")) {
                    phoneEt.setError("Phone number is wrong!");
                    phoneEt.setFocusable(true);
                }
                if (Patterns.EMAIL_ADDRESS.matcher(email).matches() && parol.length() >= 6 && !name.equals(null) && !phone.equals(null)) {

                    try {

                        if (CollectionMijoz.testUser(emailEt.getText().toString())) {
                            boolean natija = InsertMijoz.mijozKirit(emailEt.getText().toString(), passwordEt.getText().toString(), nameEt.getText().toString(), phoneEt.getText().toString());
                            Intent intent = new Intent(RegisterActivity.this, ShopActivity.class);
                            intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TASK | intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                            Toast.makeText(RegisterActivity.this, "saqlandi", Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(RegisterActivity.this, "Bu login bor", Toast.LENGTH_SHORT).show();
                            emailEt.setText("");
                            passwordEt.setText("");
                            nameEt.setText("");
                            phoneEt.setText("");
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        });


    }
}