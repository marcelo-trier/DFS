package br.dfs.test;

import java.io.File;

import br.dfs.Grafo;
import br.dfs.util.GerenteArquivos;

public class Test4 {

	public static void main(String[] args) throws Exception {
		Grafo g = new Grafo();
		File f = GerenteArquivos.getInstance().getOpenFile();
		g.loadFromFile( f );
//		SCC scc = new SCC( g );
//		scc.execute();
//		System.out.println( scc.toString() );
	}
}
