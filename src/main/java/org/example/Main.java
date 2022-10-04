package org.example;

import org.example.floristeria.stock.producte.Producte;
import org.example.floristeria.ticket.Ticket;
import org.example.utilities.*;

import java.util.*;

import org.example.floristeria.Floristeria;
import org.example.floristeria.stock.Arbre;
import org.example.floristeria.stock.Decoracio;
import org.example.floristeria.stock.Flor;
import org.example.floristeria.stock.decoracio.Material;

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

	private static Producte buscarProducto(String nom, Floristeria floristeria) {
		boolean encontrado = false;
		int i = 0;
		Producte producto = null;
		while (i < floristeria.getConjuntArbres().size() && encontrado == false) {

			if (floristeria.getConjuntArbres().get(i).getNom().equalsIgnoreCase(nom)) {
				encontrado = true;
				producto = floristeria.getConjuntArbres().get(i);

			}
			i++;

		}
		if (encontrado == false) {
			i = 0;
			while (encontrado == false && i < floristeria.getConjuntFlors().size()) {

				if (floristeria.getConjuntFlors().get(i).getNom().equalsIgnoreCase(nom)) {
					encontrado = true;
					producto = floristeria.getConjuntArbres().get(i);
				}
				i++;

			}
		}
		if (encontrado == false) {
			i = 0;
			while (encontrado == false && i < floristeria.getConjuntDecoracio().size()) {
				if (floristeria.getConjuntDecoracio().get(i).getNom().equalsIgnoreCase(nom)) {
					encontrado = true;
					producto = floristeria.getConjuntArbres().get(i);

				}
				i++;

			}
		}

		if (encontrado == false)
			i = 0;
		return producto;
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
		EscribirTxt.escribirTxt("  Floristeria creada:");
		String nombre = Entrada.leerString("Indica un nom per a la floristeria :");
		EscribirTxt.escribirTxt("    "+nombre);

		Floristeria floristeria = new Floristeria(nombre);

		floristerias.add(floristeria);

		System.out.println("Floristeria creada correctament.");

	}

	public static void afegirArbre() {
		
		int i = 0;
		boolean condicion = false;

		String nomFloristeria = Entrada.leerString("Indica el nom de la floristeria on vols afegir l'arbre :");

		while (i < floristerias.size() && condicion == false) {

			if (nomFloristeria.equalsIgnoreCase(floristerias.get(i).getNom())) {
				EscribirTxt.escribirTxt("  Afegint arbre a "+ nomFloristeria);

				String nom = Entrada.leerString("Indica el nom de l'arbre :");
				EscribirTxt.escribirTxt("    Nom: "+nom);

				float alcada = Entrada.leerFloat("Indica l'alçada de l'abre :");
				EscribirTxt.escribirTxt("    alcada: "+alcada);

				float preu = Entrada.leerFloat("Indica el preu de l'arbre :");
				EscribirTxt.escribirTxt("    preu: "+preu);

				int stock = Entrada.leerInt("Indica stock :");
				EscribirTxt.escribirTxt("    stock: "+stock);

				Arbre arbre = new Arbre(nom, alcada, preu, stock);

				floristerias.get(i).getConjuntArbres().add(arbre);

				System.out.println("Arbre afegit correctament.");

				condicion = true;

			} else {
				i++;
			}
		}
	}

	public static void afegirFlor() {

		int i = 0;
		boolean condicion = false;

		String nomFloristeria = Entrada.leerString("Indica el nom de la floristeria on vols afegir la flor :");

		while (i < floristerias.size() && condicion == false) {

			if (nomFloristeria.equalsIgnoreCase(nomFloristeria)) {
				EscribirTxt.escribirTxt("  Afegint flor a "+ nomFloristeria);

				String nom = Entrada.leerString("Indica el nom de la flor :");
				EscribirTxt.escribirTxt("    nom"+nom);
				String color = Entrada.leerString("Indica el color de la flor :");
				EscribirTxt.escribirTxt("    color"+color);

				float preu = Entrada.leerFloat("Indica el preu de la flor :");
				EscribirTxt.escribirTxt("    preu"+preu);

				int stock = Entrada.leerInt("Indica stock :");
				EscribirTxt.escribirTxt("    stock"+stock);

				Flor flor = new Flor(nom, color, preu, stock);

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
				EscribirTxt.escribirTxt("  Afegint deciracio a "+ nomFloristeria);

				do {

					opcion = Entrada.leerInt("Inidica el material de la decoració : " + "1.Fusta\n" + "2.Plàstic :");

					if (opcion == 1) {
						material = Material.Fusta;
						EscribirTxt.escribirTxt("    material: "+ material.toString());

					} else if (opcion == 2) {
						material = Material.Plàstic;
						EscribirTxt.escribirTxt("    material: "+ material.toString());

					} else {
						System.out.println("Opció incorrecta.");
					}
				} while (opcion != 1 && opcion != 2);

				String nom = Entrada.leerString("Indica el nom de la decoració :");
				EscribirTxt.escribirTxt("    nom: "+ nom);

				float preu = Entrada.leerFloat("Indica el preu del material :");
				EscribirTxt.escribirTxt("    preu: "+ preu);

				int stock = Entrada.leerInt("Indica stock :");
				EscribirTxt.escribirTxt("    stock: "+ stock);


				Decoracio decoracio = new Decoracio(nom, material, preu, stock);

				floristerias.get(i).getConjuntDecoracio().add(decoracio);

				System.out.println("Decoració afegida correctament.");

				condicion = true;
			} else {
				i++;
			}
		}

	}

	public static void stock() {
		Floristeria floristeria = buscarFloristeria();

		if (floristeria == null) {
			System.out.println("La floristeria no existe");
		} else {
			System.out.println("Stock de la floristeria: ");
			System.out.println("Arbres> \n " + floristeria.getConjuntArbres().size() + "Flors \n "
					+ floristeria.getConjuntFlors().size() + "Decoració \n "
					+ floristeria.getConjuntDecoracio().size());
		}
		System.out.println("-----------------------------------------------------");

	}

	public static void retirarArbre() {
		Floristeria floristeria = buscarFloristeria();		

		if (floristeria != null) {
			String nom = Entrada.leerString("Indica el nom del arbre");
			Producte producto = buscarProducto(nom, floristeria);

			if (producto == null){
				System.out.println("No tens aquest arbre");
			}else {
				EscribirTxt.escribirTxt("  Retirant arbre a floristeria "+floristeria.getNom());
				EscribirTxt.escribirTxt("    Nom arbre : "+nom);
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
			Producte producto = buscarProducto(nom, floristeria);

			if (producto == null){
				System.out.println("No tens aquesta flor");
			}else {
				EscribirTxt.escribirTxt("  Retirant flor a floristeria "+floristeria.getNom());
				EscribirTxt.escribirTxt("    Nom flor : "+nom);
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
			Producte producto = buscarProducto(nom, floristeria);

			if (producto == null){
				System.out.println("No tens aquesta Decoracio");
			}else {
				EscribirTxt.escribirTxt("  Retirant decoració a floristeria "+floristeria.getNom());
				EscribirTxt.escribirTxt("    Nom decoració : "+nom);
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
		}else {
			System.out.println("La floristeria no existeix");
		}
	}

	public static Ticket crearTicket() {
		Floristeria floristeria = buscarFloristeria();

		int i;
		Ticket ticket = new Ticket();
		EscribirTxt.escribirTxt("  Creant ticket a floristeria : "+floristeria.getNom());
		do {
			i = Entrada.leerInt(
					"Què vols comprar?" + "\n 1, Arbres \n 2, Flors \n 3, Decoració \n 4, Ja ho he comprat tot");

			switch (i) {
			case 1:
				floristeria.getConjuntArbres().forEach(x -> System.out.println(x.getNom()));
				EscribirTxt.escribirTxt("  Comprant arbre :");
				String nomArbre = Entrada.leerString("Quin arbre vols comprar?");
				EscribirTxt.escribirTxt("  "+nomArbre);
				Map<String, Floristeria> mapArbre = new HashMap<>();
				mapArbre.put(nomArbre, floristeria);

				//retirarFlor(); ya no te sirve porque elimina toda Flor no una unica flor como me habíais dicho

				Arbre a = (Arbre) buscarProducto(nomArbre, floristeria);

				// aqui l'enregistro al tiquet que haura de sortir per la caixa
				ArrayList<Producte> producteArrayListArbre;
				if (ticket.getLlistaComprat() == null) {
					producteArrayListArbre = new ArrayList<Producte>();
				} else {
					producteArrayListArbre = ticket.getLlistaComprat();
				}

				producteArrayListArbre.add(a);
				ticket.setLlistaComprat(producteArrayListArbre);

				break;
			case 2:
				floristeria.getConjuntFlors().forEach(x -> System.out.println(x.getNom()));
				EscribirTxt.escribirTxt("  Comprant flor:");
				String nomFlor = Entrada.leerString("Quina flor vols comprar?");
				EscribirTxt.escribirTxt("  "+nomFlor);
				Map<String, Floristeria> mapFlor = new HashMap<>();
				mapFlor.put(nomFlor, floristeria);

				//retirarFlor(); ya no te sirve porque elimina toda Flor no una unica flor como me habíais dicho

				Flor f = (Flor) buscarProducto(nomFlor, floristeria);

				// aqui l'enregistro al tiquet que haura de sortir per la caixa
				ArrayList<Producte> producteArrayListFlor;
				if (ticket.getLlistaComprat() == null) {
					producteArrayListFlor = new ArrayList<Producte>();
				} else {
					producteArrayListFlor = ticket.getLlistaComprat();
				}

				producteArrayListFlor.add(f);
				ticket.setLlistaComprat(producteArrayListFlor);
				break;
			case 3:
				floristeria.getConjuntDecoracio().forEach(x -> System.out.println(x.getNom()));
				EscribirTxt.escribirTxt("  Comprant decoració:");
				String nomDecoracio = Entrada.leerString("Quina decoracio vols comprar?");
				EscribirTxt.escribirTxt("  "+nomDecoracio);
				Map<String, Floristeria> mapDecoracio = new HashMap<>();
				mapDecoracio.put(nomDecoracio, floristeria);

				//retirarFlor(); ya no te sirve porque elimina toda Flor no una unica flor como me habíais dicho

				Decoracio e = (Decoracio) buscarProducto(nomDecoracio, floristeria);
				 

				// aqui l'enregistro al tiquet que haura de sortir per la caixa
				ArrayList<Producte> producteArrayListDecoracio;
				if (ticket.getLlistaComprat() == null) {
					producteArrayListDecoracio = new ArrayList<Producte>();
				} else {
					producteArrayListDecoracio = ticket.getLlistaComprat();
				}

				//producteArrayListDecoracio.add(e);
				ticket.setLlistaComprat(producteArrayListDecoracio);
				break;
			}
		} while (i != 4);
		ArrayList<Ticket> historicDeTickets = floristeria.getHistoricDeTickets();
		historicDeTickets.add(ticket);
		floristeria.setHistoricDeTickets(historicDeTickets);
		return ticket;
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

		/*
		 * 
		 * //total del venut a totes les floristeries, que m'he confos i ja que l'he fet
		 * //el borrare mes tard per si un cas sigués necessari Double totalDeTot =
		 * floristerias.stream().map(x -> compresAntigues(Optional.of(x))).mapToDouble(s
		 * -> s).sum(); System.out.println("El total de totes les floristeries és de :"
		 * + totalDeTot);
		 * 
		 */
	}
}