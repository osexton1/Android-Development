package com.example.munsterrugby;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class WebDetailsActivity extends AppCompatActivity {

    // Widget Objects
    private WebView webDetails;

    // Data
    private Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_details_layout);

        webDetails = findViewById(R.id.webDetails);

        // Get the Data
        Intent intent = getIntent();
        player = (Player)intent.getExtras().getSerializable("player");

        webDetails.loadUrl(player.getUrl());
        webDetails.getSettings().setLoadsImagesAutomatically(true);
        webDetails.getSettings().setJavaScriptEnabled(true);
    }
}
