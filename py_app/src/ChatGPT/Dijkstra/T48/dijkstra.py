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
        # Initialize distances dictionary with infinity for all vertices except the source
        distances = {vertex: float('inf') for vertex in range(1, self.vertices + 1)}
        distances[source] = 0
        
        # Priority queue to keep track of vertices with their current distance
        priority_queue = [(0, source)]
        
        # Dictionary to store the shortest paths
        shortest_paths = {}
        
        while priority_queue:
            current_distance, current_vertex = heapq.heappop(priority_queue)
            
            # If current_distance is greater than the previously recorded distance, skip this iteration
            if current_distance > distances[current_vertex]:
                continue
            
            shortest_paths[current_vertex] = current_distance
            
            if current_vertex in self.graph:
                for neighbor, weight in self.graph[current_vertex]:
                    distance = current_distance + weight
                    # If this path is shorter than the previously recorded distance, update it
                    if distance < distances[neighbor]:
                        distances[neighbor] = distance
                        heapq.heappush(priority_queue, (distance, neighbor))
        
        # Remove the source node from the result
        del shortest_paths[source]
        
        # Remove nodes with infinite distance (no path exists)
        shortest_paths = {vertex: distance for vertex, distance in shortest_paths.items() if distance != float('inf')}
        
        return shortest_paths
