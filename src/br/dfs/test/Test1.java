package br.dfs.test;

import java.io.File;

import br.dfs.DFS2;
import br.dfs.Grafo;
import br.dfs.util.GerenteArquivos;

public class Test1 {

	public static void main(String[] args) throws Exception {
		Grafo g = new Grafo();
		File f = GerenteArquivos.getInstance().getOpenFile();
		g.loadFromFile( f );
		DFS2 dfs = new DFS2( g );
		dfs.execute();
		System.out.println( dfs.toString() );
		//File save = GerenteArquivos.getInstance().getSaveFile();
		//GraphUtils.writeGMLFile( g );
	}

}
