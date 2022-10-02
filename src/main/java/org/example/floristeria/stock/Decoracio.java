package org.example.floristeria.stock;

import org.example.floristeria.stock.decoracio.Material;
import org.example.floristeria.stock.producte.Producte;

public class Decoracio extends Producte {
	

	private Material material;
    
    
    public Decoracio(String nom, Material material, Float preu, int stock) {
        super(nom,preu,stock);
        this.material = material;

    }

    public Material getMaterial() {
    	return this.material;
    }
    
}
