package com.saidus.snapanonym.presentation.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.saidus.snapanonym.R;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
   // ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //imageView = findViewById(R.id.main_background);
        //Glide.with(this).load(R.drawable.IMAG).into(imageView);
    }


    public void onExploreSnaps(View view) {
        Intent intent = new Intent(this, SnapListActivity.class);
        startActivity(intent);
    }

    public void onPublishSnap(View view) {
    }
}
