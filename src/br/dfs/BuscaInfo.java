package br.dfs;

import java.util.ArrayList;

enum COLOR_DFS {
	WHITE, GRAY, BLACK;
}

public class BuscaInfo {
	
	COLOR_DFS color = COLOR_DFS.WHITE;
	int vertex = 0;
	int du = 0;
	int fu = 0;
	int pi = -1; // indice do vertice anterior
	int listAdj[] = null; // indice dos verticesss

	public BuscaInfo(int vi) {
		vertex = vi;
	}

	public void setAdjacentes( ArrayList<Aresta> l ) throws Exception {
		listAdj = new int[ l.size() ];
		int i = 0;
		for (Aresta a : l) {
			listAdj[i++] = a.vi[1];
		}
	}
	
	public static BuscaInfo findBi( int vertex, BuscaInfo[] lInfo ) throws Exception {
		for( BuscaInfo bi : lInfo ) {
			if( bi.vertex == vertex )
				return bi;
		}
		throw new Exception( "nao encontrado ID... verificar!" );
	}
}
