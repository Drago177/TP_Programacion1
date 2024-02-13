package agm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import grafos.Grafo;
import grafos.Arco;

public class ArbolGeneradorMinimo {

	private Grafo g;
	private Set<Integer> Vt;
	private List<Arco> Et;
	
	public ArbolGeneradorMinimo(Grafo g) {
		this.g = g;
		Vt = new HashSet<>();
		Et = new ArrayList<>();
	}
	
	public Grafo construirAGM() {
		return prim();
	}
	
	private Grafo prim() {
		Arco arcoMin;
		primerArcoMinimo();
		int i = 0;
		while(i < g.tamano()) {
			arcoMin = getArcoMinimoVt();
			if(arcoMin != null)
				agregarVisitados(arcoMin);
			i++;
		}
		return crearGrafo();
	}

	private void primerArcoMinimo() {
		Vt.add(0);
		Arco arcoMin = getArcoMinimoVt();
		agregarVisitados(arcoMin);
	}

	private void agregarVisitados(Arco arcoMin) {
		Et.add(arcoMin);
		Vt.add(arcoMin.getJ());
	}
	
	private List<Arco> getAristasVt() {
		List<Arco> arcos = new ArrayList<>();
		for(Integer v : Vt)
			for(Arco a : g.getArcosI(v))
				if(!Et.contains(a) && !Vt.contains(a.getJ()))
					arcos.add(a);
		return arcos;
	}
	
	private Arco getArcoMinimoVt() {
		List<Arco> arcos = getAristasVt();
		if(arcos.isEmpty())
			return null;
		Collections.sort(arcos);
		return arcos.get(0);
	}

	private Grafo crearGrafo() {
		Grafo g = new Grafo(this.g.tamano());
		for(Arco arco : Et) {
			g.agregarArco(arco.getI(), arco.getJ(), Et.get(Et.indexOf(arco)).getPeso());
		}
		return g;
	}
	
}
