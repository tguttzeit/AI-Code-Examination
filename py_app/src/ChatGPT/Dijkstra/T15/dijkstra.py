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
        # Initialize distances and visited dictionary
        distances = {vertex: float('inf') for vertex in range(1, self.vertices + 1)}
        distances[source] = 0
        visited = set()
        
        # Priority queue to keep track of vertices with the shortest distance
        priority_queue = [(0, source)]
        
        while priority_queue:
            current_distance, current_vertex = heapq.heappop(priority_queue)
            
            # If we've already processed this vertex, skip it
            if current_vertex in visited:
                continue
            
            visited.add(current_vertex)
            
            # Check neighbors of the current vertex
            if current_vertex in self.graph:
                for neighbor, weight in self.graph[current_vertex]:
                    distance = current_distance + weight
                    
                    # If this path is shorter than the currently known shortest path, update it
                    if distance < distances[neighbor]:
                        distances[neighbor] = distance
                        heapq.heappush(priority_queue, (distance, neighbor))
        
        # Remove nodes with infinite distance (no path exists)
        shortest_paths = {vertex: distance for vertex, distance in distances.items() if distance != float('inf')}
        
        return shortest_paths
