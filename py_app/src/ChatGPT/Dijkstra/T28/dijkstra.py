import heapq

class Dijkstra:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = {}
    
    def add_edge(self, source, destination, weight):
        if source not in self.graph:
            self.graph[source] = []
        self.graph[source].append((destination, weight))
    
    def find_shortest_paths(self, source):
        # Initialize distances to all vertices as infinity and the source as 0.
        distances = {vertex: float('inf') for vertex in range(self.vertices)}
        distances[source] = 0

        # Priority queue to keep track of the vertices with the shortest distances.
        priority_queue = [(0, source)]

        while priority_queue:
            # Get the vertex with the shortest distance from the priority queue.
            current_distance, current_vertex = heapq.heappop(priority_queue)

            # If the current distance is greater than the previously recorded distance,
            # skip this vertex.
            if current_distance > distances[current_vertex]:
                continue

            # Update the distances to adjacent vertices.
            if current_vertex in self.graph:
                for neighbor, weight in self.graph[current_vertex]:
                    distance = current_distance + weight
                    if distance < distances[neighbor]:
                        distances[neighbor] = distance
                        heapq.heappush(priority_queue, (distance, neighbor))

        # Create a dictionary to store the shortest paths.
        shortest_paths = {}
        for vertex in range(self.vertices):
            if distances[vertex] != float('inf'):
                shortest_paths[vertex] = distances[vertex]

        return shortest_paths
