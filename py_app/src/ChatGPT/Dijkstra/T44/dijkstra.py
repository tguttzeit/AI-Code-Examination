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
        # Initialize distances to all nodes as infinity, except for the source node.
        distances = {vertex: float('inf') for vertex in range(1, self.vertices + 1)}
        distances[source] = 0
        
        # Create a priority queue (min-heap) to keep track of the nodes with the shortest distance.
        priority_queue = [(0, source)]
        
        # Initialize the shortest path dictionary.
        shortest_paths = {}
        
        while priority_queue:
            current_distance, current_vertex = heapq.heappop(priority_queue)
            
            # If the current distance is greater than the stored distance, skip.
            if current_distance > distances[current_vertex]:
                continue
            
            # Explore neighboring nodes and update distances.
            if current_vertex in self.graph:
                for neighbor, weight in self.graph[current_vertex]:
                    distance = current_distance + weight
                    if distance < distances[neighbor]:
                        distances[neighbor] = distance
                        shortest_paths[neighbor] = current_vertex
                        heapq.heappush(priority_queue, (distance, neighbor))
        
        # Create a dictionary of shortest paths from the source to each node.
        result = {}
        for vertex in range(1, self.vertices + 1):
            if vertex != source and vertex in shortest_paths:
                path = []
                while vertex:
                    path.append(vertex)
                    vertex = shortest_paths.get(vertex)
                result[vertex] = list(reversed(path))
                
        return result
