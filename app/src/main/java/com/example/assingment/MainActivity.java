package com.example.assingment;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    UserAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Cars> cars = new ArrayList<Cars>();
        cars.add(new Cars(R.drawable.car1,"SUBARU","RAM 1500 LIMITED","2020","61,350"));
        cars.add(new Cars(R.drawable.car2,"HYUNDAI","PALASADE CALLIGRAPHY","2021","52,995"));
        cars.add(new Cars(R.drawable.car3,"MERCEDES-BENZ","G-Class G 550","2015","84,000"));
        cars.add(new Cars(R.drawable.car4,"TOYOTA","Avalon XLE Touring","2018","31,989"));
        cars.add(new Cars(R.drawable.car5,"CHEVROLET","Traver 2LT","2017","24,279"));
        cars.add(new Cars(R.drawable.car6,"AUDI","RS 7 4.0T quattro","2021","139,990"));
        cars.add(new Cars(R.drawable.car7,"VOLVO","S90 T5 Momentum","2018","34,750"));
        cars.add(new Cars(R.drawable.car8,"KIA","Telluride S","2020","35,994"));

        RecyclerView recycler = findViewById(R.id.recycler);
        recycler.setHasFixedSize(false);

        RecyclerView.LayoutManager manager = new GridLayoutManager(getApplicationContext(), 1);
        recycler.setLayoutManager(manager);

        adapter = new UserAdapter(cars);
        recycler.setAdapter(adapter);

        ItemTouchHelper helper = new ItemTouchHelper(new SwipeToDelete(adapter));
        helper.attachToRecyclerView(recycler);

        FloatingActionButton btn = findViewById(R.id.floatingActionButton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(),AddCar.class);
                ActivityOptionsCompat options =
                        ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) view.getContext(),
                                btn,
                                "bg");
                startActivityForResult(i,1,options.toBundle());
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bundle b = data.getExtras();
        Cars cars = (Cars) b.getSerializable("cars");
        adapter.AddContact(cars);
    }

}