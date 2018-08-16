package com.nofegreen.chord;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MenuList extends AppCompatActivity {

    ListView mylistview;
    Toolbar mToolbar;
    private AdView mAdViewList;
    //private ArrayList mdata;
    private ArrayAdapter mAdapter;

    // Album THE BEST
    String theBest[] = {
            "Ya Maulana",
            "Ya Jamalu",
            "Ya Asyqol",
            "Rohman Ya Rohman",
            "Ya Habibal Qolbi",
            "Deen Assalam",
            "Qomarun"
    };
    Integer[] imageTheBest = {
            com.nofegreen.chord.R.drawable.ic_sentiment_very_dissatisfied_black_24dp,
            com.nofegreen.chord.R.drawable.ic_sentiment_very_dissatisfied_black_24dp,
            com.nofegreen.chord.R.drawable.ic_sentiment_very_dissatisfied_black_24dp,
            com.nofegreen.chord.R.drawable.ic_sentiment_very_dissatisfied_black_24dp,
            com.nofegreen.chord.R.drawable.ic_sentiment_very_dissatisfied_black_24dp,
            com.nofegreen.chord.R.drawable.ic_sentiment_very_dissatisfied_black_24dp,
            com.nofegreen.chord.R.drawable.ic_sentiment_very_dissatisfied_black_24dp
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.nofegreen.chord.R.layout.activity_menu_list);

        mylistview = (ListView) findViewById(com.nofegreen.chord.R.id.mylist);
        mToolbar = (Toolbar) findViewById(com.nofegreen.chord.R.id.toolbar);

        //ThemaList mAdapter = new ThemaList(AlbumTheBest.this, theBest, imageTheBest);
        //mylistview.setAdapter(mAdapter);

        // Sample AdMob app ID: ca-app-pub-3940256099942544/6300978111
        mAdViewList = findViewById(com.nofegreen.chord.R.id.adViewGrid);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdViewList.loadAd(adRequest);

        MobileAds.initialize(this, "ca-app-pub-3940256099942544/6300978111");
        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-3940256099942544/6300978111");

        mAdViewList.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when when the user is about to return
                // to the app after tapping on an ad.
            }
        });

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            mToolbar.setTitle(bundle.getString("Album"));
        };

        if (mToolbar.getTitle().toString().equalsIgnoreCase("SABYAN")) {
            ThemaList mAdapter = new ThemaList(MenuList.this, theBest, imageTheBest);
            mylistview.setAdapter(mAdapter);
            mAdapter.notifyDataSetChanged();
        } /*else if (mToolbar.getTitle().toString().equalsIgnoreCase("DANGEROUS WOMAN")) {
            ThemaList mAdapter = new ThemaList(AlbumTheBest.this, dangerousWoman, imageDangerousWoman);
            mylistview.setAdapter(mAdapter);
            mAdapter.notifyDataSetChanged();
        } else if (mToolbar.getTitle().toString().equalsIgnoreCase("CHRISTMAS & CHILL")) {
            ThemaList mAdapter = new ThemaList(AlbumTheBest.this, christmas, imagechristmas);
            mylistview.setAdapter(mAdapter);
            mAdapter.notifyDataSetChanged();
        }*/


        /*ArrayAdapter<String>adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, textId, imageId);
        mdata = new ArrayList<>();
        getData();
        mAdapter = new ArrayAdapter(ListLyrics.this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.SongTitle));*/

        setSupportActionBar(mToolbar);
        mToolbar.setNavigationIcon(com.nofegreen.chord.R.drawable.ic_arrow_back);

        mylistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent myInten = new Intent(MenuList.this, WebLirics.class);
                myInten.putExtra("Title", mylistview.getItemAtPosition(i).toString());
                startActivity(myInten);
            }
        });

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }
    // Menu icons are inflated just as they were with actionbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(com.nofegreen.chord.R.menu.menugrid, menu);
        return true;
    }

    /*private void getData() {
        Collections.addAll(mdata, textId);
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        switch (item.getItemId()) {
            case com.nofegreen.chord.R.id.miGrid:
                Intent i = new Intent(getApplicationContext(),MenuGrid.class);
                startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}