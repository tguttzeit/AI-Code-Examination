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
        # Initialize distances to all nodes as infinity and the source node as 0.
        distances = {vertex: float('infinity') for vertex in range(1, self.vertices + 1)}
        distances[source] = 0
        
        # Priority queue to store nodes with their current distance.
        priority_queue = [(0, source)]
        
        while priority_queue:
            # Get the node with the smallest current distance.
            current_distance, current_vertex = heapq.heappop(priority_queue)
            
            # Check if the current distance is greater than the recorded distance.
            if current_distance > distances[current_vertex]:
                continue
            
            # Explore neighboring nodes.
            if current_vertex in self.graph:
                for neighbor, weight in self.graph[current_vertex]:
                    distance = current_distance + weight
                    # If this path is shorter than the previously recorded distance, update it.
                    if distance < distances[neighbor]:
                        distances[neighbor] = distance
                        heapq.heappush(priority_queue, (distance, neighbor))
        
        # Create a dictionary of shortest paths.
        shortest_paths = {}
        for vertex, distance in distances.items():
            if distance != float('infinity'):
                shortest_paths[vertex] = distance
        
        return shortest_paths
