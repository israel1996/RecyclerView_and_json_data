package com.example.recyclerview_and_json_data.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview_and_json_data.Modelo.Evaluadores;
import com.example.recyclerview_and_json_data.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolder> {

    LayoutInflater inflater;
    List<Evaluadores> evaluadores;
    public Adaptador(Context ctx, List<Evaluadores> evaluadores){
        this.inflater = LayoutInflater.from(ctx);
        this.evaluadores = evaluadores;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_layout, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtIDEvaluador.setText(evaluadores.get(position).getIdevaluador());
        holder.txtNombresEvaluador.setText(evaluadores.get(position).getNombres());
        holder.txtAreaEvaluador.setText(evaluadores.get(position).getArea());
        Picasso.get().load(evaluadores.get(position).getUrlImagenJPG()).into(holder.imagenEvaluador);
    }

    @Override
    public int getItemCount() {
        return evaluadores.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtIDEvaluador, txtNombresEvaluador, txtAreaEvaluador;
        ImageView imagenEvaluador;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtIDEvaluador = itemView.findViewById(R.id.txtIDEvaluador);
            txtNombresEvaluador = itemView.findViewById(R.id.rxtNombreEvaluador);
            txtAreaEvaluador = itemView.findViewById(R.id.txtAreaEvaluador);
        }
    }


}
