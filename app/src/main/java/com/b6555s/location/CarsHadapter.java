package com.b6555s.location;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CarsHadapter extends RecyclerView.Adapter<CarsHadapter.ViewHolder> {
        public ArrayList<CarDAO> cars;
        public Context context;
        public CarsHadapter(ArrayList<CarDAO> _cars, Context _context) {
            this.cars = _cars;
            this.context= _context;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.car_card, parent, false);
            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
            holder.model.setText("Modèle :"+this.cars.get(position).getModel());
            holder.conditions_en_matiere_de_carburant.setText("Conditions en matière de carburant : "+this.cars.get(position).getConditions_en_matiere_de_carburant());
            holder.limite_de_kilometrage.setText("limite de kilometrage : "+this.cars.get(position).getLimite_de_kilometrage());
            holder.louer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, cars.get(position).getModel(), Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public int getItemCount() {
            return cars.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder{

            public TextView model;
            public TextView limite_de_kilometrage;
            public TextView conditions_en_matiere_de_carburant;
            public EditText motif;
            public Button louer;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);

                model = (TextView) itemView.findViewById(R.id.model_c);
                limite_de_kilometrage = (TextView) itemView.findViewById(R.id.limite_de_kilometrage_c);
                conditions_en_matiere_de_carburant = (TextView) itemView.findViewById(R.id.conditions_en_matiere_de_carburant_c);
                motif = (EditText) itemView.findViewById(R.id.motif_c);
                louer = (Button) itemView.findViewById(R.id.louer);
            }
        }

}
