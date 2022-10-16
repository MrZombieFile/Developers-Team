package org.example.floristeria.ticket;


import java.util.*;
import java.util.stream.Collectors;

import org.example.floristeria.stock.Arbre;
import org.example.floristeria.stock.Decoracio;
import org.example.floristeria.stock.Flor;
import org.example.floristeria.stock.Producte;

public class Ticket {

    private ArrayList<Arbre> llistaArbresComprats;
    private ArrayList<Flor> llistaFlorsComprades;
    private ArrayList<Decoracio> llistaDecoracioComprada;

    public Ticket(){
        this.llistaArbresComprats = new ArrayList<>();
        this.llistaFlorsComprades = new ArrayList<>();
        this.llistaDecoracioComprada = new ArrayList<>();
    }


    public ArrayList<Producte> getLlistaComprat() {
        ArrayList<Producte> productesComprats = new ArrayList<>();
        productesComprats.addAll(llistaArbresComprats);
        productesComprats.addAll(llistaFlorsComprades);
        productesComprats.addAll(llistaDecoracioComprada);

        return productesComprats;
    }

    public Double getPreuTotalLlistaComprat() {
        return getLlistaComprat().stream().mapToDouble(x -> x.getPreuPerUnitat()).sum();
    }

    public void afegirArbreComprat(Arbre arbre){
        this.llistaArbresComprats.add(arbre);
    }

    public void afegirFlorComprada(Flor flor){
        this.llistaFlorsComprades.add(flor);
    }

    public void afegirDecoracioComprada(Decoracio decoracio){
        this.llistaDecoracioComprada.add(decoracio);
    }

    public String imprimir() {

        return llistaArbresComprats.stream().filter(Objects::nonNull).map(x -> x.imprimir()).collect(Collectors.joining("-", "\n{", "}"));
    }
}
