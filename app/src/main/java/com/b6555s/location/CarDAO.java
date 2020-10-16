package com.b6555s.location;

public class CarDAO {
    private String id;
    private  String model;
    private  String limite_de_kilometrage;
    private String conditions_en_matiere_de_carburant;

    public CarDAO(String id, String model, String limite_de_kilometrage, String conditions_en_matiere_de_carburant) {
        this.id = id;
        this.model = model;
        this.limite_de_kilometrage = limite_de_kilometrage;
        this.conditions_en_matiere_de_carburant = conditions_en_matiere_de_carburant;
    }

    public CarDAO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
