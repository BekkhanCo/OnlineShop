package com.example.onlineshopping;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.onlineshopping.ui.ShopActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, ShopActivity.class);
                intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TASK | intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

            }
        }, 3000);
    }
}
//     style="@style/Widget.MaterialComponents.TextInputLayout.OutlinedBox"
//             android:layout_margin="10dp"
//             app:boxCornerRadiusBottomEnd="10dp"
//             app:boxCornerRadiusBottomStart="10dp"
//             app:boxCornerRadiusTopEnd="10dp"
//             app:boxCornerRadiusTopStart="10dp"