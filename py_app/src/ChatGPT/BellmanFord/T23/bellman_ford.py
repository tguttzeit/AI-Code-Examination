class BellmanFord:
    def __init__(self, vertices):
        self.V = vertices
        self.graph = []

    def add_edge(self, source, destination, weight):
        self.graph.append((source, destination, weight))

    def bellman_ford(self, source):
        # Initialize distance array with a maximum value for all vertices except the source
        distance = {vertex: float('inf') for vertex in range(self.V)}
        distance[source] = 0

        # Relax all edges V-1 times
        for _ in range(self.V - 1):
            for source_vertex, dest_vertex, weight in self.graph:
                if distance[source_vertex] != float('inf') and distance[source_vertex] + weight < distance[dest_vertex]:
                    distance[dest_vertex] = distance[source_vertex] + weight

        # Check for negative cycles
        for source_vertex, dest_vertex, weight in self.graph:
            if distance[source_vertex] != float('inf') and distance[source_vertex] + weight < distance[dest_vertex]:
                return None  # Negative cycle detected

        # Create a dictionary with the shortest paths to all reachable vertices
        shortest_paths = {v: distance[v] for v in range(self.V) if distance[v] != float('inf')}

        return shortest_paths
