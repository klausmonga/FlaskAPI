package com.b6555s.location;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class LocationsHadapter extends RecyclerView.Adapter<LocationsHadapter.ViewHolder> {
        public ArrayList<LocationDAO> locations;
        public LocationsHadapter(ArrayList<LocationDAO> _locations, Context context) {
            this.locations = _locations;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.location_card, parent, false);
            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.model.setText("Modèle :"+this.locations.get(position).getModel());
            holder.conditions_en_matiere_de_carburant.setText("Conditions en matière de carburant : "+this.locations.get(position).getConditions_en_matiere_de_carburant());
            holder.limite_de_kilometrage.setText("limite de kilometrage : "+this.locations.get(position).getLimite_de_kilometrage());
            holder.date.setText(this.locations.get(position).getDate());
            holder.motif.setText(this.locations.get(position).getMotif());
        }

        @Override
        public int getItemCount() {
            return locations.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder{

            public TextView model;
            public TextView limite_de_kilometrage;
            public TextView conditions_en_matiere_de_carburant;
            public TextView motif;
            public TextView date;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);

                model = (TextView) itemView.findViewById(R.id.model);
                limite_de_kilometrage = (TextView) itemView.findViewById(R.id.limite_de_kilometrage);
                conditions_en_matiere_de_carburant = (TextView) itemView.findViewById(R.id.conditions_en_matiere_de_carburant);
                motif = (TextView) itemView.findViewById(R.id.motif);
                date = (TextView) itemView.findViewById(R.id.date);
            }
        }

}
