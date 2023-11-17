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
        # Initialize distance to all vertices as infinity and the source as 0
        distances = {v: float('inf') for v in range(self.vertices)}
        distances[source] = 0

        # Create a priority queue (min heap) to track the vertices to visit
        priority_queue = [(0, source)]

        # Initialize the result dictionary to store the shortest paths
        shortest_paths = {}

        while priority_queue:
            # Get the vertex with the smallest distance
            dist, current_vertex = heapq.heappop(priority_queue)

            # Skip if the vertex has been processed already
            if current_vertex in shortest_paths:
                continue

            # Update the shortest path to the current vertex
            shortest_paths[current_vertex] = dist

            # Explore neighboring vertices
            if current_vertex in self.graph:
                for neighbor, weight in self.graph[current_vertex]:
                    if neighbor not in shortest_paths:
                        new_distance = dist + weight
                        if new_distance < distances[neighbor]:
                            distances[neighbor] = new_distance
                            heapq.heappush(priority_queue, (new_distance, neighbor))

        # Remove unreachable vertices from the result
        shortest_paths = {v: d for v, d in shortest_paths.items() if d != float('inf')}
        
        return shortest_paths
