package graph;

public class Main {

	public static void main(String[] args) {
		Graph<Integer> graph = new Graph<>();
		Vertex<Integer> zero = graph.addVertex(0);
		Vertex<Integer> one = graph.addVertex(1);
		Vertex<Integer> two = graph.addVertex(2);
		Vertex<Integer> three = graph.addVertex(3);
		Vertex<Integer> four = graph.addVertex(4);

		zero.addEdge(one, 20);
		zero.addEdge(three, 70);
		zero.addEdge(four, 40);
		one.addEdge(two, 15);
		two.addEdge(three, 30);
		four.addEdge(three, 35);
		
		
		System.out.println(graph.findShortestPath(one, three));
		System.out.println(graph.findShortestPathLambda(zero, three));
		
	}
}
