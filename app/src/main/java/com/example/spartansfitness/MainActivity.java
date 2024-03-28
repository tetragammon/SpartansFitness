package com.example.spartansfitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.QuickContactBadge;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout mLogoView;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLogoView = findViewById(R.id.logo_view);
        Button buttonLogin = findViewById(R.id.button_login);
        Button buttonRegister = findViewById(R.id.button_register);
        ImageView facebookLink = findViewById(R.id.facebook_link);
        ImageView instagramLink = findViewById(R.id.instagram_link);
        ImageView linkedLink = findViewById(R.id.linkedin_link);

        //adding sharedPreferences - if user is already logged in you dont need to enter credentials anymore
        sharedPreferences = getSharedPreferences("SpartanFitness", MODE_PRIVATE);

        if(sharedPreferences.getString("logged","false").equals("true")){
            Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
            startActivity(intent);
            finish();
        }
        //adding action on Login button press
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Animating elements before redirect when pushing Login button
                YoYo.with(Techniques.FadeOutUp)
                        .duration(700)
                        .repeat(0)
                        .playOn(mLogoView);

                YoYo.with(Techniques.FadeOutDown)
                        .duration(700)
                        .repeat(0)
                        .playOn(buttonLogin);

                YoYo.with(Techniques.FadeOutDown)
                        .duration(700)
                        .repeat(0)
                        .playOn(buttonRegister);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }
                },1000);
            }
        });
        //adding action on Register button press
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Animating elements before redirect when pushing Register button
                YoYo.with(Techniques.FadeOutUp)
                        .duration(700)
                        .repeat(0)
                        .playOn(mLogoView);

                YoYo.with(Techniques.FadeOutDown)
                        .duration(700)
                        .repeat(0)
                        .playOn(buttonLogin);

                YoYo.with(Techniques.FadeOutDown)
                        .duration(700)
                        .repeat(0)
                        .playOn(buttonRegister);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                        startActivity(intent);
                        finish();
                    }
                },1000);

            }
        });
        //adding action on Facebook image press
        facebookLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.facebook.com/profile.php?id=100001098170054"));
                startActivity(intent);
            }
        });

        //adding action on Instagram image press
        instagramLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.instagram.com/tetragammon/"));
                startActivity(intent);
            }
        });

        //adding action on LinkedIn image press
        linkedLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.linkedin.com/in/laurentiu-cerghedean-73923696/"));
                startActivity(intent);
            }
        });
    }
}