package br.dfs3;

import java.util.ArrayList;

public class DFS3 extends Grafo3 {

	BuscaInfo3 listaInfo[];
	int time = 0;
	
	public DFS3( Grafo3 g ) throws Exception {
		super( g.arestas, g.vertices );
		listaInfo = new BuscaInfo3[ vertices.length ];
		for( int i=0; i<listaInfo.length; i++ ) {
			listaInfo[i] = new BuscaInfo3( vertices[ i ] );
		}
		buildAdjacentes();
	}
	
	public void sortVertexFu() {
		
	}
	
	public void buildAdjacentes() throws Exception {
		ArrayList<Aresta3> tmp = new ArrayList<Aresta3>();
		
//		for( int vertex=0; vertex<vertices.length; vertex++ ) {
		for( Vertice3 vertex : vertices ) {
			tmp.clear();
			for( Aresta3 a : arestas ) {
				if( a.vi[0] == vertex )
					tmp.add( a );
			}
			BuscaInfo3 bi = BuscaInfo3.findBi( vertex, listaInfo );
			bi.setAdjacentes( tmp );
		}
	}
	
	public void execute() throws Exception {
		for( BuscaInfo3 bi : listaInfo ) {
			if( bi.color == COLOR_DFS.WHITE ) {
				visite( bi );
			}
		}
	}

	public void visite( BuscaInfo3 u ) throws Exception {
		u.color = COLOR_DFS.GRAY;
		u.du = ++time;
		for( Vertice3 vert : u.listAdj ) {
			BuscaInfo3 v = BuscaInfo3.findBi( vert, listaInfo );
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
		for( BuscaInfo3 bi : listaInfo ) {
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
