package org.example.floristeria.stock;

import org.example.floristeria.stock.producte.Producte;

public class Arbre extends Producte {

    private Float alcada;

    public Arbre(Float alcada, Float preu, int stock) {
        super(preu, stock);
        this.alcada = alcada;
    }
}
