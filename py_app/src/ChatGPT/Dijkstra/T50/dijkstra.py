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
        distances = {vertex: float('inf') for vertex in range(self.vertices)}
        distances[source] = 0
        
        # Initialize a priority queue (min heap) to keep track of vertices to visit.
        priority_queue = [(0, source)]
        
        # Initialize the result dictionary.
        shortest_paths = {}
        
        while priority_queue:
            current_distance, current_vertex = heapq.heappop(priority_queue)
            
            # If we've already processed this vertex, continue.
            if current_distance > distances[current_vertex]:
                continue
            
            # Update the shortest path to all neighbors of the current vertex.
            if current_vertex in self.graph:
                for neighbor, weight in self.graph[current_vertex]:
                    distance = current_distance + weight
                    # If a shorter path to the neighbor is found, update the distance.
                    if distance < distances[neighbor]:
                        distances[neighbor] = distance
                        heapq.heappush(priority_queue, (distance, neighbor))
                        # Update the shortest path in the result dictionary.
                        shortest_paths[neighbor] = current_vertex
        
        # Filter out nodes with no paths.
        shortest_paths = {k: v for k, v in shortest_paths.items() if k != source}
        
        return shortest_paths
