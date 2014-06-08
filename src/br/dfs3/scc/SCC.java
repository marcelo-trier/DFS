package br.dfs3.scc;

import java.util.ArrayList;
import java.util.Arrays;

import br.dfs3.BuscaInfo3;
import br.dfs3.DFS3;

// Strongly Connected Components
// ver: http://homepages.ius.edu/rwisman/C455/html/notes/Chapter22/SCC.htm
public class SCC extends DFS3 {

	ArrayList<ConnectedComponent> listaCC = new ArrayList<ConnectedComponent>();
	
	public SCC(DFS3 g) throws Exception {
		super(g);
		listaInfo = ( BuscaInfo3[] )g.listaInfo.clone();
	}

	public void buildConnectedComponent() {
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

	public void execute() throws Exception {
		buildConnectedComponent();
	}

	public String toString() {
		String msg = "\nSCC: ";
		for( ConnectedComponent cc : listaCC ) {
			msg += cc.toString() + "\n";
		}
		return msg;
	}
	
}
