package com.example.myapp6;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class adapter extends RecyclerView.Adapter<adapter.ViewHolder> {
    ArrayList<lating> items = new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.lating_view,viewGroup,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        lating item = items.get(position);
        viewHolder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(lating item){
        items.add(item);
    }
    public void setItems(ArrayList<lating> items){
        this.items = items;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView_ID;
        TextView textView_content;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
             textView_ID= itemView.findViewById(R.id.Id);
             textView_content= itemView.findViewById(R.id.content);

        }
        public void setItem(lating Lating){
            textView_ID.setText(Lating.getName());
            textView_content.setText(Lating.getContent());
        }

    }

}
