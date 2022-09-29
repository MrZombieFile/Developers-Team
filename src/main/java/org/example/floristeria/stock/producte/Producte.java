package org.example.floristeria.stock.producte;

public class Producte {

    private Float preuPerUnitat;
    private int stock;

    public Producte(Float preu, int stock) {
        this.preuPerUnitat = preu;
        this.stock = stock;
    }

    public Float getPreuPerUnitat() {
        return preuPerUnitat;
    }

    public void setPreuPerUnitat(Float preuPerUnitat) {
        this.preuPerUnitat = preuPerUnitat;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }




}
