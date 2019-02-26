package com.hathy.listsandcards;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonViewHolder> {

    List<Person> persons;
    Context context;
    private CustomItemClick listener;

    public RVAdapter(Context context, List<Person> persons, CustomItemClick listener){
        this.persons = persons;
        this.context = context;
        this.listener = listener;
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, final int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item, viewGroup, false);
        final PersonViewHolder pvh = new PersonViewHolder(v);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(v, i);
            }
        });
        return pvh;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder personViewHolder, final int i) {
        personViewHolder.personName.setText(persons.get(i).getName());
        personViewHolder.personAge.setText(persons.get(i).getAge());
        personViewHolder.personPhoto.setImageResource(persons.get(i).getPhotoId());

    }

    @Override
    public int getItemCount() {
        return persons.size();
    }

    public static class PersonViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView personName;
        TextView personAge;
        ImageView personPhoto;

        PersonViewHolder(View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.cv);
            personName = itemView.findViewById(R.id.person_name);
            personAge = itemView.findViewById(R.id.person_age);
            personPhoto =itemView.findViewById(R.id.person_photo);
        }
    }

}
