package org.example.floristeria.stock;

public class Flor extends Producte {
	

	private String color;
  

    public Flor(String nom, String color, Float preu, int stock) {
        super(nom,preu,stock);
        this.color = color;
    }
    
    public String getColor() {
    	return this.color;
    }
    @Override
	public void eliminado() {
		System.out.println("El "+ nom+ " ha sigut eliminat");
	}

    @Override
    public String toString() {
        return "Nom de la flor: " + super.getNom()
                + "color: " + this.color
                + "preu per unitat: " + super.getPreuPerUnitat().toString()
                + "stock: " + Integer.toString(super.getStock());
    }
}
