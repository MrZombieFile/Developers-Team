package org.example.floristeria.stock;

import org.example.floristeria.stock.producte.Producte;

public class Flors extends Producte {
	

	private String color;
    private Float preu;

    public Flors(String nom, String color, Float preu, int stock) {
        super(preu, stock);
        this.color = color;
        this.nom= nom;
        this.stock = stock;
    }
}
