class BellmanFord:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = []
    
    def add_edge(self, source, destination, weight):
        self.graph.append((source, destination, weight))
    
    def bellman_ford(self, source):
        # Step 1: Initialize distances from the source vertex to all other vertices
        distances = {vertex: float('infinity') for vertex in range(self.vertices)}
        distances[source] = 0
        
        # Step 2: Relax all edges (V-1) times
        for _ in range(self.vertices - 1):
            for source_vertex, dest_vertex, edge_weight in self.graph:
                if distances[source_vertex] + edge_weight < distances[dest_vertex]:
                    distances[dest_vertex] = distances[source_vertex] + edge_weight
        
        # Step 3: Check for negative weight cycles
        for source_vertex, dest_vertex, edge_weight in self.graph:
            if distances[source_vertex] + edge_weight < distances[dest_vertex]:
                # There is a negative weight cycle, return None
                return None
        
        # Remove vertices with no path and return the shortest distances
        shortest_distances = {k: v for k, v in distances.items() if v != float('infinity')}
        return shortest_distances
