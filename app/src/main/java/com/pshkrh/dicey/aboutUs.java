package com.pshkrh.dicey;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class aboutUs extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.nav);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);

        mToolbar = (Toolbar) findViewById((R.id.nav_actionbar));
        setSupportActionBar(mToolbar);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView t = findViewById(R.id.txt_info);
        t.setText("Dicey, made by Pushkar Kurhekar.\n\nWhen you're playing a board game, or any other game without a dice, you can use Dicey as a substitute for them!\n\nSpecial Thanks to Aniruddh Iyer for designing the graphics for this app. This would not have been possible without him.\n\nThanks for downloading!");
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
            Intent intent = new Intent(aboutUs.this,onedice.class);
            startActivity(intent);
            finish();
        }

        if(id == R.id.twodice){
            Intent intent = new Intent(aboutUs.this, MainActivity.class);
            startActivity(intent);
            finish();
        }

        if(id == R.id.threedice){
            Intent intent = new Intent(aboutUs.this, threeDice.class);
            startActivity(intent);
            finish();
        }

        if(id == R.id.specialdice){
            Intent intent = new Intent(aboutUs.this, specialDice.class);
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
