package br.dfs3;

public class Aresta3 implements Comparable<Aresta3> {
	public Vertice3 vi[] = { null, null }; // somente um indice para o vetor de vertice
	public float weight; // peso
	public String label;
	
	public Aresta3( Vertice3 v1, Vertice3 v2, float w ) {
		setInfo( v1, v2, w );
	}

	public void setInfo( Vertice3 v1, Vertice3 v2, float w ) {
		vi[0] = v1;
		vi[1] = v2;
		weight = w;
	}
	
	public int compareTo(Aresta3 o) {
		if( this.weight < o.weight )
			return -1;

		if( this.weight == o.weight )
			return 0;

		return 1;
	}
}
