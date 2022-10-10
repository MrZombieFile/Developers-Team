package org.example.utilities;


import org.example.floristeria.Floristeria;
import org.example.floristeria.stock.Arbre;
import org.example.floristeria.stock.Decoracio;
import org.example.floristeria.stock.Flor;


public class Buscar {
	public static Flor buscarFlor(String nom, Floristeria floristeria) {
		boolean encontrado = false;
		int i = 0;
		Flor producto = null;
		while (encontrado == false && i < floristeria.getConjuntFlors().size()) {

			if (floristeria.getConjuntFlors().get(i).getNom().equalsIgnoreCase(nom)) {
				encontrado = true;
				producto = floristeria.getConjuntFlors().get(i);
			}
			i++;

		}
		return producto;
	}
	public static Arbre buscarA(String nom, Floristeria floristeria) {
		boolean encontrado = false;
		int i = 0;
		Arbre producto = null;
		while (encontrado == false && i < floristeria.getConjuntFlors().size()) {

			if (floristeria.getConjuntArbres().get(i).getNom().equalsIgnoreCase(nom)) {
				encontrado = true;
				producto = floristeria.getConjuntArbres().get(i);
			}
			i++;

		}
		return producto;
	}
	public static Decoracio buscarD(String nom, Floristeria floristeria) {
		boolean encontrado = false;
		int i = 0;
		Decoracio producto = null;
		while (encontrado == false && i < floristeria.getConjuntFlors().size()) {

			if (floristeria.getConjuntDecoracio().get(i).getNom().equalsIgnoreCase(nom)) {
				encontrado = true;
				producto = floristeria.getConjuntDecoracio().get(i);
			}
			i++;

		}
		return producto;
	}
}
