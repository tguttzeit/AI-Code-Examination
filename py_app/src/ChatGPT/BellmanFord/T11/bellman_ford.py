class BellmanFord:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = []

    def add_edge(self, source, destination, weight):
        self.graph.append((source, destination, weight))

    def bellman_ford(self, source):
        # Step 1: Initialize distances and predecessors
        distances = {vertex: float('inf') for vertex in range(self.vertices)}
        predecessors = {vertex: None for vertex in range(self.vertices)}
        distances[source] = 0

        # Step 2: Relax edges |V| - 1 times
        for _ in range(self.vertices - 1):
            for source_vertex, dest_vertex, weight in self.graph:
                if distances[source_vertex] != float('inf') and distances[source_vertex] + weight < distances[dest_vertex]:
                    distances[dest_vertex] = distances[source_vertex] + weight
                    predecessors[dest_vertex] = source_vertex

        # Step 3: Check for negative cycles
        for source_vertex, dest_vertex, weight in self.graph:
            if distances[source_vertex] != float('inf') and distances[source_vertex] + weight < distances[dest_vertex]:
                # Negative cycle found
                return None

        # Create the shortest path dictionary
        shortest_paths = {}
        for vertex in range(self.vertices):
            if distances[vertex] != float('inf'):
                shortest_paths[vertex] = {
                    "distance": distances[vertex],
                    "path": self.construct_path(predecessors, source, vertex)
                }

        return shortest_paths

    def construct_path(self, predecessors, source, vertex):
        path = []
        while vertex is not None:
            path.insert(0, vertex)
            vertex = predecessors[vertex]
        return path if path[0] == source else []
