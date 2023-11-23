package com.example.tplabovestadisticafutbol;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolderFutbolista extends RecyclerView.ViewHolder implements View.OnClickListener {
    TextView tvNombreFutbolista;
    TextView tvCantGolesConvertidos;
    TextView tvEquipoDondeJuega;
    ImageButton btnVerDetalleDelJugador;
    public ViewHolderFutbolista(@NonNull View itemView) {
        super(itemView);
        this.tvNombreFutbolista=this.itemView.findViewById(R.id.tvNombre);
        this.tvCantGolesConvertidos=this.itemView.findViewById(R.id.tvCantidadDeGoles);
        this.tvEquipoDondeJuega=this.itemView.findViewById(R.id.tvEquipo);
        this.btnVerDetalleDelJugador=this.itemView.findViewById(R.id.btnImgVerDetalle);
        this.btnVerDetalleDelJugador.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int indiceDelJugadorClickeado = super.getAdapterPosition();
        //Futbolista f = MainActivity.listaDeJugadores.get(indiceDelJugadorClickeado);
        Intent i = new Intent(view.getContext(), ActivityVerDetalles.class);
        i.putExtra("jugadorQueSeEligio", MainActivity.listaDeJugadores.get(indiceDelJugadorClickeado));
        /*i.putExtra("keyDelJugador", f.getKeyDelJugador());
        i.putExtra("golesConvertidos", f.getCantDeGolesConvertidos());
        i.putExtra("golesDePenales", f.getGolesDePenales());*/

        view.getContext().startActivity(i);
    }
}
