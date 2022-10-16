package org.example.floristeria.stock;

public class Arbre extends Producte {
    private Float alcada;
    
    public Arbre(String nom, Float alcada, Float preu, int stock) {
        super(nom, preu, stock);
        this.alcada = alcada;
    }

    public Float getAlcada() {
        return this.alcada;
    }

	@Override
	public void eliminado() {
		System.out.println("El "+ nom+ " ha sigut eliminat");
	}

    @Override
    public String imprimir() {
        return " Nom de l'arbre: " + super.getNom()
                + " alçada: " + this.alcada.toString()
                + " preu per unitat: " + super.getPreuPerUnitat().toString()
                + " stock: " + Integer.toString(super.getStock());
    }
}
