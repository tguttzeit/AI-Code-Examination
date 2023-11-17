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
        distances = {v: float('infinity') for v in range(1, self.vertices + 1)}
        distances[source] = 0

        # Create a priority queue to keep track of vertices to visit
        priority_queue = [(0, source)]

        # Initialize the result dictionary for shortest paths
        shortest_paths = {}

        while priority_queue:
            # Get the vertex with the smallest distance
            current_distance, current_vertex = heapq.heappop(priority_queue)

            # If we've already processed this vertex, skip it
            if current_vertex in shortest_paths:
                continue

            # Update the shortest path for the current vertex
            shortest_paths[current_vertex] = current_distance

            # Explore its neighbors
            if current_vertex in self.graph:
                for neighbor, weight in self.graph[current_vertex]:
                    distance = current_distance + weight

                    # If the new distance is shorter, update it
                    if distance < distances[neighbor]:
                        distances[neighbor] = distance
                        heapq.heappush(priority_queue, (distance, neighbor))

        # Remove unreachable nodes from the result
        shortest_paths = {k: v for k, v in shortest_paths.items() if v != float('infinity')}
        return shortest_paths
