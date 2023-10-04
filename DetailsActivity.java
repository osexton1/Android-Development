package com.example.munsterrugby;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class DetailsActivity extends AppCompatActivity {

    // Widget Objects
    private ImageView detailsPlayerImage;
    private TextView detailsPlayerName, detailsPlayerPosition, detailsPlayerCaps;
    private Button detailsButton;

    // Data
    private Player player = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_layout);
        detailsPlayerName = findViewById(R.id.detailsPlayerName);
        detailsPlayerImage = findViewById(R.id.detailsPlayerImage);
        detailsPlayerPosition = findViewById(R.id.detailsPlayerPosition);
        detailsPlayerCaps = findViewById(R.id.detailsPlayerCaps);
        detailsButton = findViewById(R.id.moreDetailsButton);

        // Get the data
        Intent intent = getIntent();
        player = (Player)intent.getExtras().getSerializable("player");

        // Populate widgets with data
        detailsPlayerName.setText(player.getName());
        String player_image = player.getImage();
        player_image = player_image.substring(0, player_image.indexOf("."));
        int id = this.getResources().getIdentifier(player_image, "drawable", getPackageName());
        detailsPlayerImage.setImageResource(id);
        detailsPlayerPosition.setText(new StringBuilder().append("Position: ").append(player.getPosition()).toString());
        detailsPlayerCaps.setText(new StringBuilder().append("Appearances: ").append(player.getCaps()).toString());

        // Wire up the More Details Button
        detailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                // Make an intent and place the bundle in it and start activity
                Intent intent = new Intent(DetailsActivity.this, MoreDetailsActivity.class);
                bundle.putSerializable("player", player);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
