package grafos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Grafo
{
	// Representamos el grafo por su matriz de adyacencia
	private boolean[][] A;
	private List<Arco> arcos;
	
	// La cantidad de vertices esta predeterminada desde el constructor
	public Grafo(int vertices)
	{
		A = new boolean[vertices][vertices];
		arcos = new ArrayList<>();
	}
	
	// Agregado de aristas
	public void agregarArco(int i, int j, double peso)
	{
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintos(i, j);

		A[i][j] = true;
		A[j][i] = true;
		
		arcos.add(new Arco(i, j, peso));
	}
	
	// Eliminacion de aristas
	public void eliminarArco(int i, int j)
	{
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintos(i, j);

		A[i][j] = false;
		A[j][i] = false;
		
		arcos.remove(new Arco(i, j, 0));
	}

	// Informa si existe la arista especificada
	public boolean existeArista(int i, int j)
	{
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintos(i, j);

		return A[i][j];
	}

	// Cantidad de vertices
	public int tamano()
	{
		return A.length;
	}
	
	// Vecinos de un vertice
	public Set<Integer> vecinos(int i)
	{
		verificarVertice(i);
		
		Set<Integer> ret = new HashSet<Integer>();
		for(int j = 0; j < this.tamano(); ++j) if( i != j )
		{
			if( this.existeArista(i,j) )
				ret.add(j);
		}
		
		return ret;		
	}
	
	public double getPesoArco(int i, int j) {
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintos(i, j);
		Arco arco = new Arco(i, j, 0);
		return arcos.get(arcos.indexOf(arco)).getPeso();
	}
	
	// Verifica que sea un vertice valido
	private void verificarVertice(int i)
	{
		if( i < 0 )
			throw new IllegalArgumentException("El vertice no puede ser negativo: " + i);
		
		if( i >= A.length )
			throw new IllegalArgumentException("Los vertices deben estar entre 0 y |V|-1: " + i);
	}

	// Verifica que i y j sean distintos
	private void verificarDistintos(int i, int j)
	{
		if( i == j )
			throw new IllegalArgumentException("No se permiten loops: (" + i + ", " + j + ")");
	}
	
	public List<Arco> getArcosI(int i) {
		List<Arco> arcosI = new ArrayList<>();
		for(Integer v : vecinos(i)) {
			arcosI.add(new Arco(i, v, getPesoArco(i, v)));
		}
		return arcosI;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < A.length; i++) {
			sb.append(i).append(" ");
			for(int j = 0; j < A[0].length; j++) {
				sb.append(A[i][j]).append(", ");
			}
			sb.append("\n").append("\n");
		}
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(A);
		result = prime * result + Objects.hash(arcos);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grafo other = (Grafo) obj;
		return Arrays.deepEquals(A, other.A) && Objects.equals(arcos, other.arcos);
	}
	
	@Override
	public Grafo clone() {
		Grafo grafo = new Grafo(tamano());
		grafo.A = A.clone();
		grafo.arcos.addAll(arcos);
		return grafo;
	}
	
}
