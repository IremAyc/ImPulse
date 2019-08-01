package com.example.impulse.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.example.impulse.R;
import com.example.impulse.activities.MainActivity;
import com.example.impulse.fragments.HistoryFragment;
import com.example.impulse.fragments.HomeFragment;
import com.example.impulse.fragments.ProfileFragment;

public class UsersActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        /*USERS ekranında home fragment gözüküyor

        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame_layout_users, new HomeFragment());
        ft.commit();
        navigationView.setCheckedItem(R.id.nav_home); */
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.users, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.frame_layout_users, new HomeFragment());
            ft.commit();
            /*
            Intent homeIntent=new Intent(UsersActivity.this,HomeActivity.class);
            startActivity(homeIntent); */
            // Handle the camera action
        } else if (id == R.id.nav_history) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.frame_layout_users, new HistoryFragment());
            ft.commit();

        }else if(id == R.id.nav_users){
             Intent usersIntent= new Intent(getApplicationContext(), UsersActivity.class);
             startActivity(usersIntent);

        } else if (id == R.id.nav_profile) {
            FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.frame_layout_users, new ProfileFragment());
            ft.commit();

        } else if (id == R.id.nav_logout) {
            Intent intent=new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
