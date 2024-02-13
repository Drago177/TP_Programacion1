package simuladorAlbum;

import modelo.Usuario;

public class SimuladorAlbumNUsuariosIntercambio extends SimuladorAlbumNUsuarios {

	public SimuladorAlbumNUsuariosIntercambio(int cantFiguritas, int tamanioPaquete, int cantidadUsuarios) {
		super(cantFiguritas, tamanioPaquete, cantidadUsuarios);
	}

	@Override
	public void simular() {
		int albumsCompletados = 0;
		while(albumsCompletados < getCantUsuarios()) {
			for(int i = 0; i < getCantUsuarios(); i++) {
				Usuario usuario = getUsuario(i);
				if(usuario.albumCompletado())
					albumsCompletados++;
				else
					usuario.llenarAlbum(vender());
				intercambiar();
			}
		}
	}
	
	protected void intercambiar() {
		boolean finIntercambio = false;
		for(int i = 0; i < getCantUsuarios()-1; i++) {
			if(!getUsuario(i).albumCompletado())
				for(int j = i+1; j < getCantUsuarios(); j++) {
					if(!getUsuario(j).albumCompletado())
						while(!finIntercambio)
							finIntercambio = !(getUsuario(i).intercambiar(getUsuario(j)));
				}
		}
	}

}
