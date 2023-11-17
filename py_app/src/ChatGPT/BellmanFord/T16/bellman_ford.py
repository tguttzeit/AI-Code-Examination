class BellmanFord:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = []

    def add_edge(self, source, destination, weight):
        self.graph.append((source, destination, weight))

    def bellman_ford(self, source):
        # Initialize distances to all vertices as infinity and the source vertex as 0.
        distances = {v: float('inf') for v in range(self.vertices)}
        distances[source] = 0

        # Relax all edges |V| - 1 times.
        for _ in range(self.vertices - 1):
            for u, v, w in self.graph:
                if distances[u] != float('inf') and distances[u] + w < distances[v]:
                    distances[v] = distances[u] + w

        # Check for negative cycles.
        for u, v, w in self.graph:
            if distances[u] != float('inf') and distances[u] + w < distances[v]:
                return None  # Negative cycle detected

        # Remove vertices with no path from the result.
        result = {v: distances[v] for v in range(self.vertices) if distances[v] != float('inf')}

        return result
