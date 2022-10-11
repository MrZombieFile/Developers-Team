package org.example.floristeria.ticket;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.example.floristeria.stock.Arbre;
import org.example.floristeria.stock.Decoracio;
import org.example.floristeria.stock.Flor;
import org.example.floristeria.stock.Producte;

public class Ticket {

    private ArrayList<Producte> llistaComprat;

    private ArrayList<Arbre> llistaArbresComprats;
    private ArrayList<Flor> llistaFlorsComprades;
    private ArrayList<Decoracio> llistaDecoracioComprada;

    public Ticket(){
        this.llistaComprat = new ArrayList<>();
        llistaArbresComprats = new ArrayList<>();
        llistaFlorsComprades = new ArrayList<>();
        llistaDecoracioComprada = new ArrayList<>();
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


        List<String> stringsArbre = llistaArbresComprats.stream().map(x -> x.imprimir()).collect(Collectors.toList());
        List<String> stringsFlor = llistaFlorsComprades.stream().map(x -> x.imprimir()).collect(Collectors.toList());
        List<String> stringsDec = llistaDecoracioComprada.stream().map(x -> x.imprimir()).collect(Collectors.toList());
        //falten dels altres strings
        return stringsArbre.toString() + stringsFlor.toString() + stringsDec.toString();

    }
}
