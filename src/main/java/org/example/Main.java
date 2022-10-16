package org.example;

import org.example.floristeria.ticket.Ticket;
import org.example.utilities.*;

import java.util.*;
import java.util.stream.Collectors;

import org.example.floristeria.Floristeria;
import org.example.floristeria.stock.Arbre;
import org.example.floristeria.stock.Decoracio;
import org.example.floristeria.stock.Flor;
import org.example.floristeria.stock.decoracio.Material;

import static org.example.utilities.EscribirTxt.escribirFloristeriaTxt;
import static org.example.utilities.EscribirTxt.escribirTxt;

public class Main {

	private static ArrayList<Floristeria> floristerias = new ArrayList<>();

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
			compresAntigues(Optional.empty());
			break;
		case 13:
			totalVendes(Optional.empty());
			break;
		case 0:
			escribirEnFloristeriaTXT(floristerias);
			EscribirTxt.cerrarTxt();
			System.out.println("Fins aviat!");
			break;
		default:
			System.out.println("T'has equiovocat!");
			break;
		}

	}

	private static int menuTxt() {

		return Entrada.leerInt("Que vols fer? \n \n" + " 0, Eixir \n" + " 1, Crear Floristeria \n"
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


	private static Floristeria buscarFloristeria() {
		String nom = Entrada.leerString("Indiqui el nom de la floristeria");

		boolean encontrado = false;
		int i = 0;
		Floristeria floristeria = null;
		// busqueda de floristeria
		while (encontrado == false && i < floristerias.size()) {
			if (floristerias.get(i).getNom().equalsIgnoreCase(nom)) {
				encontrado = true;
				floristeria = floristerias.get(i);
			}
			i++;
		}
		return floristeria;
	}

    public static void crearFloristeria() {
        int i = 0;
        boolean condicion = false;
        String salidaPantalla = "";

        String nombre = Entrada.leerString("Indica un nom per a la floristeria :");

        while (i < floristerias.size() && condicion == false) {
            if (nombre.equalsIgnoreCase(floristerias.get(i).getNom())) {
                salidaPantalla = "La floristeria ya existeix.";
                condicion = true;
            }
            i++;
        }
        if (condicion == false) {

            Floristeria floristeria = new Floristeria(nombre);

            floristerias.add(floristeria);
            escribirTxt("  Floristeria creada:");
            escribirTxt("    " + floristeria.getNom());

            salidaPantalla = "Floristeria creada correctament.";
        }

        System.out.println(salidaPantalla);
    }

	public static void afegirArbre() {

		String salidaPantalla = "";

		Floristeria floristeria = buscarFloristeria();

		if (floristeria != null) {

			String nom = Entrada.leerString("Indica el nom de l'arbre :");

			float alcada = Entrada.leerFloat("Indica l'alçada de l'abre :");

			float preu = Entrada.leerFloat("Indica el preu de l'arbre :");

			int stock = Entrada.leerInt("Indica stock :");

			Arbre arbre = new Arbre(nom, alcada, preu, stock);

			floristeria.getConjuntArbres().add(arbre);

			salidaPantalla = "Arbre afegit correctament.";
			escribirTxt(" Afegint arbre a " + floristeria.getNom() + "\n     Nom: " + nom + "\n     alcada: " + alcada
					+ "\n     preu: " + preu + "\n     stock: " + stock);

		} else {
			salidaPantalla = "La floristeria no existeix.";
		}
		System.out.println(salidaPantalla);
	}

	public static void afegirFlor() {

		String salidaPantalla = "";
		Floristeria floristeria = buscarFloristeria();

		if (floristeria != null) {

			String nom = Entrada.leerString("Indica el nom de la flor :");
			String color = Entrada.leerString("Indica el color de la flor :");

			float preu = Entrada.leerFloat("Indica el preu de la flor :");

			int stock = Entrada.leerInt("Indica stock :");

			Flor flor = new Flor(nom, color, preu, stock);

			floristeria.getConjuntFlors().add(flor);

			salidaPantalla = "Flor afegida correctament.";
			escribirTxt("\n    Afegint flor a " + floristeria.getNom() + "\n    nom" + nom + "\n    color" + color
					+ "\n    preu" + preu + "\n    stock" + stock);

		} else {
			salidaPantalla = "La floristeria no existeix";
		}
		System.out.println(salidaPantalla);
	}

	public static void afegirDecoracio() {

		int opcion;
		Material material = null;
		String salidaPantalla = "";

		Floristeria floristeria = buscarFloristeria();

		if (floristeria != null) {

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

			String nom = Entrada.leerString("Indica el nom de la decoració :");
			float preu = Entrada.leerFloat("Indica el preu del material :");

			int stock = Entrada.leerInt("Indica stock :");
			escribirTxt("  Afegint decoracio a " + floristeria.getNom() + "\n     nom: " + nom + "\n     material: "
					+ material.toString() + "\n     preu: " + preu + "\n     stock: " + stock);

			Decoracio decoracio = new Decoracio(nom, material, preu, stock);

			floristeria.getConjuntDecoracio().add(decoracio);

			salidaPantalla = "Decoració afegida correctament.";
		} else {
			salidaPantalla = "La floristeria no existeix";
		}
		System.out.println(salidaPantalla);
	}

	public static void stock() {
		Floristeria floristeria = buscarFloristeria();

		if (floristeria == null) {
			System.out.println("La floristeria no existe");
		} else {
			System.out.println("Stock de la floristeria: \n ");
			System.out.println("Arbres>  " + floristeria.getConjuntArbres().size() + " \n Flors "
					+ floristeria.getConjuntFlors().size() + "\n Decoració  "
					+ floristeria.getConjuntDecoracio().size());
		}
		System.out.println("-----------------------------------------------------");

	}

	public static void retirarArbre() {
		Floristeria floristeria = buscarFloristeria();

		if (floristeria != null) {
			String nom = Entrada.leerString("Indica el nom de l'arbre");
			Arbre producto = Buscar.buscarA(nom, floristeria);

			if (producto == null) {
				System.out.println("No tens aquest arbre");
			} else {
				escribirTxt("  Retirat arbre a floristeria " + floristeria.getNom() + "\n    Nom arbre : " + nom);
				producto.eliminado();
				floristeria.getConjuntArbres().remove(producto);
			}

		} else {
			System.out.println("La floristeria no existeix");
		}

	}

	public static void retirarFlor() {
		Floristeria floristeria = buscarFloristeria();

		if (floristeria != null) {
			String nom = Entrada.leerString("Indica el nom del arbre");
			Flor producto = Buscar.buscarFlor(nom, floristeria);

			if (producto == null) {
				System.out.println("No tens aquesta flor");
			} else {
				escribirTxt("  Retirat flor a floristeria " + floristeria.getNom() + "\n    Nom flor : " + nom);
				producto.eliminado();
				floristeria.getConjuntFlors().remove(producto);
			}

		} else {
			System.out.println("La floristeria no existeix");
		}
	}

	public static void retirarDecoracio() {
		Floristeria floristeria = buscarFloristeria();

		if (floristeria != null) {

			String nom = Entrada.leerString("Indica el nom del arbre");
			Decoracio producto = Buscar.buscarD(nom, floristeria);

			if (producto == null) {
				System.out.println("No tens aquesta Decoracio");
			} else {
				escribirTxt(
						"  Retirant decoració a floristeria " + floristeria.getNom() + "\n    Nom decoració : " + nom);
				producto.eliminado();
				floristeria.getConjuntDecoracio().remove(producto);
			}

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

	public static void valorTotalFloristeria() {
		Floristeria floristeria = buscarFloristeria();
		if (floristeria != null) {
			System.out.println(floristeria.valorStockFloristeria());
		} else {
			System.out.println("La floristeria no existeix");
		}
	}

	public static void crearTicket() {
		Floristeria floristeria = buscarFloristeria();

		Ticket ticket = null;
		if (floristeria == null) {
			System.out.println("La floristeria no existeix");
		} else {
			int i;
			ticket = new Ticket();
			do {
				i = Entrada.leerInt(
						"Què vols comprar?" + "\n 1, Arbres \n 2, Flors \n 3, Decoració \n 4, Ja ho he comprat tot");

				switch (i) {
				case 1:
					floristeria.getConjuntArbres().forEach(x -> System.out.println(x.getNom()));
					crearTicketArbre(floristeria, ticket);
					break;
				case 2:
					floristeria.getConjuntFlors().forEach(x -> System.out.println(x.getNom()));
					crearTicketFlor(floristeria, ticket);
					break;
				case 3:
					floristeria.getConjuntDecoracio().forEach(x -> System.out.println(x.getNom()));
					crearTicketDecoracio(floristeria, ticket);
					break;
				case 4:
					//#####################################################################
					floristeria.afegirTicket(ticket);
					escribirTxt("  Creant ticket a floristeria : " + floristeria.getNom() +
							"L\'usuari ha comprat: " + floristeria.getLastTicket().imprimir());
					break;
				default:
                    System.out.println("Introdueix una opció vàlida");
                    break;
				}
			} while (i != 4);




		}
	}

	public static void crearTicketArbre(Floristeria floristeria, Ticket ticket) {
		String nomArbre = Entrada.leerString("Quin arbre vols comprar?");
		Arbre arbreAComprar = Buscar.buscarA(nomArbre, floristeria);
		System.out.println(arbreAComprar.getNom() + arbreAComprar.getAlcada());
		ticket.afegirArbreComprat(arbreAComprar);
	}

	public static void crearTicketFlor(Floristeria floristeria, Ticket ticket) {
		String nomFlor = Entrada.leerString("Quina flor vols comprar?");
		Flor florAComprar = Buscar.buscarFlor(nomFlor, floristeria);

		ticket.afegirFlorComprada(florAComprar);
	}

	public static void crearTicketDecoracio(Floristeria floristeria, Ticket ticket) {
		String nomDecoracio = Entrada.leerString("Quina decoracio vols comprar?");
		Decoracio decoracio = Buscar.buscarD(nomDecoracio, floristeria);

		ticket.afegirDecoracioComprada(decoracio);
	}

	public static void compresAntigues(Optional<Floristeria> optional) {
		Floristeria floristeria;
		if (optional.isEmpty()) {
			floristeria = buscarFloristeria();
		} else {
			floristeria = optional.get();
		}
		floristeria.getHistoricDeTickets().stream().map(x -> {
			System.out.println("Ticket: ");
			x.getLlistaComprat().stream().forEach(d -> {
				System.out.println("Nom: " + d.getNom());
				System.out.println("Preu per unitat " + d.getPreuPerUnitat());
			});
			return x.getPreuTotalLlistaComprat();
		}).mapToDouble(x -> x).sum();

	}

	public static void totalVendes(Optional<Floristeria> optional) {
		Floristeria floristeria;
		if (optional.isEmpty()) {
			floristeria = buscarFloristeria();
		} else {
			floristeria = optional.get();
		}

		// total del venut a la floristeria introduida
		Double montoCompresAntigues = floristeria.getHistoricDeTickets().stream()
				.map(x -> x.getPreuTotalLlistaComprat()).mapToDouble(x -> x).sum();
		System.out.println("El total d'aquesta floristeria es :" + montoCompresAntigues);

	}

	public static void escribirEnFloristeriaTXT(ArrayList<Floristeria> floristeria) {
		int i = 0;
		do {
			escribirFloristeriaTxt("Els productes de la floristeria " + floristerias.get(i).getNom() + ": ");

			floristerias.forEach(x -> {
				x.getConjuntArbres().stream().forEach(arbre -> {
					escribirFloristeriaTxt("Arbre: ");
					escribirFloristeriaTxt(arbre.getNom());
					escribirFloristeriaTxt(arbre.getAlcada().toString());
					escribirFloristeriaTxt(arbre.getPreuPerUnitat().toString());
					escribirFloristeriaTxt(Integer.toString(arbre.getStock()));
				});

				x.getConjuntFlors().stream().forEach(flor -> {
					escribirFloristeriaTxt("Flor");
					escribirFloristeriaTxt(flor.getNom());
					escribirFloristeriaTxt(flor.getColor());
					escribirFloristeriaTxt(flor.getPreuPerUnitat().toString());
					escribirFloristeriaTxt(Integer.toString(flor.getStock()));
				});

				x.getConjuntDecoracio().stream().forEach(decoracio -> {
					escribirFloristeriaTxt("Decoracio");
					escribirFloristeriaTxt(decoracio.getNom());
					escribirFloristeriaTxt(decoracio.getMaterial().toString());
					escribirFloristeriaTxt(decoracio.getPreuPerUnitat().toString());
					escribirFloristeriaTxt(Integer.toString(decoracio.getStock()));
				});
			});

			i++;
		} while (i < floristerias.size());
	}

}