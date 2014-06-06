package br.dfs;

import java.util.ArrayList;
import java.util.Arrays;

public class DFS extends Grafo {

	public enum COLOR_DFS {
		WHITE, GRAY, BLACK;
	}
	
	int dU[];
	int fU[];
	int pi[]; // o pi aponta p/ o vertice
	COLOR_DFS color[];
	int time = 0;
	int adjacentes[][];
	
	public DFS( Grafo g ) {
		super( g.arestas, g.vertices );
		dU = new int[ vertices.length ];
		fU = new int[ vertices.length ];
		pi = new int[ vertices.length ];
		Arrays.fill( pi, -1 );
		color = new COLOR_DFS[ vertices.length ];
		Arrays.fill( color, COLOR_DFS.WHITE );
		buildAdjacentes();
	}
	
	public void buildAdjacentes() {
		adjacentes = new int[ vertices.length ][];
		ArrayList<Aresta> tmp = new ArrayList<Aresta>();
		for( int vertex=0; vertex<vertices.length; vertex++ ) {
			tmp.clear();
			for( Aresta a : arestas ) {
				if( a.vi[0] == vertex )
					tmp.add( a );
			}
			adjacentes[ vertex ] = new int[ tmp.size() ];
			int i=0;
			for( Aresta a : tmp ) {
				adjacentes[ vertex ][ i++ ] = a.vi[ 1 ];
			}
		}
	}
	
	public void execute() {
		for( int u=0; u<vertices.length; u++ ) {
			if( color[u] == COLOR_DFS.WHITE ) {
				visite( u );
			}
		}
	}

	public void visite( int u ) {
		color[ u ] = COLOR_DFS.GRAY;
		dU[ u ] = ++time;
		for( int v : adjacentes[ u ] ) {
			if( color[ v ] == COLOR_DFS.WHITE ) {
				pi[ v ] = u;
				visite( v );
			}
		}
		color[ u ] = COLOR_DFS.BLACK;
		fU[ u ] = ++time;
	}

	public String toString() {
		String msg;
		msg = "#DFS\n";
		msg += "du[] = { ";
		for( int d : dU ) {
			msg += d + ", ";
		}
		msg = msg.substring(0, msg.length()-2 );
		msg += " };\n";
		msg += "fu[] = { ";
		for( int f : fU ) {
			msg += f + ", ";
		}
		msg = msg.substring(0, msg.length()-2 );
		msg += " };\n";
		msg += "PI[] = { ";
		for( int p : pi ) {
			msg += p + ", ";
		}
		msg = msg.substring(0, msg.length()-2 );
		msg += " };\n";
		return msg;
	}
	
	
}
