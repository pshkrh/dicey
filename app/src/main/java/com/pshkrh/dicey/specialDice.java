package com.pshkrh.dicey;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class specialDice extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_special_dice);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.nav);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);

        mToolbar = (Toolbar) findViewById((R.id.nav_actionbar));
        setSupportActionBar(mToolbar);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        ImageButton rollButton = (ImageButton) findViewById(R.id.rollButton);

        final ImageView spDice = (ImageView) findViewById(R.id.img_spdice);

        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Dicey" , "The button has been pressed!");

                Random rng = new Random();

                int x;

                int num1 = rng.nextInt(20);

                Log.d("Dicey", "Random Number 1 is " + num1);

                final int diceArr[] = {
                        R.drawable.sdice1,
                        R.drawable.sdice2,
                        R.drawable.sdice3,
                        R.drawable.sdice4,
                        R.drawable.sdice5,
                        R.drawable.sdice6,
                        R.drawable.sdice7,
                        R.drawable.sdice8,
                        R.drawable.sdice9,
                        R.drawable.sdice10,
                        R.drawable.sdice11,
                        R.drawable.sdice12,
                        R.drawable.sdice13,
                        R.drawable.sdice14,
                        R.drawable.sdice15,
                        R.drawable.sdice16,
                        R.drawable.sdice17,
                        R.drawable.sdice18,
                        R.drawable.sdice19,
                        R.drawable.sdice20
                };
                spDice.setImageResource(diceArr[num1]);
            }
        });



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
            Intent intent = new Intent(specialDice.this, onedice.class);
            startActivity(intent);
            finish();
        }

        if(id == R.id.twodice){
            Intent intent = new Intent(specialDice.this, MainActivity.class);
            startActivity(intent);
            finish();
        }

        if(id == R.id.threedice){
            Intent intent = new Intent(specialDice.this, threeDice.class);
            startActivity(intent);
            finish();
        }

        if(id == R.id.specialdice){
            Toast.makeText(this, "You are already here!",Toast.LENGTH_SHORT).show();
        }
        return false;
    }
}
