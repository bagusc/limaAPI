package com.example.limaapi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class kodePosAdapter extends RecyclerView.Adapter<kodePosAdapter.ViewHolder> {
    private List<kodePos> kodePosList;

    public kodePosAdapter(List<kodePos> kodePosList) {
        this.kodePosList = kodePosList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_kodepos, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        kodePos kodePos = kodePosList.get(position);

        holder.kecamatanTextView.setText(kodePos.getKecamatan());
        holder.kelurahanTextView.setText(kodePos.getKelurahan());
        holder.kodePosTextView.setText(kodePos.getkodePos());
    }

    @Override
    public int getItemCount() {
        return kodePosList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView kecamatanTextView;
        TextView kelurahanTextView;
        TextView kodePosTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            kecamatanTextView = itemView.findViewById(R.id.textViewKecamatan);
            kelurahanTextView = itemView.findViewById(R.id.textViewKelurahan);
            kodePosTextView = itemView.findViewById(R.id.textViewkodePos);
        }
    }
}
