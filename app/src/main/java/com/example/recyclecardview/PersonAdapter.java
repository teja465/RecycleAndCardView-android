package com.example.recyclecardview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PersonAdapter  extends RecyclerView.Adapter<PersonAdapter.personViewHolder> {

    interface ItemClicked{
        public void clickeCardItem(int i);
    }

    private ArrayList<Person> personsData;
    ItemClicked myMainActivity;

    public PersonAdapter(Context context, ArrayList<Person> personsData) {
        this.personsData = personsData;
        this.myMainActivity = (ItemClicked) context;
    }
    public class personViewHolder extends RecyclerView.ViewHolder{
        // layout is configured here

        ImageView ivProf;
        TextView tvName ,tvSurname;

        public personViewHolder(@NonNull View itemView) {
            super(itemView);
            ivProf = itemView.findViewById(R.id.ivPreference);
            tvName = itemView.findViewById(R.id.tvName);
            tvSurname = itemView.findViewById(R.id.tvSurname);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    myMainActivity.clickeCardItem(Integer.parseInt(itemView.getTag().toString()));
                }
            });
        }
    }

    @NonNull
    @Override
    public PersonAdapter.personViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items, parent, false);
        return new personViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull PersonAdapter.personViewHolder holder, int position) {

        holder.itemView.setTag(position);
        holder.tvName.setText(personsData.get(position).getName());
        holder.tvSurname.setText(personsData.get(position).getSurname());

        if (personsData.get(position).getPreference()=="bus"){
            holder.ivProf.setImageResource(R.drawable.bus);
        }
        else {
            holder.ivProf.setImageResource(R.drawable.plane);
        }

    }

    @Override
    public int getItemCount() {
        return personsData.size();
    }
}
