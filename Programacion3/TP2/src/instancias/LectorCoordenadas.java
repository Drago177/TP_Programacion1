package instancias;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.openstreetmap.gui.jmapviewer.Coordinate;

public class LectorCoordenadas {
	private static FileInputStream fis;
	private static Scanner scanner;
	private static File archivo;
	private static List<Coordinate> coordenadas;
	
	public static List<Coordinate> getCoordenadas(String arch) {
		coordenadas = new ArrayList<>();
		archivo = new File("src/instancias/instancia1.txt");
		try {
			fis = new FileInputStream(archivo);
			scanner = new Scanner(fis);
			leerCoordenadas();
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return coordenadas;
	}

	private static void leerCoordenadas() {
		int cont = 1;
		double latitud = 0;
		double longitud = 0;
		while(scanner.hasNextDouble()) {
			if(cont == 1)
				latitud = scanner.nextDouble();
			if(cont == 2) {
				longitud = scanner.nextDouble();
				coordenadas.add(new Coordinate(latitud, longitud));
				cont = 0;
			}
			cont++;
		}
	}

}
