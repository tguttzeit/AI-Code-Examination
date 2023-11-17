class BellmanFord:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = []

    def add_edge(self, source, destination, weight):
        self.graph.append((source, destination, weight))

    def bellman_ford(self, source):
        # Initialize distance to all nodes as infinity, except the source
        distance = {v: float('infinity') for v in range(self.vertices)}
        distance[source] = 0

        # Relaxation step for each edge (V-1) times
        for _ in range(self.vertices - 1):
            for u, v, w in self.graph:
                if distance[u] != float('infinity') and distance[u] + w < distance[v]:
                    distance[v] = distance[u] + w

        # Check for negative cycles
        for u, v, w in self.graph:
            if distance[u] != float('infinity') and distance[u] + w < distance[v]:
                return None  # Negative cycle found

        # Create a dictionary with shortest paths to each node
        shortest_paths = {}
        for v in range(self.vertices):
            if distance[v] != float('infinity'):
                shortest_paths[v] = distance[v]

        return shortest_paths
