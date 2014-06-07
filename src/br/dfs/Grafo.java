package br.dfs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Grafo {
	char[] vertices;
	ArrayList<Aresta> arestas = new ArrayList<Aresta>();

	public char[] getVertices() {
		return vertices;
	}

	public ArrayList<Aresta> getArestas() {
		return arestas;
	}

	public Grafo() {
		
	}
	
	public Grafo(ArrayList<Aresta> la, char[] v) {
		arestas = ( ArrayList<Aresta> )la.clone();
		if( v != null )
			addVertices(v);
	}

	public void addVertices(char[] v) {
		if (vertices != null && vertices.length == v.length) {
			System.arraycopy(v, 0, vertices, 0, v.length);
			return;
		}
		
		vertices = v.clone();
	}

	public void addAresta(Aresta a) {
		arestas.add(a);
	}

	public void criaVertices( int len ) {
		vertices = new char[ len ];
		char tmp = 'a';
		for( int i=0; i<vertices.length; i++ ){
			vertices[i] = tmp++;
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
					Aresta a = new Aresta( numeroLinha, numeroColuna, tmp );
					addAresta( a );
				}
			}
		}

		br.close();
	}
}
