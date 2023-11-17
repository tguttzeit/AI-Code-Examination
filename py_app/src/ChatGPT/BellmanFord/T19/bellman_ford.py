class BellmanFord:
    def __init__(self, vertices):
        self.V = vertices
        self.graph = []

    def add_edge(self, source, destination, weight):
        self.graph.append((source, destination, weight))

    def bellman_ford(self, source):
        # Initialize distances with infinity and source with 0
        distance = {vertex: float("inf") for vertex in range(self.V)}
        distance[source] = 0

        # Relax all edges V-1 times
        for _ in range(self.V - 1):
            for u, v, w in self.graph:
                if distance[u] != float("inf") and distance[u] + w < distance[v]:
                    distance[v] = distance[u] + w

        # Check for negative cycles
        for u, v, w in self.graph:
            if distance[u] != float("inf") and distance[u] + w < distance[v]:
                return None  # Negative cycle detected

        # Create a dictionary with the shortest paths
        shortest_paths = {}
        for vertex in range(self.V):
            if distance[vertex] != float("inf"):
                shortest_paths[vertex] = distance[vertex]

        return shortest_paths
