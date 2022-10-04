package org.example.utilities;

import java.io.FileWriter;
import java.io.PrintWriter;

public class EscribirTxt {
	private static FileWriter fichero = null;
	private static PrintWriter pw = null;

	public static void crearTxt() {
		int i=0;
		// creo el escritor y fichero
		try {
			fichero = new FileWriter("floristerias.txt");
			pw = new PrintWriter(fichero);

		} catch (Exception e) {
			e.printStackTrace();
			i++;
			try {
				
				fichero = new FileWriter("floristerias"+i+".txt");
				pw = new PrintWriter(fichero);

			} catch (Exception e1) {
				e1.printStackTrace();
				
			}
		}

	}

	public static void escribirTxt(String texto) {
		FileWriter fichero = null;
		PrintWriter pw = null;
		// creo el escritor y fichero
		try {
			fichero = new FileWriter("floristerias.txt");
			pw = new PrintWriter(fichero);

			pw.println(texto);

		} catch (Exception e) {

		} finally {

			try {

				if (null != fichero)
					fichero.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public static void cerrarTxt() {

		try {

			if (null != fichero)
				fichero.close();
		} catch (Exception e2) {
			e2.printStackTrace();
		}

	}

}