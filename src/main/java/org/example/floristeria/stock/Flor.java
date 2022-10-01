package org.example.floristeria.stock;

import org.example.floristeria.stock.producte.Producte;

public class Flor extends Producte {
	

	private String color;
    private Float preu;
    private String nom;

    public Flor(String nom, String color, Float preu, int stock) {
        super(preu, stock);
        this.color = color;
        this.nom= nom;
    }
}
