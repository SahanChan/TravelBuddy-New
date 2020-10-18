package com.example.travelbuddy;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class SitesActivity extends AppCompatActivity {


    ListView listView;
    String[] siteNames = {"Sigiriya","Mihintale","Negombo Beach","World's end","Sigiriya","Mihintale","Negombo Beach","World's end","Sigiriya","Mihintale","Negombo Beach","World's end"};
    String[] sitesDesc = {"Sigirya description","Mihintale description","negombo beach description ","World end description","Sigirya description","Mihintale description","negombo beach description ","World end description","Sigirya description","Mihintale description","negombo beach description ","World end description"};
    Integer[] imgId = {R.drawable.sigiriya, R.drawable.mihintale, R.drawable.negombobeach, R.drawable.worldsend, R.drawable.sigiriya, R.drawable.mihintale, R.drawable.negombobeach, R.drawable.worldsend, R.drawable.sigiriya, R.drawable.mihintale, R.drawable.negombobeach, R.drawable.worldsend};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sites);

        listView=(ListView)findViewById(R.id.listview);

        CustomListView customListView = new CustomListView( this,siteNames,sitesDesc,imgId);
        listView.setAdapter(customListView);

    }
}