class BellmanFord:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = []

    def add_edge(self, source, destination, weight):
        self.graph.append((source, destination, weight))

    def bellman_ford(self, source):
        # Initialize distance to all vertices as infinity and the source as 0
        distance = {vertex: float('infinity') for vertex in range(self.vertices)}
        distance[source] = 0

        # Relaxation step to find the shortest path
        for _ in range(self.vertices - 1):
            for source, destination, weight in self.graph:
                if distance[source] != float('infinity') and distance[source] + weight < distance[destination]:
                    distance[destination] = distance[source] + weight

        # Check for negative cycles
        for source, destination, weight in self.graph:
            if distance[source] != float('infinity') and distance[source] + weight < distance[destination]:
                return None  # Negative cycle detected

        # Create a dictionary with the shortest path to each node
        shortest_paths = {}
        for vertex, dist in distance.items():
            if dist != float('infinity'):
                shortest_paths[vertex] = dist

        return shortest_paths
