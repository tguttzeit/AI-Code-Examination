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
        # Initialize distances with infinity for all nodes except the source
        distances = {node: float('inf') for node in range(1, self.vertices + 1)}
        distances[source] = 0
        
        # Priority queue to store (distance, node) pairs
        priority_queue = [(0, source)]
        
        while priority_queue:
            current_distance, current_node = heapq.heappop(priority_queue)
            
            # If the current distance is greater than the stored distance, skip
            if current_distance > distances[current_node]:
                continue
            
            # Explore neighbors of the current node
            if current_node in self.graph:
                for neighbor, weight in self.graph[current_node]:
                    distance = current_distance + weight
                    
                    # If the new distance is shorter, update the distance
                    if distance < distances[neighbor]:
                        distances[neighbor] = distance
                        heapq.heappush(priority_queue, (distance, neighbor))
        
        # Create a dictionary to store the shortest paths
        shortest_paths = {}
        for node, distance in distances.items():
            if distance != float('inf') and node != source:
                shortest_paths[node] = distance
        
        return shortest_paths
