package br.dfs3;

import java.util.ArrayList;

enum COLOR_DFS {
	WHITE, GRAY, BLACK;
}

public class BuscaInfo3 implements Comparable<BuscaInfo3> {
	
	COLOR_DFS color = COLOR_DFS.WHITE;
	Vertice3 vertex = null;
	int du = 0;
	int fu = 0;
	Vertice3 pi = null; // indice do vertice anterior
	Vertice3 listAdj[] = null; // indice dos verticesss

	public BuscaInfo3( Vertice3 vi ) {
		vertex = vi;
	}

	public void setAdjacentes( ArrayList<Aresta3> l ) throws Exception {
		listAdj = new Vertice3[ l.size() ];
		int i = 0;
		for (Aresta3 a : l) {
			listAdj[i++] = a.vi[1];
		}
	}
	
	public static BuscaInfo3 findBi( Vertice3 vertex, BuscaInfo3[] lInfo ) throws Exception {
		for( BuscaInfo3 bi : lInfo ) {
			if( bi.vertex.equals( vertex ) )
				return bi;
		}
		throw new Exception( "nao encontrado ID... verificar!" );
	}

	@Override
	public int compareTo(BuscaInfo3 o) {
		if( this.fu < o.fu )
			return -1;
		else if( this.fu > o.fu )
			return 1;
		else
			return 0;
	}
}
