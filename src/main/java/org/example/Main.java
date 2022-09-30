package org.example;

import org.example.utilities.*;

import java.util.ArrayList;
import java.util.List;

import org.example.floristeria.Floristeria;
import org.example.floristeria.stock.Arbre;
import org.example.floristeria.stock.Decoracio;
import org.example.floristeria.stock.Flors;
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

	public static void persistenciaTXT(Floristeria floristeria) {

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

			float alcada = Entrada.leerFloat("Indica l'alçada de l'abre :");
			float preu = Entrada.leerFloat("Indica el preu de l'arbre :");
			int stock = Entrada.leerInt("Indica stock :");

			Arbre arbre = new Arbre(alcada, preu, stock);

			floristeria.getConjuntArbres().add(arbre);

			System.out.println("Arbre afegit correctament.");

		} else {
			System.out.println("La floristeria no existe");
		}

	}

	public static void afegirFlor() {

		int i = 0;
		boolean condicion = false;

		String nomFloristeria = Entrada.leerString("Indica el nom de la floristeria on vols afegir la flor :");

		while (i < floristerias.size() && condicion == false) {

			if (nomFloristeria.equalsIgnoreCase(nomFloristeria)) {

				String color = Entrada.leerString("Indica el color de la flor :");
				float preu = Entrada.leerFloat("Indica el preu de la flor :");
				int stock = Entrada.leerInt("Indica stock :");

				Flors flor = new Flors(color, preu, stock);

				floristerias.get(i).getConjuntFlors().add(flor);

				System.out.println("Flor afegida correctament.");

				condicion = true;

			} else {
				i++;
			}
		}
	}

	public static void afegirDecoracio() {

		int i = 0;
		boolean condicion = false;
		int opcion;
		Material material = null;

		String nomFloristeria = Entrada.leerString("Indica el nom de la floristeria on vols afegir la decoració :");

		while (i < floristerias.size() && condicion == false) {
			if (nomFloristeria.equalsIgnoreCase(floristerias.get(i).getNom())) {
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

				Decoracio decoracio = new Decoracio(material, preu, stock);

				floristerias.get(i).getConjuntDecoracio().add(decoracio);

				System.out.println("Decoració afegida correctament.");

				condicion = true;
			} else {
				i++;
			}
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