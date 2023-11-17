class BellmanFord:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = []

    def add_edge(self, source, destination, weight):
        self.graph.append((source, destination, weight))

    def bellman_ford(self, source):
        # Initialize distance array with maximum values
        distance = {v: float('inf') for v in range(self.vertices)}
        distance[source] = 0

        # Relax edges |V| - 1 times
        for _ in range(self.vertices - 1):
            for u, v, w in self.graph:
                if distance[u] != float('inf') and distance[u] + w < distance[v]:
                    distance[v] = distance[u] + w

        # Check for negative cycles
        for u, v, w in self.graph:
            if distance[u] != float('inf') and distance[u] + w < distance[v]:
                return None  # Negative cycle detected

        # Create the result dictionary, skipping nodes with no path
        result = {}
        for v in range(self.vertices):
            if distance[v] != float('inf'):
                result[v] = distance[v]

        return result
