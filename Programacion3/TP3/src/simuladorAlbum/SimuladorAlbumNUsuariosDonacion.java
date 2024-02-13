package simuladorAlbum;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import modelo.Usuario;

public class SimuladorAlbumNUsuariosDonacion extends SimuladorAlbumNUsuarios {
	List<Integer> cajaComunal;

	public SimuladorAlbumNUsuariosDonacion(int cantFiguritas, int tamanioPaquete, int cantidadUsuarios) {
		super(cantFiguritas, tamanioPaquete, cantidadUsuarios);
		cajaComunal = new ArrayList<>();
	}

	@Override
	public void simular() {
		int albumsCompletados = 0;
		while(albumsCompletados < getCantUsuarios())
			for(int i = 0; i < getCantUsuarios(); i++) {
				Usuario usuario = getUsuario(i);
				if(usuario.albumCompletado())
					albumsCompletados++;
				else {
					if(!cajaComunal.isEmpty())
						tomarDonativo(i);
					else {
						usuario.llenarAlbum(vender());
						cajaComunal.addAll(getUsuario(i).donar());
					}
				}
			}
	}

	public void tomarDonativo(int i) {
		Usuario usuario = getUsuario(i);
		Iterator<Integer> it = cajaComunal.iterator();
		while(it.hasNext()) {
			int figurita = it.next();
			if(usuario.llenarAlbum(figurita))
				it.remove();
		}
	}

}
