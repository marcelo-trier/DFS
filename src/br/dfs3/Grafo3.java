package br.dfs3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Grafo3 {
	Vertice3[] vertices;
	ArrayList<Aresta3> arestas = new ArrayList<Aresta3>();

	public Vertice3[] getVertices() {
		return vertices;
	}

	public void transpose() {
		Vertice3 tmp;
		for( Aresta3 a : arestas ) {
			tmp = a.vi[0];
			a.vi[0] = a.vi[1];
			a.vi[1] = tmp;
		}
	}
	
	public ArrayList<Aresta3> getArestas() {
		return arestas;
	}

	public Grafo3() {}
	
	public Grafo3(ArrayList<Aresta3> la, Vertice3[] v) {
		arestas = ( ArrayList<Aresta3> )la.clone();
		if( v != null )
			addVertices(v);
	}

	public void addVertices( Vertice3[] v) {
		if (vertices != null && vertices.length == v.length) {
			System.arraycopy(v, 0, vertices, 0, v.length);
			return;
		}
		
		vertices = v.clone();
	}

	public void addAresta(Aresta3 a) {
		arestas.add(a);
	}

	public void criaVertices( int len ) {
		vertices = new Vertice3[ len ];
		char tmp = 'a';
		String label;
		for( int i=0; i<vertices.length; i++ ){
			label = "" + tmp++;
			vertices[i] = new Vertice3( i, label );
		}
		addVertices( vertices );
	}
	
	public void loadFromFile( File f ) throws Exception {
		FileReader fr = new FileReader( f );
		BufferedReader br = new BufferedReader( fr );
		String linha;
		int numeroLinha = -1;

		while( ( linha = br.readLine() ) != null ) {
			linha = linha.trim();
			if( linha.equals("") || linha.charAt( 0 ) == '#' ) {
				continue;
			}
			numeroLinha++;
			String[] tokens = linha.split( "\\s+" ); // pega qualquer coisa: espaço, tab, quebra de linha, etc..
			if( vertices == null ) {
				criaVertices( tokens.length );
			}

			for( int numeroColuna=0; numeroColuna<tokens.length; numeroColuna++ ) {
				int tmp = Integer.parseInt( tokens[ numeroColuna ] );
				if( tmp != -1 ) {
					Vertice3 v1, v2;
					v1 = vertices[ numeroLinha ];
					v2 = vertices[ numeroColuna ];
					Aresta3 a = new Aresta3( v1, v2, tmp );
					addAresta( a );
				}
			}
		}

		br.close();
	}
}
