package graph;

import org.junit.Assert;
import org.junit.Test;

public class Q3 {

	@Test
	public void countPathsTest() {
		Graph<String> graph = new Graph<>();
		Vertex<String> d = graph.addVertex("d");
		Vertex<String> g = graph.addVertex("g");
		Vertex<String> f = graph.addVertex("f");
		Vertex<String> r = graph.addVertex("r");
		Vertex<String> o = graph.addVertex("o");
		Vertex<String> m = graph.addVertex("m");
		Vertex<String> l = graph.addVertex("l");

		d.addEdge(g, 100);
		d.addEdge(f, 10);
		f.addEdge(o, 15);
		f.addEdge(m, 25);
		f.addEdge(r, 75);
		g.addEdge(r, 30);
		o.addEdge(m, 55);
		m.addEdge(l, 40);
		l.addEdge(r, 5);

		int result = graph.findAllPaths(d, r).size();

		Assert.assertTrue(result == 4);
	}

}
