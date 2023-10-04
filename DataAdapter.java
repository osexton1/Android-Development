package com.example.munsterrugby;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder>{

    private Context context;
    private int rowID;
    private Player [] players;
    private RecycleViewInterface recycleViewInterface;

    // View Holder
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView name;
        public TextView position;
        public ImageView image;

        public ViewHolder(@NonNull View itemView, RecycleViewInterface recycleViewInterface) {
            super(itemView);
            this.name = itemView.findViewById(R.id.playerName);
            this.position = itemView.findViewById(R.id.playerPosition);
            this.image = itemView.findViewById(R.id.playerImage);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (recycleViewInterface != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            recycleViewInterface.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    // Data Adapter
    public DataAdapter(Context context, int rowID, Player[] players, RecycleViewInterface recycleViewInterface) {
        this.context = context;
        this.rowID = rowID;
        this.players = players;
        this.recycleViewInterface = recycleViewInterface;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the layout & return the tree view
        View v = LayoutInflater.from(this.context).inflate(this.rowID, parent, false);
        return new ViewHolder(v, recycleViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Populate/ bind the ViewHolder fields with data
        Player player = players[position];
        holder.name.setText(player.getName());
        holder.position.setText(player.getPosition());
        String player_image = player.getImage();
        player_image = player_image.substring(0, player_image.indexOf("."));
        int id = context.getResources().getIdentifier(player_image, "drawable", context.getPackageName());
        holder.image.setImageResource(id);
    }

    @Override
    public int getItemCount() {
        return players.length;
    }
}
