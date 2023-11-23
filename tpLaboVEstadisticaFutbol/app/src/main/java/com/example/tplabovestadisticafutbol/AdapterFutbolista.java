package com.example.tplabovestadisticafutbol;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterFutbolista extends RecyclerView.Adapter<ViewHolderFutbolista> {

    List<Futbolista> listaDeFutbolistas;

    public AdapterFutbolista(List<Futbolista> futbolistas) {
        this.listaDeFutbolistas = futbolistas;
    }

    @NonNull
    @Override
    public ViewHolderFutbolista onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = null;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_futbolista,parent,false);
        return new ViewHolderFutbolista(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderFutbolista holder, int position) {
        Futbolista jugador = this.listaDeFutbolistas.get(position);
        holder.tvNombreFutbolista.setText(jugador.getNombreDelJugador());
        holder.tvEquipoDondeJuega.setText(jugador.getEquipoDondeJuega());
        holder.tvCantGolesConvertidos.setText(String.valueOf(jugador.getCantDeGolesConvertidos()));

    }

    @Override
    public int getItemCount() {
        return this.listaDeFutbolistas.size();
    }

}
