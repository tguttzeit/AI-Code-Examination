class BellmanFord:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = []

    def add_edge(self, source, destination, weight):
        self.graph.append((source, destination, weight))

    def bellman_ford(self, source):
        # Initialize distance to all vertices as infinity and the source vertex as 0
        distance = {vertex: float('infinity') for vertex in range(self.vertices)}
        distance[source] = 0

        # Relax edges |V| - 1 times, where |V| is the number of vertices
        for _ in range(self.vertices - 1):
            for source_vertex, destination_vertex, edge_weight in self.graph:
                if distance[source_vertex] + edge_weight < distance[destination_vertex]:
                    distance[destination_vertex] = distance[source_vertex] + edge_weight

        # Check for negative cycles
        for source_vertex, destination_vertex, edge_weight in self.graph:
            if distance[source_vertex] + edge_weight < distance[destination_vertex]:
                return None  # Negative cycle detected

        # Create a dictionary with shortest distances
        shortest_distances = {vertex: dist for vertex, dist in distance.items() if dist != float('infinity')}

        return shortest_distances