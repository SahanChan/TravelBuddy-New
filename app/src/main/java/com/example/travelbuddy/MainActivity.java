package com.example.travelbuddy;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.travelbuddy.ui.home.HomeFragment;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    DrawerLayout drawer;
    private static final String TAG = "MainActivity";
    private static final int ERROR_DIALOG_REQUEST = 9001;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = (DrawerLayout)findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_sites, R.id.nav_social, R.id.nav_map)
                .setDrawerLayout(drawer)
                .build();


        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                if(id== R.id.nav_home){
                    fragmentTransaction.replace(R.id.nav_host_fragment,new HomeFragment());
                    fragmentTransaction.commit();
                }
                if(id== R.id.nav_sites){
                    Intent myIntent = new Intent(MainActivity.this, SitesActivity.class);
                    startActivity(myIntent);
                }
                if(id== R.id.nav_social){
                    Intent myIntent = new Intent(MainActivity.this, Register.class);
                    startActivity(myIntent);
                }
                if(id== R.id.nav_map){
                    Intent myIntent = new Intent(MainActivity.this, MapsActivity.class);
                    startActivity(myIntent);
                }
                if(id== R.id.nav_planYourTrip){
                    Intent myIntent = new Intent(MainActivity.this,PlanYourHoliday.class);
                    startActivity(myIntent);
                }
                if(id== R.id.nav_weatherNclimate){
                    Intent myIntent = new Intent(MainActivity.this, WeatherClimate.class);
                    startActivity(myIntent);
                }
                if(id== R.id.nav_viewHolidays){
                    Intent myIntent = new Intent(MainActivity.this, PublicHolidays.class);
                    startActivity(myIntent);
                }
                if(id== R.id.nav_currencyConverter){
                    Intent myIntent = new Intent(MainActivity.this, CurrencyConverter.class);
                    startActivity(myIntent);
                }
                if(id== R.id.nav_provideFeedback){
                    Intent myIntent = new Intent(MainActivity.this, ProvideFeedback.class);
                    startActivity(myIntent);
                }
                if(id== R.id.nav_contactUs){
                    Intent myIntent = new Intent(MainActivity.this, ContactUs.class);
                    startActivity(myIntent);
                }
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public boolean isServicesOK(){
        Log.d(TAG,"isServicesOK: checking google services version");
        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(MainActivity.this);
        if (available == ConnectionResult.SUCCESS){
            Log.d(TAG,"isServicesOK: google play services working");
            return true;
        }
        else if(GoogleApiAvailability.getInstance().isUserResolvableError(available)){
            Log.d(TAG,"isServicesOK: an error happened but can fix it");
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(MainActivity.this,available,ERROR_DIALOG_REQUEST);
            dialog.show();
        }
        else{
            Toast.makeText(this,"You can't make app Request ", Toast.LENGTH_SHORT).show();

        }
        return false;
    }
}