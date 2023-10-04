package com.example.munsterrugby;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements RecycleViewInterface {

    private RecyclerView recyclerView;
    private DataAdapter dataAdapter;
    private PlayersFromXML players;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        players = new PlayersFromXML(this);

        Player [] players_array = players.getPlayers();

        dataAdapter = new DataAdapter(this, R.layout.row_layout, players_array, this);
        recyclerView.setAdapter(dataAdapter);
    }

    @Override
    public void onItemClick(int position) {
        // Get the data associated with position
        Player player = players.getPerson(position);
        Bundle bundle = new Bundle();
        // Make an intent and place the bundle in it and start activity
        Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
        bundle.putSerializable("player", player);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
