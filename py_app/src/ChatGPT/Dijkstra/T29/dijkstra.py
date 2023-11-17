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
        distances = {v: float('inf') for v in range(1, self.vertices + 1)}
        distances[source] = 0
        
        # Priority queue to select the vertex with the shortest distance
        priority_queue = [(0, source)]
        
        # Dictionary to store the shortest paths
        shortest_paths = {}
        
        while priority_queue:
            # Get the vertex with the shortest distance
            current_distance, current_vertex = heapq.heappop(priority_queue)
            
            # Skip if we've already processed this vertex
            if current_distance > distances[current_vertex]:
                continue
            
            # Store the shortest distance and path to the current vertex
            shortest_paths[current_vertex] = (current_distance, self._get_path(source, current_vertex, shortest_paths))
            
            # Update distances to neighbors
            if current_vertex in self.graph:
                for neighbor, weight in self.graph[current_vertex]:
                    distance = current_distance + weight
                    if distance < distances[neighbor]:
                        distances[neighbor] = distance
                        heapq.heappush(priority_queue, (distance, neighbor))
        
        # Remove the source node from the result
        del shortest_paths[source]
        
        # Filter out nodes with no path
        shortest_paths = {k: v for k, v in shortest_paths.items() if v[0] != float('inf')}
        
        return shortest_paths
    
    def _get_path(self, source, target, shortest_paths):
        path = []
        while target != source:
            path.append(target)
            _, target = shortest_paths[target]
        path.append(source)
        return list(reversed(path))
