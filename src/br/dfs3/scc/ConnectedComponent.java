package br.dfs3.scc;

import java.util.ArrayList;

import br.dfs3.BuscaInfo3;
import br.dfs3.Vertice3;

public class ConnectedComponent {
	ArrayList<Vertice3> listaV = new ArrayList<Vertice3>();
	
	public void add( BuscaInfo3 bi ) {
		listaV.add( bi.vertex );
	}
	
	public String toString() {
		String msg = "CC[ ";
		for( Vertice3 v : listaV ) {
			msg += v.toString() + " | ";
		}
		msg = msg.substring( 0, msg.length() - 2 );
		msg += " ]";
		return msg;
	}
}

