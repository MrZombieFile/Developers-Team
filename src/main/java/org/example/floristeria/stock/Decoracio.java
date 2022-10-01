package org.example.floristeria.stock;

import org.example.floristeria.stock.decoracio.Material;
import org.example.floristeria.stock.producte.Producte;

public class Decoracio extends Producte {
	

	private Material material;
    private Float preu;
    private String nom;
    
    public Decoracio(String nom, Material material, Float preu, int stock) {
        super(preu, stock);
        this.material = material;
        this.nom= nom;
        this.stock = stock;

    }


    
}
