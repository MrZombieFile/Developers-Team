package org.example.floristeria;

import org.example.floristeria.stock.Arbre;
import org.example.floristeria.stock.Decoracio;
import org.example.floristeria.stock.Flors;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Floristeria {
	private String nom;

    private ArrayList<Arbre> conjuntArbres;
    private ArrayList<Flors> conjuntFlors;
    private ArrayList<Decoracio> conjuntDecoracio;
    

    public Floristeria(String nom) {
        this.nom = nom;
        this.conjuntArbres = new ArrayList<>();
        this.conjuntFlors = new ArrayList<>();
        this.conjuntDecoracio = new ArrayList<>();
    }

    public Double valorStockFloristeria(){
        Double valor = conjuntArbres.stream().mapToDouble(x -> x.getStock() * x.getPreuPerUnitat()).sum()
                        + conjuntFlors.stream().mapToDouble(x -> x.getStock() * x.getPreuPerUnitat()).sum()
                        + conjuntDecoracio.stream().mapToDouble(x -> x.getStock() * x.getPreuPerUnitat()).sum();
        return valor;
    }
    public void stockTotal() {
    	System.out.println("Stock Arbres>");
    	conjuntArbres.forEach(a -> System.out.println(a.getNom()+" Cantidad: "+ a.getStock()));
		System.out.println("----------------------------------------------------------------");
		System.out.println("Stock Flors>");
		conjuntFlors.forEach(a -> System.out.println(a.getNom()+" Cantidad: "+ a.getStock()));
		System.out.println("----------------------------------------------------------------");
		System.out.println("Stock Decoracio>");
		conjuntDecoracio.forEach(a -> System.out.println(a.getNom()+" Cantidad: "+ a.getStock()));
		System.out.println("----------------------------------------------------------------");
    }
    
    public String getNom() {
    	return this.nom;
    }

    public ArrayList<Arbre> getConjuntArbres() {
        return conjuntArbres;
    }

    public void setConjuntArbres(ArrayList<Arbre> conjuntArbres) {
        this.conjuntArbres = conjuntArbres;
    }

    public ArrayList<Flors> getConjuntFlors() {
        return conjuntFlors;
    }

    public void setConjuntFlors(ArrayList<Flors> conjuntFlors) {
        this.conjuntFlors = conjuntFlors;
    }

    public ArrayList<Decoracio> getConjuntDecoracio() {
        return conjuntDecoracio;
    }

    public void setConjuntDecoracio(ArrayList<Decoracio> conjuntDecoracio) {
        this.conjuntDecoracio = conjuntDecoracio;
    }

	@Override
	public String toString() {
		return "Floristeria=" + nom 
				+ ", conjuntArbres=" + conjuntArbres.toString() 
				+ ", conjuntFlors=" + conjuntFlors.toString()
				+ ", conjuntDecoracio=" + conjuntDecoracio.toString() 
				+ " \n -------------------------------------------------------------------";
	}
    
   	
}
