package org.example;

import org.example.floristeria.ticket.Ticket;
import org.example.utilities.*;

import java.util.ArrayList;
import java.util.List;

import org.example.floristeria.Floristeria;
import org.example.floristeria.stock.Arbre;
import org.example.floristeria.stock.Decoracio;
import org.example.floristeria.stock.Flor;
import org.example.floristeria.stock.decoracio.Material;

public class Main {

	private static List<Floristeria> floristerias = new ArrayList<>();

	public static void main(String[] args) {
		int input;
		do {
			input = menuTxt();
			menuSwith(input);
		} while (input != 0);

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
		case 0:
			System.out.println("Bye,bye.");
			break;
		default:
			System.out.println("T'has equiovocat!");
		}

	}

	private static int menuTxt() {

		return Entrada.leerInt("Que vols fer? \n \n" + " 0, Sortir \n" + " 1, Crear Floristeria \n"
				+ " 2, Afegir Arbre \n" + " 3, Afegir Flor \n" + " 4, Afegir Decoració \n"
				+ " 5, Stock: Imprimeix per pantalla tots els arbres, flors i decoració que té la floristeria \n"
				+ " 6, Retirar arbre \n" + " 7, Retirar flor \n" + " 8, Retirar decoració \n "
				+ " 9, Printar per pantalla stock amb quantitats \n"
				+ " 10, Printar per pantalla valor total de la floristeria \n"
				+ " 11, Crear tickets de compra amb múltiples objectes \n"
				+ " 12, Mostrar una llista de compres antigues \n"
				+ " 13, Visualitzar el total de diners guanyats amb totes les vendes \n"
				+ " -------------------------------------------------------------------------------------------------");
	}

	public static void crearFloristeria() {

		String nombre = Entrada.leerString("Indica un nom per a la floristeria :");

		Floristeria floristeria = new Floristeria(nombre);

		floristerias.add(floristeria);

		System.out.println("Floristeria creada correctament.");

	}

	public static void afegirArbre() {
		Floristeria floristeria = buscarFloristeria();
		if (floristeria != null) {
			String nom = Entrada.leerString("Indica el nom del arbre");
			int posicion = buscarProducto(nom, floristeria);
			if (posicion == -1) {
				float alcada = Entrada.leerFloat("Indica l'alçada de l'abre :");
				float preu = Entrada.leerFloat("Indica el preu de l'arbre :");
				int stock = Entrada.leerInt("Indica stock :");

				Arbre arbre1 = new Arbre(nom, alcada, preu, stock);

				floristeria.getConjuntArbres().add(arbre1);

			} else {
				Arbre arbre = floristeria.getConjuntArbres().get(posicion);
				arbre.setStock(arbre.getStock() + 1);
			}
			System.out.println("Arbre afegit correctament.");

		} else {
			System.out.println("La floristeria no existeix");
		}

	}

	private static int buscarProducto(String nom, Floristeria floristeria) {
		boolean encontrado = false;
		int i = -1;

		while (encontrado == false && i < floristerias.size()) {
			i++;
			if (floristeria.getConjuntArbres().get(i).getNom().equalsIgnoreCase(nom)) {
				encontrado = true;
			}
		}
		if (encontrado == false)
			i = -1;
		while (encontrado == false && i < floristerias.size()) {
			i++;
			if (floristeria.getConjuntDecoracio().get(i).getNom().equalsIgnoreCase(nom)) {
				encontrado = true;
			}
		}
		if (encontrado == false)
			i = -1;
		while (encontrado == false && i < floristerias.size()) {
			i++;
			if (floristeria.getConjuntFlors().get(i).getNom().equalsIgnoreCase(nom)) {
				encontrado = true;
			}
		}
		if (encontrado == false)
			i = -1;
		return i;
	}

	public static void afegirFlor() {

		Floristeria floristeria = buscarFloristeria();
		if (floristeria != null) {
			String nom = Entrada.leerString("Indica el nom");
			String color = Entrada.leerString("Indica el color de la flor :");
			float preu = Entrada.leerFloat("Indica el preu de la flor :");
			int stock = Entrada.leerInt("Indica stock :");

			Flor flor = new Flor(nom, color, preu, stock);

			floristeria.getConjuntFlors().add(flor);

			System.out.println("Flor afegida correctament.");

		} else {
			System.out.println("La floristeria no existeix");
		}

	}

	public static void afegirDecoracio() {

		int opcion;
		Material material = null;

		Floristeria floristeria = buscarFloristeria();
		if (floristeria != null) {
			String nom = Entrada.leerString("Indica el nom de la decoracio");

			do {
				opcion = Entrada.leerInt("Inidica el material de la decoració : " + "1.Fusta\n" + "2.Plàstic :");

				if (opcion == 1) {
					material = Material.Fusta;

				} else if (opcion == 2) {
					material = Material.Plàstic;
				} else {
					System.out.println("Opció incorrecta.");
				}
			} while (opcion != 1 && opcion != 2);

			float preu = Entrada.leerFloat("Indica el preu del material :");
			int stock = Entrada.leerInt("Indica stock :");

			Decoracio decoracio = new Decoracio(nom, material, preu, stock);

			floristeria.getConjuntDecoracio().add(decoracio);

			System.out.println("Decoració afegida correctament.");

		} else {
			System.out.println("La floristeria no existe");
		}

	}

	private static Floristeria buscarFloristeria() {
		String nom = Entrada.leerString("Indiqui el nom de la floristeria");
		boolean encontrado = false;
		int i = -1;
		Floristeria floristeria = null;
		// busqueda de floristeria
		while (encontrado == false && i < floristerias.size()) {
			i++;
			if (floristerias.get(i).getNom().equalsIgnoreCase(nom)) {
				encontrado = true;
				floristeria = floristerias.get(i);
			}
		}
		return floristeria;
	}

	public static void stock() {
		Floristeria floristeria = buscarFloristeria();

		if (floristeria == null) {
			System.out.println("La floristeria no existe");
		} else {
			System.out.println("Stock de la floristeria: ");
			floristeria.toString();
		}

	}

	public static void retirarArbre() {
		Floristeria floristeria = buscarFloristeria();
		if (floristeria != null) {
			String nom = Entrada.leerString("Indica el nom del arbre");
			int posicion = buscarProducto(nom, floristeria);
			if (posicion == -1) {
				System.out.println("El arbol no existe");
			} else {
				Arbre arbre = floristeria.getConjuntArbres().get(posicion);
				arbre.setStock(arbre.getStock() - 1);
				if (arbre.getStock() == 0)
					floristeria.getConjuntArbres().remove(arbre);
			}
			System.out.println("Arbre retirat correctament.");

		} else {
			System.out.println("La floristeria no existeix");
		}

	}

	public static void retirarFlor() {
		Floristeria floristeria = buscarFloristeria();
		if (floristeria != null) {
			String nom = Entrada.leerString("Indica el nom del arbre");
			int posicion = buscarProducto(nom, floristeria);
			if (posicion == -1) {
				System.out.println("El arbol no existe");
			} else {
				Flor arbre = floristeria.getConjuntFlors().get(posicion);
				arbre.setStock(arbre.getStock() - 1);
				if (arbre.getStock() == 0)
					floristeria.getConjuntFlors().remove(arbre);
			}
			System.out.println("Arbre retirat correctament.");

		} else {
			System.out.println("La floristeria no existeix");
		}
	}

	public static void retirarDecoracio() {
		Floristeria floristeria = buscarFloristeria();
		if (floristeria != null) {
			String nom = Entrada.leerString("Indica el nom del arbre");
			int posicion = buscarProducto(nom, floristeria);
			if (posicion == -1) {
				System.out.println("El arbol no existe");
			} else {
				Decoracio arbre = floristeria.getConjuntDecoracio().get(posicion);
				arbre.setStock(arbre.getStock() - 1);
				if (arbre.getStock() == 0)
					floristeria.getConjuntDecoracio().remove(arbre);
			}
			System.out.println("Arbre retirat correctament.");

		} else {
			System.out.println("La floristeria no existeix");
		}
	}

	public static void stockQuantitats() {
		Floristeria floristeria = buscarFloristeria();

		if (floristeria == null) {
			System.out.println("La floristeria no existe");
		} else {
			System.out.println("Stock de la floristeria: ");
			floristeria.stockTotal();
		}

	}
	//#########################################################################

	public static void valorTotalFloristeria() {
		Floristeria floristeria = buscarFloristeria();
		if (floristeria != null)
			System.out.println(floristeria.valorStockFloristeria());
		else
			System.out.println("La floristeria no existeix");
	}

	public static void crearTicket() {
		Floristeria floristeria = buscarFloristeria();
		int i = Entrada.leerInt("Què vols comprar?" +
				"\n 1, Arbres \n 2, Flors \n 3, Decoració");
		Ticket ticket = new Ticket();

		switch(i){
			case 1:
				floristeria.getConjuntArbres().forEach(x -> System.out.println(x.getNom()));
				String nomArbre = Entrada.leerString("Quin arbre vols comprar?");
				//Tant per aquest com per als altres cases dins del switch,
				// ara busco el producte que s'ha comprat i l'elimino del sistema:
				int posicionArbol = buscarProducto(nomArbre, floristeria);
				if (posicionArbol == -1) {
					System.out.println("El arbol no existeix");
				} else {
					Arbre arbre = floristeria.getConjuntArbres().get(posicionArbol);
					arbre.setStock(arbre.getStock() - 1);
					if (arbre.getStock() == 0)
						floristeria.getConjuntArbres().remove(arbre);
				}
				//fins aqui, on l'enregistro al tiquet que haura de sortir per la caixa
				if (ticket.getLlistaComprat() == null){
					ticket.setLlistaComprat(ticket.getLlistaComprat().add(new Arbre(nomArbre, )));
				}
				break;
			case 2:
				floristeria.getConjuntFlors().forEach(x -> System.out.println(x.getNom()));
				String nomFlor = Entrada.leerString("Quina flor vols comprar?");

				int posicionFlor = buscarProducto(nomFlor, floristeria);
				if (posicionFlor == -1) {
					System.out.println("La flor no existeix");
				} else {
					Flor flor = floristeria.getConjuntFlors().get(posicionFlor);
					flor.setStock(flor.getStock() - 1);
					if (flor.getStock() == 0)
						floristeria.getConjuntArbres().remove(flor);
				}
				break;
			case 3:
				floristeria.getConjuntDecoracio().forEach(x -> System.out.println(x.getNom()));
				String nomDecoracio = Entrada.leerString("Quina flor vols comprar?");

				int posicionDecoracio = buscarProducto(nomDecoracio, floristeria);
				if (posicionDecoracio == -1) {
					System.out.println("La decoració no existeix");
				} else {
					Decoracio decoracio = floristeria.getConjuntDecoracio().get(posicionDecoracio);
					decoracio.setStock(decoracio.getStock() - 1);
					if (decoracio.getStock() == 0)
						floristeria.getConjuntArbres().remove(decoracio);
				}
				break;
		}
	}

	public static void compresAntigues() {

	}

	public static void totalVendes() {

	}
}