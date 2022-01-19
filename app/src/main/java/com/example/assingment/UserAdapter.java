package com.example.assingment;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityOptionsCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {

    private List<Cars> cars;

    public UserAdapter(List<Cars> cars){
        this.cars = cars;
    }

    public void AddContact(Cars car){
        cars.add(car);
        notifyDataSetChanged();
    }
    public void DeleteContact(int position){
        cars.remove(position);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.info,parent,false);
       UserViewHolder vh = new UserViewHolder(v);
       return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        Cars car = cars.get(position);


        holder.avatar.setImageResource((car.getPhoto()));
        holder.brand.setText(car.getBrand());
        holder.model.setText(car.getModel());
        holder.price.setText(car.getPrice());
        holder.year.setText(car.getYear());
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), MainActivity2.class);
                i.putExtra("car",car);
                ActivityOptionsCompat options =
                        ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) view.getContext(),
                                holder.avatar,
                                "avatarTransition");
                view.getContext().startActivity(i,options.toBundle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }
}
