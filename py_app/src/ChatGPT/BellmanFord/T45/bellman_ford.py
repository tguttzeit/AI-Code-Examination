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

        # Relax all edges |V| - 1 times
        for _ in range(self.vertices - 1):
            for source_vertex, destination_vertex, edge_weight in self.graph:
                if distance[source_vertex] != float('inf') and distance[source_vertex] + edge_weight < distance[destination_vertex]:
                    distance[destination_vertex] = distance[source_vertex] + edge_weight

        # Check for negative cycles
        for source_vertex, destination_vertex, edge_weight in self.graph:
            if distance[source_vertex] != float('inf') and distance[source_vertex] + edge_weight < distance[destination_vertex]:
                return None  # Negative cycle found

        # Create a dictionary containing the shortest paths
        shortest_paths = {}
        for vertex, dist in enumerate(distance):
            if dist != float('inf'):
                shortest_paths[vertex] = dist

        return shortest_paths
