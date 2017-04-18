package com.example.system2.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.system2.R;

public class ViewActivity extends AppCompatActivity {

    private final int DISPLAY_LENGTH = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        new android.os.Handler().postDelayed(new Runnable() {
                                                 @Override
                                                 public void run() {
                                                     Intent mainIntent = new Intent(ViewActivity.this,home.class);
                                                     ViewActivity.this.startActivity(mainIntent);
                                                     ViewActivity.this.finish();
                                                 }
                                             },DISPLAY_LENGTH
        );

    }
}
