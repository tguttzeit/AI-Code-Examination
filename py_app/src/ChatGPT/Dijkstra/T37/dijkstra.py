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
        # Initialize distances to all vertices as infinity except for the source
        distances = {v: float('inf') for v in range(1, self.vertices + 1)}
        distances[source] = 0
        
        # Priority queue to store vertices to visit next
        priority_queue = [(0, source)]
        
        # Dictionary to store the shortest path to each vertex
        shortest_paths = {}
        
        while priority_queue:
            current_distance, current_vertex = heapq.heappop(priority_queue)
            
            # If we've already processed this vertex, skip it
            if current_distance > distances[current_vertex]:
                continue
                
            shortest_paths[current_vertex] = current_distance
            
            if current_vertex in self.graph:
                for neighbor, weight in self.graph[current_vertex]:
                    distance = current_distance + weight
                    if distance < distances[neighbor]:
                        distances[neighbor] = distance
                        heapq.heappush(priority_queue, (distance, neighbor))
        
        # Remove source from the shortest_paths dictionary
        del shortest_paths[source]
        
        # Filter out vertices with infinite distance (no path)
        shortest_paths = {k: v for k, v in shortest_paths.items() if v != float('inf')}
        
        return shortest_paths
