package com.example.onlineshopping.Korzinka;

import android.view.View;

public interface ItemClickListenerplus {
    void onItemClickListener(View v, int position);

    void onMinusClickListener(int position);

    void onPlusClickListener(int position);
}
