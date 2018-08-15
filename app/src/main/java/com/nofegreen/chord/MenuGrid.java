package com.nofegreen.chord;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MenuGrid extends AppCompatActivity {

    GridView mygridView;
    android.support.v7.widget.Toolbar gridToolbar;
    private AdView mAdView;

    String textId[] = {
            "SABYAN"
    };

    Integer[] imageId = {
            com.nofegreen.chord.R.drawable.albumcover
    };

    String textYearId[] = {
            "Nissa Sabyan 2018"

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.nofegreen.chord.R.layout.activity_menu_grid);

        ThemaGrid adapter = new ThemaGrid(MenuGrid.this, textId, imageId, textYearId);
        mygridView = (GridView) findViewById(com.nofegreen.chord.R.id.myGrid);
        mygridView.setAdapter(adapter);
        gridToolbar = (android.support.v7.widget.Toolbar) findViewById(com.nofegreen.chord.R.id.toolbarGrid);

        setSupportActionBar(gridToolbar);
        gridToolbar.setNavigationIcon(com.nofegreen.chord.R.drawable.ic_arrow_back);

        // Sample AdMob app ID: ca-app-pub-3940256099942544/6300978111
        mAdView = findViewById(com.nofegreen.chord.R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        MobileAds.initialize(this, "ca-app-pub-3940256099942544/6300978111");
        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-3940256099942544/6300978111");

        mAdView.setAdListener(new AdListener() {
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

        mygridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                //Intent myIntenGrid = new Intent(MenuGrid.this, AlbumOne.class); //please change
                //Toast.makeText(MenuGrid.this, "" + position, Toast.LENGTH_SHORT).show();
                if (position == 0) {
                    Intent myIntenGrid = new Intent(MenuGrid.this, MenuList.class);
                    myIntenGrid.putExtra("Album", mygridView.getItemAtPosition(position).toString());
                    startActivity(myIntenGrid);
                } else if (position == 1) {
                    Intent myIntenGrid = new Intent(MenuGrid.this, MenuList.class);
                    myIntenGrid.putExtra("Album", mygridView.getItemAtPosition(position).toString());
                    startActivity(myIntenGrid);
                } else if (position == 2) {
                    Intent myIntenGrid = new Intent(MenuGrid.this, MenuList.class);
                    myIntenGrid.putExtra("Album", mygridView.getItemAtPosition(position).toString());
                    startActivity(myIntenGrid);
                } else if (position == 3) {
                    Intent myIntenGrid = new Intent(MenuGrid.this, MenuList.class);
                    myIntenGrid.putExtra("Album", mygridView.getItemAtPosition(position).toString());
                    startActivity(myIntenGrid);
                } else if (position == 4) {
                    Intent myIntenGrid = new Intent(MenuGrid.this, MenuList.class);
                    myIntenGrid.putExtra("Album", mygridView.getItemAtPosition(position).toString());
                    startActivity(myIntenGrid);
                } else if (position == 5) {
                    Intent myIntenGrid = new Intent(MenuGrid.this, MenuList.class);
                    myIntenGrid.putExtra("Album", mygridView.getItemAtPosition(position).toString());
                    startActivity(myIntenGrid);
                } else if (position == 6) {
                    Intent myIntenGrid = new Intent(MenuGrid.this, MenuList.class);
                    myIntenGrid.putExtra("Album", mygridView.getItemAtPosition(position).toString());
                    startActivity(myIntenGrid);
                } else if (position == 7) {
                    Intent myIntenGrid = new Intent(MenuGrid.this, MenuList.class);
                    myIntenGrid.putExtra("Album", mygridView.getItemAtPosition(position).toString());
                    startActivity(myIntenGrid);
                } else if (position == 8) {
                    Intent myIntenGrid = new Intent(MenuGrid.this, MenuList.class);
                    myIntenGrid.putExtra("Album", mygridView.getItemAtPosition(position).toString());
                    startActivity(myIntenGrid);
                }
                //myIntenGrid.putExtra("Album", mygridView.getItemAtPosition(position).toString());
                //startActivity(myIntenGrid);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
