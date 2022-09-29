package org.example.floristeria.stock;

import org.example.floristeria.stock.producte.Producte;

public class Flors extends Producte {

    private String color;

    public Flors(String color, Float preu, int stock) {
        super(preu, stock);
        this.color = color;
    }
}
