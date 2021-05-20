package com.example.writereadrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myadapter extends RecyclerView.Adapter<myadapter.myviewholder> {

    ArrayList<person> mlist;
    Context context;

    public myadapter(Context context, ArrayList<person> mlist){
        this.mlist= mlist;
        this.context= context;

    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.itemlist, parent, false);
        return  new myviewholder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        person person = mlist.get(position);
        holder.nam.setText(person.getUsername());
        holder.mail.setText(person.getEmail());
        holder.pass.setText(person.getPassword());
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public static class myviewholder extends RecyclerView.ViewHolder{
        TextView nam,mail,pass;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            nam=itemView.findViewById(R.id.nam);
            mail=itemView.findViewById(R.id.mail);
            pass=itemView.findViewById(R.id.pass);
        }
    }
}
