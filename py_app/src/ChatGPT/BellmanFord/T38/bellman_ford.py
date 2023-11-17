class BellmanFord:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = []

    def add_edge(self, source, destination, weight):
        self.graph.append((source, destination, weight))

    def bellman_ford(self, source):
        # Initialize distance to all vertices as infinite and source as 0
        distance = {v: float('infinity') for v in range(self.vertices)}
        distance[source] = 0

        # Relax all edges |V| - 1 times
        for _ in range(self.vertices - 1):
            for source, destination, weight in self.graph:
                if distance[source] + weight < distance[destination]:
                    distance[destination] = distance[source] + weight

        # Check for negative cycles
        for source, destination, weight in self.graph:
            if distance[source] + weight < distance[destination]:
                # Negative cycle found
                return None

        # Create a dictionary to store the shortest paths
        shortest_paths = {v: distance[v] for v in range(self.vertices) if distance[v] != float('infinity')}
        
        return shortest_paths
