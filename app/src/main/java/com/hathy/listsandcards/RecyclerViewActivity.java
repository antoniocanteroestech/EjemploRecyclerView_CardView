package com.hathy.listsandcards;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends Activity {

    private List<Person> persons;
    private RecyclerView rv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.recyclerview_activity);
        rv=findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        initializeData();
        initializeAdapter();
    }

    private void initializeData(){
        persons = new ArrayList<>();
        persons.add(new Person("Emma Wilson", "23 years old", R.drawable.emma));
        persons.add(new Person("Lavery Maiss", "25 years old", R.drawable.lavery));
        persons.add(new Person("Lillie Watts", "35 years old", R.drawable.lillie));
    }

    private void initializeAdapter(){
        RVAdapter adapter = new RVAdapter(RecyclerViewActivity.this, persons,
                new CustomItemClick() {
                    @Override
                    public void onClick(View view, int i) {
                        Toast.makeText(RecyclerViewActivity.this,
                                persons.get(i).getName(),
                                Toast.LENGTH_SHORT).show();
                    }
                });
        rv.setAdapter(adapter);
    }
}
