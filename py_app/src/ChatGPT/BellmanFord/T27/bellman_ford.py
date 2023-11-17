class BellmanFord:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = []
    
    def add_edge(self, source, destination, weight):
        self.graph.append((source, destination, weight))
    
    def bellman_ford(self, source):
        # Initialize distance to all vertices as infinity and the source vertex as 0
        distance = {vertex: float('inf') for vertex in range(self.vertices)}
        distance[source] = 0

        # Relax all edges V-1 times
        for _ in range(self.vertices - 1):
            for u, v, w in self.graph:
                if distance[u] != float('inf') and distance[u] + w < distance[v]:
                    distance[v] = distance[u] + w

        # Check for negative cycles
        for u, v, w in self.graph:
            if distance[u] != float('inf') and distance[u] + w < distance[v]:
                return None  # Negative cycle detected

        # Create a dictionary with shortest distances to other nodes
        shortest_paths = {vertex: dist for vertex, dist in distance.items() if dist != float('inf')}

        return shortest_paths
