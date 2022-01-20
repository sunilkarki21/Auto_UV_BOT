package com.example.uv_cbot;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

public class AboutActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        //naming toolbar
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null)
        {
            actionBar.setTitle("About Us");
        }
        // setting back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // adding content to the about page\

         View aboutPage = new AboutPage(this)
                .isRTL(false)
                .setImage(R.drawable.logo)

                .addItem(new Element().setTitle("Version 1.0.0"))
                 .setDescription(" This is Autonomous UV Disinfection Robot.")
                .addGroup("CONNECT WITH US!")
                .addEmail("Your mail id ")
                .addWebsite("www.google.com")
                .addFacebook("www.facebook.com")
                .addTwitter("www.twitter.com")
                .addYoutube("www.youtube.com")
                .addItem(createCopyright())
                .create();

        setContentView(aboutPage);
    }
    private Element createCopyright()
    {
        Element copyright = new Element();

        final String copyrightString = String.format("Copyright @ %d", Calendar.getInstance().get(Calendar.YEAR));
        copyright.setTitle(copyrightString);
        copyright.setGravity(Gravity.CENTER);
        copyright.setIconDrawable(R.drawable.logo);
        copyright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AboutActivity.this,copyrightString,Toast.LENGTH_SHORT).show();
            }
        });
        return copyright;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onSupportNavigateUp() {
         onBackPressed();
         return  true;
    }
}
