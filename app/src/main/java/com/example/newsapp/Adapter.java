package com.example.newsapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.Viewholder>{

    Context context;

    ArrayList<Modal> MODALCLASSARRAYLIST;

    public Adapter(Context context, ArrayList<Modal> MODALCLASSARRAYLIST) {
        this.context = context;
        this.MODALCLASSARRAYLIST = MODALCLASSARRAYLIST;
    }

    @NonNull
    @Override
    public Adapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item2, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.Viewholder holder, int position) {
        int pos =  holder.getAdapterPosition();
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,Webview.class);
                intent.putExtra("url",MODALCLASSARRAYLIST.get(pos).getUrl());
                context.startActivity(intent);
            }
        });
        holder.mtime.setText(MODALCLASSARRAYLIST.get(position).getPublishedAt());
        holder.mauthor.setText(MODALCLASSARRAYLIST.get(position).getAuthor());
        holder.mheading.setText(MODALCLASSARRAYLIST.get(position).getTitle());
        holder.mcontent.setText(MODALCLASSARRAYLIST.get(position).getDescription());
     Glide.with(context).load(MODALCLASSARRAYLIST.get(position).getUrlToImage()).into(holder.imageView);
//        Picasso.get()
//                .load(MODALCLASSARRAYLIST.get(position).getUrlToImage())
//                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return MODALCLASSARRAYLIST.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        TextView mheading,mcontent,mauthor,mtime;
        ImageView imageView;
        CardView cardView;


        public Viewholder(@NonNull View itemView) {
            super(itemView);
            mheading = itemView.findViewById(R.id.heading);
            mcontent = itemView.findViewById(R.id.content);
            mauthor = itemView.findViewById(R.id.author);
            mtime = itemView.findViewById(R.id.time);
            imageView = itemView.findViewById(R.id.image);
            cardView = itemView.findViewById(R.id.card);
        }
    }
}
