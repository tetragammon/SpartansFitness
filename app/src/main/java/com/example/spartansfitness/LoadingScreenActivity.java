package com.example.spartansfitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

//SplashScreen - the loading screen that load before starting the app
public class LoadingScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_screen);
        ProgressBar progressBar = findViewById(R.id.progressBar);
        ImageView imageView = findViewById(R.id.approved);
        imageView.setVisibility(View.VISIBLE);


        YoYo.with(Techniques.RollIn)
                .repeat(0)
                .duration(2000)
                .playOn(imageView);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(LoadingScreenActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        },4000);
    }
}