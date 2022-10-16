package org.example.floristeria.stock;

import org.example.floristeria.stock.decoracio.Material;

public class Decoracio extends Producte {
	

	private Material material;
    
    
    public Decoracio(String nom, Material material, Float preu, int stock) {
        super(nom,preu,stock);
        this.material = material;

    }

    public Material getMaterial() {
    	return this.material;
    }
    @Override
	public void eliminado() {
		System.out.println("El "+ nom+ " ha sigut eliminat");
	}

    @Override
    public String imprimir() {
        return " Nom de la decoracio: " + super.getNom()
                + " material: " + this.material.toString()
                + " preu per unitat: " + super.getPreuPerUnitat().toString()
                + " stock: " + Integer.toString(super.getStock());
    }
}
