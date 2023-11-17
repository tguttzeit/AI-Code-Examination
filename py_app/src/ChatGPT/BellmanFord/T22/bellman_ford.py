class BellmanFord:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = []

    def add_edge(self, source, destination, weight):
        self.graph.append([source, destination, weight])

    def bellman_ford(self, source):
        # Initialize distances to all vertices as infinity and the source vertex as 0
        distances = {v: float('inf') for v in range(self.vertices)}
        distances[source] = 0

        # Relax edges repeatedly (|V| - 1) times
        for _ in range(self.vertices - 1):
            for source_vertex, destination_vertex, edge_weight in self.graph:
                if distances[source_vertex] != float('inf') and distances[source_vertex] + edge_weight < distances[destination_vertex]:
                    distances[destination_vertex] = distances[source_vertex] + edge_weight

        # Check for negative cycles
        for source_vertex, destination_vertex, edge_weight in self.graph:
            if distances[source_vertex] != float('inf') and distances[source_vertex] + edge_weight < distances[destination_vertex]:
                return None  # Negative cycle detected

        # Remove vertices with no path and return the shortest paths
        shortest_paths = {v: d for v, d in distances.items() if d != float('inf')}
        return shortest_paths

