class BellmanFord:
    def __init__(self, vertices):
        self.V = vertices
        self.graph = []

    def add_edge(self, source, destination, weight):
        self.graph.append((source, destination, weight))

    def bellman_ford(self, source):
        # Initialize distance to all vertices as infinite and distance to source as 0
        distance = {v: float('inf') for v in range(self.V)}
        distance[source] = 0

        # Relax edges |V| - 1 times
        for _ in range(self.V - 1):
            for source, destination, weight in self.graph:
                if distance[source] != float('inf') and distance[source] + weight < distance[destination]:
                    distance[destination] = distance[source] + weight

        # Check for negative cycles
        for source, destination, weight in self.graph:
            if distance[source] != float('inf') and distance[source] + weight < distance[destination]:
                return None  # Negative cycle exists

        # Create a dictionary of shortest distances
        shortest_distances = {v: distance[v] for v in range(self.V) if distance[v] != float('inf')}

        return shortest_distances
