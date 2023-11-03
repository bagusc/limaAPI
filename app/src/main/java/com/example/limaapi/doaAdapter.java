package com.example.limaapi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class doaAdapter extends RecyclerView.Adapter<doaAdapter.ViewHolder> {
    private List<doa> doaList;

    public doaAdapter(List<doa> doaList) {
        this.doaList = doaList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_doa, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        doa doa = doaList.get(position);

        holder.doaTextView.setText(doa.getdoa());
        holder.AyatTextView.setText(doa.getAyat());
        holder.LatinTextView.setText(doa.getLatin());
        holder.ArtinyaTextView.setText(doa.getArtinya());
    }

    @Override
    public int getItemCount() {
        return doaList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView doaTextView;
        TextView AyatTextView, LatinTextView, ArtinyaTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            doaTextView = itemView.findViewById(R.id.textViewdoa);
            AyatTextView = itemView.findViewById(R.id.textViewAyat);
            LatinTextView = itemView.findViewById(R.id.textViewLatin);
            ArtinyaTextView = itemView.findViewById(R.id.textViewArtinya);
        }
    }
}

