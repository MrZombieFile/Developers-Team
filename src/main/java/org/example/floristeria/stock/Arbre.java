package org.example.floristeria.stock;

import org.example.floristeria.stock.producte.Producte;

public class Arbre extends Producte {
    private Float alcada;
    private Float preu;
    
    public Arbre(String nom, Float alcada, Float preu, int stock) {
        super(preu, stock);
        this.alcada = alcada;
        this.nom = nom;
        this.stock = stock;

    }
    


    
    
    
    
}
