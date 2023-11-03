package com.example.limaapi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class baderAdapter extends RecyclerView.Adapter<baderAdapter.ViewHolder> {
    private List<bader> baderList;

    public baderAdapter(List<bader> baderList) {
        this.baderList = baderList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bader, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        bader bader = baderList.get(position);
        holder.idTextView.setText(bader.getNomor());
        holder.nameTextView.setText(bader.getBahasa());
    }

    @Override
    public int getItemCount() {
        return baderList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView idTextView;
        TextView nameTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            idTextView = itemView.findViewById(R.id.textViewId);
            nameTextView = itemView.findViewById(R.id.textViewTitle);
        }
    }
}

