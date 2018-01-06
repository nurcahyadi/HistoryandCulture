package com.example.android.portfolio;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.android.portfolio.Jakarta.ListviewBajudaerahJakarta;
import com.example.android.portfolio.Jakarta.ListviewBatikJakarta;
import com.example.android.portfolio.Jakarta.ListviewMakananJakarta;
import com.example.android.portfolio.Jakarta.ListviewSejarahJakarta;
import com.example.android.portfolio.Jakarta.ListviewTarianJakarta;
import com.google.firebase.auth.FirebaseAuth;

public class NavigationDrawerJakarta extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer_jakarta);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.root_layout, new FragmentMenuJakarta());
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_drawer_jakarta, menu);
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
        int id = item.getItemId();
        switch (id) {
            case R.id.nav_home:
//                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//                fragmentTransaction.replace(R.id.root_layout, new FragmentMenuJakarta());
//                fragmentTransaction.commit();
                Intent intent0 = new Intent(NavigationDrawerJakarta.this, pilihKota.class);
                startActivity(intent0);
                break;
            case R.id.nav_batik:
                Intent intent1 = new Intent(NavigationDrawerJakarta.this, ListviewBatikJakarta.class);
                startActivity(intent1);
                break;
            case R.id.nav_tarian:
                Intent intent2 = new Intent(NavigationDrawerJakarta.this, ListviewTarianJakarta.class);
                startActivity(intent2);
                break;
            case R.id.nav_makanan:
                Intent intent3 = new Intent(NavigationDrawerJakarta.this, ListviewMakananJakarta.class);
                startActivity(intent3);
                break;
            case R.id.nav_bajudaerah:
                Intent intent4 = new Intent(NavigationDrawerJakarta.this, ListviewBajudaerahJakarta.class);
                startActivity(intent4);
                break;
            case R.id.nav_sejarah:
                Intent intent5 = new Intent(NavigationDrawerJakarta.this, ListviewSejarahJakarta.class);
                startActivity(intent5);
                break;
            case R.id.nav_signout:
                FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
                firebaseAuth.signOut();
                Intent intent = new Intent(this, LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                break;
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
