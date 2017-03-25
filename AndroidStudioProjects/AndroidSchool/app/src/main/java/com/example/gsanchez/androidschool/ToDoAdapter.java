package com.example.gsanchez.androidschool;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gsanchez on 3/25/17.
 */
class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.ViewHolder> {
    private List<ToDoItem> items;
    private Context context;

    public ToDoAdapter(Context context, List<ToDoItem> items) {
        this.items = new ArrayList<>();
        this.items.addAll(items);
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        return new ViewHolder(inflater.inflate(R.layout.holder_view, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ToDoItem item = items.get(position);
        holder.bindData(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView titleTextView;
        private TextView dateTextView;
        private TextView locationTextView;
        private View holder;

        public ViewHolder(View itemView){
            super(itemView);
            titleTextView = (TextView) itemView.findViewById(R.id.title);
            dateTextView = (TextView) itemView.findViewById(R.id.date);
            locationTextView = (TextView) itemView.findViewById(R.id.location);
            holder = itemView;
        }

        public void bindData(ToDoItem item){
            titleTextView.setText(item.getTitle());
            dateTextView.setText(item.getDate());
            locationTextView.setText(item.getLocation());
            holder.setOnClickListener(this);
        }

        @Override
        public void onClick(View view){
            Toast.makeText(context, "Estoy en la posición "+this.getLayoutPosition()+" del layout.", Toast.LENGTH_SHORT).show();
        }
    }
}
