package org.example.floristeria.ticket;


import org.example.floristeria.stock.producte.Producte;

import java.util.ArrayList;

public class Ticket {

    private ArrayList<Producte> llistaComprat;

    public ArrayList<Producte> getLlistaComprat() {
        return llistaComprat;
    }

    public void afegirALlistaComprat(Producte producte){
        this.llistaComprat.add(producte);
    }
    public void setLlistaComprat(ArrayList<Producte> llistaComprat) {
        this.llistaComprat = llistaComprat;
    }

    public Double getPreuTotalLlistaComprat() {
        return llistaComprat.stream().mapToDouble(x -> x.getPreuPerUnitat()).sum();
    }


}
