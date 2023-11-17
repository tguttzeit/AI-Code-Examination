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
        distances = {vertex: float('infinity') for vertex in range(1, self.vertices + 1)}
        distances[source] = 0
        
        # Initialize a priority queue (min-heap) with the source vertex.
        priority_queue = [(0, source)]
        
        while priority_queue:
            # Get the vertex with the smallest distance from the priority queue.
            current_distance, current_vertex = heapq.heappop(priority_queue)
            
            # If the current distance is greater than the stored distance, skip it.
            if current_distance > distances[current_vertex]:
                continue
            
            # Explore the neighbors of the current vertex.
            if current_vertex in self.graph:
                for neighbor, weight in self.graph[current_vertex]:
                    distance = current_distance + weight
                    
                    # If this new distance is shorter than the stored distance, update it.
                    if distance < distances[neighbor]:
                        distances[neighbor] = distance
                        heapq.heappush(priority_queue, (distance, neighbor))
        
        # Remove vertices with infinite distances (no path).
        shortest_paths = {k: v for k, v in distances.items() if v != float('infinity')}
        
        return shortest_paths
