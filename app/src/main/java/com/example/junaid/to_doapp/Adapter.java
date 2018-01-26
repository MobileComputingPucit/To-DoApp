package com.example.junaid.to_doapp;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by Junaid on 26-Jan-18.
 */
public class Adapter extends RecyclerView.Adapter<Adapter.AdapterViewHolder> {
    private Context context;
    private DBHelper db;
    private String name;
    private LayoutInflater layoutInflater;
    private ArrayList<User_notes> user_notes;
    public Adapter (Context context, ArrayList<User_notes> user_notes, String name)
    {
        this.name = name;
        db = new DBHelper(context);
        this.context = context;
        this.user_notes = user_notes;
        this.layoutInflater = LayoutInflater.from(this.context);
    }
    @Override
    public Adapter.AdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.notes_list,parent,false);
        AdapterViewHolder adapterViewHolder = new AdapterViewHolder(itemView);
        return adapterViewHolder;
    }

    @Override
    public void onBindViewHolder(Adapter.AdapterViewHolder holder,final int position) {
        holder.tv1.setText(user_notes.get(position).get_notes());
    }

    public void insertItem (int position, User_notes user_note) {
        user_notes.add(position, user_note);
        notifyItemInserted(position);
    }

    @Override
    public int getItemCount() {
        return user_notes.size();
    }

    public class AdapterViewHolder extends RecyclerView.ViewHolder{
        private TextView tv1;
        public AdapterViewHolder (View itemView){
            super(itemView);
            tv1 = (TextView) itemView.findViewById(R.id.note);
        }
    }
}
