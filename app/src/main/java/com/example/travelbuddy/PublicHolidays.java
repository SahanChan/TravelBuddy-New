package com.example.travelbuddy;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class PublicHolidays extends AppCompatActivity {

    ListView listview;

    String[] holidays ={"Duruthu Full Moon Poya Day","Tamil Thai Pongal Day","Independence Day of Sri Lanka","Navam Full Moon Poya Day","Maha Shivratri","Madin Full Moon Poya Day","Bak Full Moon Poya Day", "Good Friday","Sinhalese New Year","Sinhalese New Year's Eve","Tamil New Year's Eve","Puthandu","Labour Day","Vesak","Day following Vesak","Eid al-Fitr","Poson Full Moon Poya Day","Asalha Puja","Nikini Full Moon Poya Day","Binara Full Moon Poya Day","Vap Full Moon Poya Day"};
    String[] holidates ={"Fri, Jan 10, 2020","Wed, Jan 15, 2020","Tue, Feb 4, 2020","Sat, Feb 8, 2020","Fri, Feb 21, 2020","Mon, Mar 9, 2020","Tue, Apr 7, 2020","Fri, Apr 10, 2020","Mon, Apr 13, 2020","Mon, Apr 13, 2020","Mon, Apr 13, 2020","Tue, Apr 14, 2020","Fri, May 1, 2020","Thu, May 7, 2020","Fri, May 8, 2020","May 24 – 25, 2020","Fri, Jun 5, 2020","Sun, Jul 5, 2020","Mon, Aug 3, 2020","Tue, Sep 1, 2020","Thu, Oct 1, 2020"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_public_holidays);

        listview = (ListView) findViewById(R.id.listview);

        CustomHolidayListView customHolidayListView = new CustomHolidayListView(this,holidays,holidates);
        listview.setAdapter(customHolidayListView);
    }
}