package graph;

import java.util.LinkedHashSet;
import java.util.Set;

public class Path<E> {

	private Set<Vertex<E>.Edge> edges = new LinkedHashSet<>();

	public Set<Vertex<E>.Edge> getVertices() {
		return edges;
	}

	public void setVertices(Set<Vertex<E>.Edge> edges) {
		this.edges = edges;
	}

	public Path<E> getCopy() {
		Path<E> newPath = new Path<>();
		for (Vertex<E>.Edge edge : edges) {
			newPath.getVertices().add(edge);
		}
		return newPath;
	}

	public Integer getWeight() {
		Integer total = 0;
		for (Vertex<E>.Edge edge : edges) {
			total += edge.getWeight();
		}
		return total;
	}

	@Override
	public String toString() {
		return edges.toString() + " -> weight: " + getWeight();
	}
}
