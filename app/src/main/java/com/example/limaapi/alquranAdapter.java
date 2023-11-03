package com.example.limaapi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class alquranAdapter extends RecyclerView.Adapter<alquranAdapter.ViewHolder> {
    private List<alquran> alquranList;

    public alquranAdapter(List<alquran> alquranList) {
        this.alquranList = alquranList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_alquran, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        alquran alquran = alquranList.get(position);

        holder.ayatTextView.setText(alquran.getAyat());
        holder.surahTextView.setText(alquran.getNama());
        holder.textTextView.setText(alquran.getArti());
    }

    @Override
    public int getItemCount() {
        return alquranList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView surahTextView;
        TextView ayatTextView;
        TextView textTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            surahTextView = itemView.findViewById(R.id.textViewSurah);
            ayatTextView = itemView.findViewById(R.id.textViewAyat);
            textTextView = itemView.findViewById(R.id.textViewText);
        }
    }
}
