package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import agm.ArbolGeneradorMinimo;
import grafos.Arco;
import grafos.Grafo;

public class Clustering {
	private Grafo grafoClust;
	private int cantClusters;
	
	public Clustering(ArbolGeneradorMinimo agm) {
		grafoClust = agm.construirAGM();
	}
	
	public Grafo getClusters(int cantClusters) {
		if(cantClusters < 2  || cantClusters > grafoClust.tamano())
			throw new IllegalArgumentException("La cantidad de clusters no debe ser "
					+ "menor a 2 ni mayor a la cantidad de vertices:" + grafoClust.tamano());
		this.cantClusters = cantClusters;
		crearClusters();
		return grafoClust;
	}
	
	public void crearClusters() {
		List<Arco> arcos = new ArrayList<>();
		for(int i = 0; i < grafoClust.tamano(); i++) {
			for(Arco arco : grafoClust.getArcosI(i)) {
				if(!arcos.contains(arco)) {
					arcos.add(arco);
				}
			}
		}
		Collections.sort(arcos);
		Collections.reverse(arcos);
		for(int i = 0; i < cantClusters-1; i++) {
			grafoClust.eliminarArco(arcos.get(i).getI(), arcos.get(i).getJ());
		}
	}
	
}
