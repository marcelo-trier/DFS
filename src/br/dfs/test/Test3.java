package br.dfs.test;

import java.io.File;

import br.dfs.util.GerenteArquivos;
import br.dfs3.DFS3;
import br.dfs3.Grafo3;

public class Test3 {

	public static void main(String[] args) throws Exception {
		Grafo3 g = new Grafo3();
		File f = GerenteArquivos.getInstance().getOpenFile();
		g.loadFromFile( f );
		DFS3 dfs = new DFS3( g );
		dfs.execute();
		System.out.println( dfs.toString() );
	}

}
