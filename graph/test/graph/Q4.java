package graph;

import org.junit.Assert;
import org.junit.Test;

public class Q4 {

	@Test
	public void shortestPathTest() {
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

		Path<String> path = graph.findShortestPath(d, r);
		Assert.assertEquals("[d -> f, f -> m, m -> l, l -> r] -> weight: 80", path.toString());
		Assert.assertTrue(path.getWeight() == 80);
	}

}
