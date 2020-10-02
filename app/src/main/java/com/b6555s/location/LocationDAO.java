package com.b6555s.location;

public class LocationDAO {
    private  String model;
    private  String limite_de_kilometrage;
    private String conditions_en_matiere_de_carburant;
    private  String date;
    private String motif;

    public LocationDAO(String model, String limite_de_kilometrage, String conditions_en_matiere_de_carburant, String date, String motif) {
        this.model = model;
        this.limite_de_kilometrage = limite_de_kilometrage;
        this.conditions_en_matiere_de_carburant = conditions_en_matiere_de_carburant;
        this.date = date;
        this.motif = motif;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public LocationDAO() {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLimite_de_kilometrage() {
        return limite_de_kilometrage;
    }

    public void setLimite_de_kilometrage(String limite_de_kilometrage) {
        this.limite_de_kilometrage = limite_de_kilometrage;
    }

    public String getConditions_en_matiere_de_carburant() {
        return conditions_en_matiere_de_carburant;
    }

    public void setConditions_en_matiere_de_carburant(String conditions_en_matiere_de_carburant) {
        this.conditions_en_matiere_de_carburant = conditions_en_matiere_de_carburant;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
