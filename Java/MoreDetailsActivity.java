package com.example.munsterrugby;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MoreDetailsActivity extends AppCompatActivity {

    // Widget Objects
    private ImageView moreDetailsPlayerImage;
    private TextView moreDetailsPlayerName, moreDetailsPlayerPosition, moreDetailsPlayerCaps, moreDetailsPlayerPoints, moreDetailsPlayerHonours;
    private Button webDetailsButton;

    // Data
    private Player player = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.more_details_layout);

        moreDetailsPlayerName = findViewById(R.id.moreDetailsPlayerName);
        moreDetailsPlayerImage = findViewById(R.id.moreDetailsPlayerImage);
        moreDetailsPlayerPosition = findViewById(R.id.moreDetailsPlayerPosition);
        moreDetailsPlayerCaps = findViewById(R.id.moreDetailsPlayerCaps);
        moreDetailsPlayerPoints = findViewById(R.id.moreDetailsPlayerPoints);
        moreDetailsPlayerHonours = findViewById(R.id.moreDetailsPlayerHonours);
        webDetailsButton = findViewById(R.id.webDetailsButton);

        // Get the data
        Intent intent = getIntent();
        player = (Player)intent.getExtras().getSerializable("player");

        // Populate widgets with data
        moreDetailsPlayerName.setText(player.getName());
        String player_image = player.getImage();
        player_image = player_image.substring(0, player_image.indexOf("."));
        int id = this.getResources().getIdentifier(player_image, "drawable", getPackageName());
        moreDetailsPlayerImage.setImageResource(id);
        moreDetailsPlayerPosition.setText(new StringBuilder().append("Position: ").append(player.getPosition()).toString());
        moreDetailsPlayerCaps.setText(new StringBuilder().append("Appearances: ").append(player.getCaps()).toString());
        moreDetailsPlayerPoints.setText(new StringBuilder().append("Points Scored: ").append(player.getPoints()).toString());
        moreDetailsPlayerHonours.setText(new StringBuilder().append("Honours: ").append(player.getHonours()).toString());

        // Wire up the More Details Button
        webDetailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                // Make an intent and place the bundle in it and start activity
                Intent intent = new Intent(MoreDetailsActivity.this, WebDetailsActivity.class);
                bundle.putSerializable("player", player);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
