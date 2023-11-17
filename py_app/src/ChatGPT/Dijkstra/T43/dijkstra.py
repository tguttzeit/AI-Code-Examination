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
        # Create a dictionary to store the shortest distances to each node.
        distances = {vertex: float('inf') for vertex in range(1, self.vertices + 1)}
        distances[source] = 0
        
        # Create a priority queue to hold vertices and their distances.
        priority_queue = [(0, source)]
        
        while priority_queue:
            current_distance, current_vertex = heapq.heappop(priority_queue)
            
            if current_distance > distances[current_vertex]:
                continue
                
            if current_vertex in self.graph:
                for neighbor, weight in self.graph[current_vertex]:
                    distance = current_distance + weight
                    if distance < distances[neighbor]:
                        distances[neighbor] = distance
                        heapq.heappush(priority_queue, (distance, neighbor))
                        
        # Create the shortest paths dictionary.
        shortest_paths = {}
        for vertex in range(1, self.vertices + 1):
            if distances[vertex] != float('inf') and vertex != source:
                shortest_paths[vertex] = distances[vertex]
        
        return shortest_paths
