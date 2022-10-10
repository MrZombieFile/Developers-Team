package org.example.utilities;


import java.io.FileWriter;
import java.io.PrintWriter;

public class EscribirTxt {
	private static FileWriter fichero = null;

	public static void escribirTxt(String texto) {
		FileWriter fichero = null;
		PrintWriter pw = null;
		// creo el escritor y fichero
		try {
			fichero = new FileWriter("floristerias.txt",true);
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

	public static void escribirFloristeriaTxt(String texto) {
		FileWriter fichero = null;
		PrintWriter pw = null;
		// creo el escritor y fichero
		try {
			fichero = new FileWriter("floristeriasArrayList.txt",true);
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

}