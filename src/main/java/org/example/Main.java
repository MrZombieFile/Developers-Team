package org.example;

import org.example.utilities.*;
import org.example.floristeria.Floristeria;
import org.example.floristeria.stock.Arbre;
import org.example.floristeria.stock.Decoracio;
import org.example.floristeria.stock.Flors;
import org.example.floristeria.stock.decoracio.Material;


public class Main {
    public static void main(String[] args) {
        int input;
        do {
            input = menuTxt();
            menuSwith(input);
        } while (input != 0);


        //Ara empleno un parell de floristeries només per tenir coses amb les que treballar

        Floristeria floristeria01 = new Floristeria("Floristeria01");
        floristeria01.getConjuntArbres().add(new Arbre(1.42f, 22.50f, 5));
        floristeria01.getConjuntArbres().add(new Arbre(2.23f, 49.50f, 12));
        floristeria01.getConjuntArbres().add(new Arbre(4.5f, 73.00f, 7));

        floristeria01.getConjuntFlors().add(new Flors("verd", 30f, 3));
        floristeria01.getConjuntFlors().add(new Flors("marró", 50f, 5));
        floristeria01.getConjuntFlors().add(new Flors("groc", 60f, 7));

        floristeria01.getConjuntDecoracio().add(new Decoracio(Material.Fusta, 123f, 10));
        floristeria01.getConjuntDecoracio().add(new Decoracio(Material.Plàstic, 234f, 13));
        floristeria01.getConjuntDecoracio().add(new Decoracio(Material.Plàstic, 345f, 15));

        //Aquí la segona floristeria:
        Floristeria floristeria02 = new Floristeria("Floristeria02");
        floristeria02.getConjuntArbres().add(new Arbre(1.42f, 22.50f, 5));
        floristeria02.getConjuntArbres().add(new Arbre(2.23f, 49.50f, 12));
        floristeria02.getConjuntArbres().add(new Arbre(4.5f, 73.00f, 7));

        floristeria02.getConjuntFlors().add(new Flors("blau", 30f, 3));
        floristeria02.getConjuntFlors().add(new Flors("vermell", 50f, 5));
        floristeria02.getConjuntFlors().add(new Flors("groc", 60f, 7));

        floristeria02.getConjuntDecoracio().add(new Decoracio(Material.Fusta, 123f, 10));
        floristeria02.getConjuntDecoracio().add(new Decoracio(Material.Plàstic, 234f, 13));
        floristeria02.getConjuntDecoracio().add(new Decoracio(Material.Plàstic, 345f, 15));

        //Creo que hay debate entre si poner un arrayList de floristerias en el main o no
        //Queda pendiente el añadirlo para después de la reunión


        persistenciaTXT(floristeria02);


    }

    private static void menuSwith(int input) {
        switch (input) {
            case 1:
            	crearFloristeria();
                break;
            case 2:
            	afegirArbre();
                break;
            case 3:
            	afegirFlor();
                break;
            case 4:
            	afegirDecoracio();
            	break;
            case 5:
            	stock();
            	break;
            case 6:
            	retirarArbre();
                break;
            case 7:
            	retirarFlor();
                break;
            case 8:
            	retirarDecoracio();
                break;
            case 9:
            	stockQuantitats();
                break;
            case 10:
            	valorTotalFloristeria();
                break;
            case 11:
            	crearTicket();
                break;
            case 12:
            	compresAntigues();
                break;
            case 13:
            	totalVendes();
                break;
            default:
                System.out.println("T'has equiovocat!");
        }

    }

    private static int menuTxt() {

        return Entrada.leerInt("Que vols fer? \n \n"
                + " 0, Sortir \n" 
        		+ " 1, Crear Floristeria \n" 
                + " 2, Afegir Arbre \n"
                + " 3, Afegir Flor \n" 
                + " 4, Afegir Decoració \n"
                + " 5, Stock: Imprimeix per pantalla tots els arbres, flors i decoració que té la floristeria \n"
                + " 6, Retirar arbre \n" 
                + " 7, Retirar flor \n" 
                + " 8, Retirar decoració \n "
                + " 9, Printar per pantalla stock amb quantitats \n"
                + " 10, Printar per pantalla valor total de la floristeria \n"
                + " 11, Crear tickets de compra amb múltiples objectes \n"
                + " 12, Mostrar una llista de compres antigues \n"
                + " 13, Visualitzar el total de diners guanyats amb totes les vendes \n"
                + " -------------------------------------------------------------------------------------------------");
    }

    public static void persistenciaTXT(Floristeria floristeria) {

    }
    
    public static void crearFloristeria() {
    	
    }
    
    public static void afegirArbre() {
    	
    }
    
    public static void afegirFlor() {
    	
    }
    
    public static void afegirDecoracio() {
    	
    }
    
    public static void stock() {
    	
    }
    
    public static void retirarArbre() {
    	
    }
    
    public static void retirarFlor() {
    	
    }
    
    public static void retirarDecoracio() {
    	
    }
    
    public static void stockQuantitats() {
    	
    }
    
    public static void valorTotalFloristeria() {
    	
    }
    
    public static void crearTicket() {
    	
    }
    
    public static void compresAntigues() {
    	
    }
    
    public static void totalVendes() {
    	
    }
}