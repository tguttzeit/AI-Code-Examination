class BellmanFord:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = []

    def add_edge(self, source, destination, weight):
        self.graph.append((source, destination, weight))

    def bellman_ford(self, source):
        # Initialize distances to all vertices as infinity and the source as 0
        distances = {v: float('inf') for v in range(self.vertices)}
        distances[source] = 0

        # Relax all edges |V| - 1 times
        for _ in range(self.vertices - 1):
            for source_vertex, dest_vertex, edge_weight in self.graph:
                if distances[source_vertex] != float('inf') and distances[source_vertex] + edge_weight < distances[dest_vertex]:
                    distances[dest_vertex] = distances[source_vertex] + edge_weight

        # Check for negative cycles
        for source_vertex, dest_vertex, edge_weight in self.graph:
            if distances[source_vertex] != float('inf') and distances[source_vertex] + edge_weight < distances[dest_vertex]:
                return None  # Negative cycle exists

        # Filter out vertices with no path and return the result as a dictionary
        shortest_paths = {v: dist for v, dist in distances.items() if dist != float('inf')}
        return shortest_paths
