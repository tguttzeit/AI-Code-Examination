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
        # Initialize distances with infinity for all vertices except the source
        distances = {vertex: float('inf') for vertex in range(1, self.vertices + 1)}
        distances[source] = 0

        # Priority queue to keep track of vertices to visit
        queue = [(0, source)]

        # Dictionary to store the shortest path to each node
        shortest_paths = {}

        while queue:
            # Get the vertex with the smallest distance from the queue
            current_distance, current_vertex = heapq.heappop(queue)

            # Skip if we've already processed this node
            if current_distance > distances[current_vertex]:
                continue

            # Store the shortest distance to the current vertex
            shortest_paths[current_vertex] = current_distance

            # Update distances to adjacent vertices
            if current_vertex in self.graph:
                for neighbor, weight in self.graph[current_vertex]:
                    distance = current_distance + weight

                    # If this path is shorter, update the distance
                    if distance < distances[neighbor]:
                        distances[neighbor] = distance
                        heapq.heappush(queue, (distance, neighbor))

        # Remove the source node from the result
        del shortest_paths[source]

        # Remove nodes with infinite distances (unreachable)
        shortest_paths = {k: v for k, v in shortest_paths.items() if v != float('inf')}

        return shortest_paths
