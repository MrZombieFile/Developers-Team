package org.example.floristeria.stock;

import org.example.floristeria.stock.producte.Producte;

public class Arbre extends Producte {
    private Float alcada;
    
    public Arbre(String nom, Float alcada, Float preu, int stock) {
        super(nom, preu, stock);
        this.alcada = alcada;
    }

    public Float getAlcada() {
        return this.alcada;
    }

}
