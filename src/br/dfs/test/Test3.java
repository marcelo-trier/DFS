package br.dfs.test;

import java.io.File;

import br.dfs.util.GerenteArquivos;
import br.dfs3.DFS3;
import br.dfs3.Grafo3;
import br.dfs3.SCC;

public class Test3 {

	public static void main(String[] args) throws Exception {
		Grafo3 g = new Grafo3();
		File f = GerenteArquivos.getInstance().getOpenFile();
		g.loadFromFile( f );
		DFS3 dfs = new DFS3( g );
		dfs.execute( 2 );
		System.out.println( dfs.toString() );

		System.out.println( "\n------------[ sorting (fu)... ]------------");
		dfs.sortFu();
		System.out.println( dfs.toString() );

		System.out.println( "\n------------[ transpose ... ]------------");
		dfs.transpose();
		System.out.println( dfs.toString() );
		
		System.out.println( "\n------------[ second time ... ]------------");
		DFS3 dfs2 = new DFS3( dfs );
		dfs2.execute();
		System.out.println( dfs2.toString() );
		
		System.out.println( "\n------------[ SCC ... ]------------");
		SCC scc = new SCC( dfs2 );
		scc.execute();
		System.out.println( scc.toString() );
	}
}
