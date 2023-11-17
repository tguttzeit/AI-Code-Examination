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
        # Initialize distances dictionary with infinite distance for all vertices except the source
        distances = {vertex: float('inf') for vertex in range(self.vertices)}
        distances[source] = 0
        
        # Initialize priority queue for Dijkstra's algorithm
        priority_queue = [(0, source)]
        
        # Dictionary to store the shortest paths
        shortest_paths = {}
        
        while priority_queue:
            # Get the vertex with the smallest distance
            current_distance, current_vertex = heapq.heappop(priority_queue)
            
            # Skip if we have already processed this vertex
            if current_distance > distances[current_vertex]:
                continue
            
            # Explore neighbors of the current vertex
            if current_vertex in self.graph:
                for neighbor, weight in self.graph[current_vertex]:
                    distance = current_distance + weight
                    # If this path is shorter than the current known path to the neighbor
                    if distance < distances[neighbor]:
                        distances[neighbor] = distance
                        heapq.heappush(priority_queue, (distance, neighbor))
                        # Update the shortest path to the neighbor
                        shortest_paths[neighbor] = current_vertex
        
        # Generate the shortest path dictionary
        result = {}
        for vertex in shortest_paths:
            path = [vertex]
            while vertex != source:
                vertex = shortest_paths[vertex]
                path.insert(0, vertex)
            result[path[-1]] = path
        return result
