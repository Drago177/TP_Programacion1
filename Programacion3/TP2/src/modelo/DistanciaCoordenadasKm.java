package modelo;

import org.openstreetmap.gui.jmapviewer.Coordinate;

public class DistanciaCoordenadasKm {
	private static double radioTierra = 6371; // kilometros
	
	public static double calcular(Coordinate c1, Coordinate c2) {
		return haversine(c1, c2);
	}
	
	private static double haversine(Coordinate c1, Coordinate c2) {
		double lat1 = c1.getLat();
		double lon1 = c1.getLon();
		double lat2 = c2.getLat();
		double lon2 = c2.getLon();
		double latitud1 = lat1 * Math.PI/180;
		double latitud2 = lat2 * Math.PI/180;
		double difLat = (lat2-lat1) * Math.PI/180;
		double difLon = (lon2-lon1) * Math.PI/180;
		
		double a = Math.sin(difLat/2) * Math.sin(difLat/2) +
				Math.cos(latitud1) * Math.cos(latitud2) *
				Math.sin(difLon/2) * Math.sin(difLon/2);
		
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

		return radioTierra * c;
	}
}
