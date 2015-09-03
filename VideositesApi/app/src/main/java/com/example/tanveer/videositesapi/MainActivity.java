package com.example.tanveer.videositesapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements OnItemClickListener{
    private ListView webList;
    private String[] category={
        "Archive",
            "Social",
            "Social",
            "food",
            "Travel",
            "Food",
            "Movies",
            "fashion",
            "fashion",
            "fashion",
            "Sports",
            "Sports",
            "Sports",
            "Adult",
            "Adult",
            "Adult",
            "Adult",
            "Adult",
            "Adult",
            "Adult"

    };
    private String[] links ={
            "https://archive.org/details/movies",
            "https://www.nowness.com/",
            "http://www.liveleak.com/",
            "http://www.foodnetwork.com/videos.html",
            "http://www.travelchannel.com/video",
            "http://www.marthastewart.com/",
            "http://moviezoot.com/",
            "http://www.fashiontv.com/",
            "http://video.style.com",
            "http://elle.com/videos/",
            "http://break.com",
            "http://ndtv.com",
            "http://espn.go.com/video/",
            "http://home-made-videos.com",
            "http://wifemovies.net",
            "http://submityourflicks.com",
            "http://firstanalvideos.com",
            "http://privatehomeclips.com",
            "http://cuckold69.com",
            "http://Homemoviestube.com"

};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webList = (ListView) findViewById(R.id.vidList);
        ArrayAdapter<String> adapter =new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,category);
        webList.setAdapter(adapter);
        webList.setOnItemClickListener(this);

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent i =new Intent(MainActivity.this,WebActivity.class);
        i.putExtra("uri",links[position]);
        startActivity(i);
    }
}
