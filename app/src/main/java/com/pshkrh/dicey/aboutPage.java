package com.pshkrh.dicey;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class aboutPage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_page);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.nav);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);

        mToolbar = (Toolbar) findViewById((R.id.nav_actionbar));
        setSupportActionBar(mToolbar);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.onedice){
            Intent intent = new Intent(aboutPage.this, onedice.class);
            startActivity(intent);
            finish();
        }

        if(id == R.id.twodice){
            Intent intent = new Intent(aboutPage.this, MainActivity.class);
            startActivity(intent);
            finish();
        }

        if(id == R.id.threedice){
            Intent intent = new Intent(aboutPage.this, threeDice.class);
            startActivity(intent);
            finish();
        }

        if(id == R.id.specialdice){
            Intent intent = new Intent(aboutPage.this, specialDice.class);
            startActivity(intent);
            finish();
        }

        if(id == R.id.about){
            Toast.makeText(this, "You are already here!", Toast.LENGTH_SHORT).show();
        }

        if(id == R.id.contact){
            //Toast.makeText(this, "Send an e-mail to pshkrh@gmail.com for queries.", Toast.LENGTH_SHORT).show();
            Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
            emailIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            emailIntent.setType("vnd.android.cursor.item/email");
            emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[] {"pshkrh@gmail.com"});
            emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Feedback / Query regarding Dicey");
            emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "");
            startActivity(Intent.createChooser(emailIntent, "Send mail using..."));
        }
        return false;
    }
}