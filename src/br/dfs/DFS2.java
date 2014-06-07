package br.dfs;

import java.util.ArrayList;

public class DFS2 extends Grafo {

	BuscaInfo listaInfo[];
	int time = 0;
	
	public DFS2( Grafo g ) throws Exception {
		super( g.arestas, g.vertices );
		listaInfo = new BuscaInfo[ vertices.length ];
		for( int i=0; i<listaInfo.length; i++ ) {
			listaInfo[i] = new BuscaInfo( i );
		}
		buildAdjacentes();
	}
	
	public void buildAdjacentes() throws Exception {
		ArrayList<Aresta> tmp = new ArrayList<Aresta>();
		for( int vertex=0; vertex<vertices.length; vertex++ ) {
			tmp.clear();
			for( Aresta a : arestas ) {
				if( a.vi[0] == vertex )
					tmp.add( a );
			}
			listaInfo[ vertex ].setAdjacentes( tmp );
		}
	}
	
	public void execute() throws Exception {
		for( BuscaInfo bi : listaInfo ) {
			if( bi.color == COLOR_DFS.WHITE ) {
				visite( bi );
			}
		}
	}

	public void visite( BuscaInfo u ) throws Exception {
		u.color = COLOR_DFS.GRAY;
		u.du = ++time;
		for( int vi : u.listAdj ) {
			BuscaInfo v = BuscaInfo.findBi( vi, listaInfo );
			if( v.color == COLOR_DFS.WHITE ) {
				v.pi = u.vertex;
				visite( v );
			}
		}
		u.color = COLOR_DFS.BLACK;
		u.fu = ++time;
	}
	
	public String toString() {
		String msg;
		String du = "du[] = { ";
		String fu = "fu[] = { ";
		String pi = "pi[] = { ";
		msg = "#DFS\n";
		for( BuscaInfo bi : listaInfo ) {
			du += bi.du + ", ";
			fu += bi.fu + ", ";
			//int vertex = ( bi.pi == null ) ? -1 : bi.pi.vertex;
			pi += bi.pi + ", ";
		}
		du = du.substring( 0, du.length() - 2 ) + " };";
		fu = fu.substring( 0, fu.length() - 2 ) + " };";
		pi = pi.substring( 0, pi.length() - 2 ) + " };";
		
		msg += du + "\n" + fu + "\n" + pi;
		
		return msg;
	}
}
