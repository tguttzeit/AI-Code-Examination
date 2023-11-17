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
        # Initialize distances to all vertices as infinite and the source as 0
        distances = {vertex: float('infinity') for vertex in range(1, self.vertices + 1)}
        distances[source] = 0
        
        # Priority queue to store vertices with their current distances
        priority_queue = [(0, source)]
        
        # Dictionary to store the previous vertex in the shortest path
        previous = {}
        
        while priority_queue:
            current_distance, current_vertex = heapq.heappop(priority_queue)
            
            # If we have already processed this vertex, skip it
            if current_distance > distances[current_vertex]:
                continue
            
            for neighbor, weight in self.graph.get(current_vertex, []):
                distance = current_distance + weight
                
                # If we found a shorter path to the neighbor, update it
                if distance < distances[neighbor]:
                    distances[neighbor] = distance
                    previous[neighbor] = current_vertex
                    heapq.heappush(priority_queue, (distance, neighbor))
        
        # Create a dictionary of shortest paths
        shortest_paths = {}
        for vertex in range(1, self.vertices + 1):
            if vertex != source and vertex in previous:
                path = []
                current = vertex
                while current is not None:
                    path.insert(0, current)
                    current = previous.get(current)
                shortest_paths[vertex] = {
                    "path": path,
                    "distance": distances[vertex]
                }
        
        return shortest_paths
