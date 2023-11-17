class BellmanFord:
    def __init__(self, vertices):
        self.V = vertices
        self.graph = []

    def add_edge(self, source, destination, weight):
        self.graph.append((source, destination, weight))

    def bellman_ford(self, source):
        # Initialize distances
        distances = {v: float('inf') for v in range(self.V)}
        distances[source] = 0

        # Relax edges repeatedly
        for _ in range(self.V - 1):
            for u, v, w in self.graph:
                if distances[u] != float('inf') and distances[u] + w < distances[v]:
                    distances[v] = distances[u] + w

        # Check for negative cycles
        for u, v, w in self.graph:
            if distances[u] != float('inf') and distances[u] + w < distances[v]:
                return None  # Negative cycle detected

        # Remove unreachable nodes
        result = {k: v for k, v in distances.items() if v != float('inf')}

        return result
