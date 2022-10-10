package org.example.floristeria.ticket;


import java.util.ArrayList;

import org.example.floristeria.stock.Producte;

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
