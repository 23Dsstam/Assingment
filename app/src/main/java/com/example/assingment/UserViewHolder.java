package com.example.assingment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class UserViewHolder extends RecyclerView.ViewHolder {

    public CardView card;
    public ImageView avatar;
    public TextView model;
    public TextView brand;
    public TextView year;
    public TextView price;



    public UserViewHolder(@NonNull View itemView) {
        super(itemView);

        card = itemView.findViewById(R.id.card);
        avatar = itemView.findViewById(R.id.avatar);
        model = itemView.findViewById(R.id.model);
        brand = itemView.findViewById(R.id.brand);
        year = itemView.findViewById(R.id.year);
        price = itemView.findViewById(R.id.price);


    }
}
