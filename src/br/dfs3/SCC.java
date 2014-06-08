package br.dfs3;

import java.util.ArrayList;
import java.util.Arrays;

// Strongly Connected Components
// ver: http://homepages.ius.edu/rwisman/C455/html/notes/Chapter22/SCC.htm
public class SCC extends DFS3 {

	class ConnectedComponent {
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

	ArrayList<ConnectedComponent> listaCC = new ArrayList<ConnectedComponent>();
	
	public SCC(DFS3 g) throws Exception {
		super(g);
		listaInfo = g.listaInfo.clone();
	}

	public void execute() {
		Arrays.sort( listaInfo ); // ordena fu em ordem crescente...
		ConnectedComponent ccTmp = new ConnectedComponent();
		listaCC.add( ccTmp );
		int antecessor = listaInfo[ 0 ].fu - 1;
		for( int i=0; i<listaInfo.length; i++ ) {
			BuscaInfo3 bi = listaInfo[ i ];
			if( antecessor != bi.fu - 1 ) {
				ccTmp = new ConnectedComponent();
				listaCC.add( ccTmp );
			}
			ccTmp.add( bi );
			antecessor = bi.fu;
		}
	}

	public String toString() {
		String msg = "\nSCC: ";
		for( ConnectedComponent cc : listaCC ) {
			msg += cc.toString() + "\n";
		}
		return msg;
	}
	
}
