package modelo;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private Album album;
	private int _paquetesComprados;
	private List<Integer> figuritasSobrantes;
	
	public Usuario(int cantFiguritas) {
		album = new Album(cantFiguritas);
		figuritasSobrantes = new ArrayList<>();
	}
	
	public void llenarAlbum(List<Integer> paquete) {
		_paquetesComprados++;
		for(Integer figurita : paquete) {
			llenarAlbum(figurita);
		}
	}
	
	public boolean llenarAlbum(int figurita) {
		if(!album.agregarFigurita(figurita)) {
			figuritasSobrantes.add(figurita);
			return true;
		}
		return false;
	}
	
	public List<Integer> donar() {
		List<Integer> ret = new ArrayList<>();
		for(Integer figurita : figuritasSobrantes)
			ret.add(figurita);
		figuritasSobrantes = new ArrayList<>();
		return ret;
	}
	
	public boolean intercambiar(Usuario otro) {
		for(Integer figurita : figuritasSobrantes)
			for(Integer figuritaOtro : otro.figuritasSobrantes)
				if(!album.figuritaPegada(figuritaOtro) && !otro.album.figuritaPegada(figurita)) {
					llenarAlbum(figuritaOtro);
					otro.llenarAlbum(figurita);
					return true;
				}
		return false;
	}
	
	public boolean albumCompletado() {
		return album.completado();
	}
	
	public Album getAlbum() {
		return album;
	}
	
	public List<Integer> getFiguritasSobrantes() {
		return figuritasSobrantes;
	}
	
	public int getPaquetesComprados() {
		return _paquetesComprados;
	}
}
