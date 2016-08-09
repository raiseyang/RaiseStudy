package com.raise.raisestudy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.raise.raisestudy.viewpagerroll.RollActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click_viewpager(View view) {
        startActivity(new Intent(this, RollActivity.class));
    }
}
