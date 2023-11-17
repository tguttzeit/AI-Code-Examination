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
        
        # Priority queue to keep track of vertices to explore
        priority_queue = [(0, source)]
        
        # Dictionary to store the shortest paths
        shortest_paths = {}
        
        while priority_queue:
            current_distance, current_vertex = heapq.heappop(priority_queue)
            
            # Skip if we've already found a shorter path
            if current_distance > distances[current_vertex]:
                continue
            
            # Store the current_vertex's shortest path in the result dictionary
            shortest_paths[current_vertex] = current_distance
            
            if current_vertex in self.graph:
                for neighbor, weight in self.graph[current_vertex]:
                    distance = current_distance + weight
                    
                    # If this path is shorter, update the distance and push to the priority queue
                    if distance < distances[neighbor]:
                        distances[neighbor] = distance
                        heapq.heappush(priority_queue, (distance, neighbor))
        
        # Remove the source node from the result dictionary
        del shortest_paths[source]
        
        # Remove unreachable nodes from the result dictionary
        shortest_paths = {k: v for k, v in shortest_paths.items() if v != float('inf')}
        
        return shortest_paths
