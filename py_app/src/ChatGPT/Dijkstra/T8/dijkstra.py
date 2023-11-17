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
        distances = {vertex: float('infinity') for vertex in range(1, self.vertices + 1)}
        distances[source] = 0
        
        # Create a priority queue (min-heap) to store vertices and their distances
        priority_queue = [(0, source)]
        
        # Initialize the result dictionary
        shortest_paths = {}
        
        while priority_queue:
            current_distance, current_vertex = heapq.heappop(priority_queue)
            
            # If the current distance is greater than the recorded distance, skip
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
        
        # Remove the source vertex from the result
        del shortest_paths[source]
        
        # Filter out unreachable vertices
        shortest_paths = {k: v for k, v in shortest_paths.items() if v != float('infinity')}
        
        return shortest_paths
