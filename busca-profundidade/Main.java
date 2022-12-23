
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import src.Graph;

public class Main {

	
    public static Graph graph;
	public static void main(String[] args) throws FileNotFoundException {
		int vertices = 0;
		int arestas = 0;
		int origem = 0;
		int destino = 0;
		
        for (int instancia = 1; instancia < 2; instancia++) {
			File file = new File("./ORLib/pmedteste2.txt");
			Scanner sc = new Scanner(file);

			vertices = sc.nextInt();
			arestas = sc.nextInt();
            origem = sc.nextInt();
			graph = new Graph(vertices);

			while (sc.hasNext()) {
				int i = sc.nextInt();
				int j = sc.nextInt();
				String peso = sc.next(); // Não utilizado
				graph.matrix[i - 1][j - 1] = 1;
			}

            for ( int i = 0 ; i < graph.n_vertices ; i++){
                while(graph.tabela.aindaHaVerticesParaExplorar()){
                    buscaEmProfundidade(0);
                }
            }  

            System.out.println(graph.tabela.toString());
            


			// fechar scanner
			sc.close();


		}

        
	}

    public static void buscaEmProfundidade( int v){
        graph.incrementarTempo();
        ArrayList<Integer> listaAdj= getListadeAdjacencia(graph, v);
        for( int w = 0 ; w < listaAdj.size() ; w++ ){
            if(graph.tabela.TD[listaAdj.get(w)] == 0){
                graph.tabela.pai[listaAdj.get(w)] = v;
                buscaEmProfundidade(listaAdj.get(w));
            }else if (graph.tabela.TT[w] == 0 && w != graph.tabela.pai[v]){
                System.out.println("Aresta de retorno");
            }
        }
        graph.incrementarTempo();
        graph.tabela.TT[v] = graph.T;
    }

    private static ArrayList<Integer> getListadeAdjacencia(Graph graph2, int v) {
        ArrayList<Integer> lista = new ArrayList<>();
        for ( int j = 0 ; j < graph2.n_vertices ; j ++ ){
            if(graph2.matrix[v][j] == 1){
                lista.add(j);
            }
        }
        System.out.println(lista.get(0));
        return lista;
    }

    public static int encontrarProximaArvore(Graph g){

        for ( int i = 0 ; i < g.n_vertices ; i++){
            if(g.tabela.TD[i] == 0){
                return i;
            }
        } 
        return -1;
    }

}
