package org.example.floristeria.ticket;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.example.floristeria.stock.Producte;

public class Ticket {

    private ArrayList<Producte> llistaComprat;
    public Ticket(){
        this.llistaComprat = new ArrayList<>();
    }


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

    @Override
    public String toString() {
        //return llistaComprat.stream().map(Object::toString).collect(Collectors.toList()).toString();
        String aRetornar = new String();
        if (llistaComprat != null) {
            for (int i = 0; i < llistaComprat.size(); i++) {
                aRetornar = aRetornar + llistaComprat.get(i).toString();
            }
        }
        return aRetornar;

    }
}
