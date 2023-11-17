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
        # Initialize distances to all vertices as infinity and the source vertex as 0.
        distances = {vertex: float('infinity') for vertex in range(1, self.vertices + 1)}
        distances[source] = 0
        
        # Create a priority queue to hold vertices to be explored.
        priority_queue = [(0, source)]
        
        # Initialize the result dictionary.
        shortest_paths = {}
        
        while priority_queue:
            current_distance, current_vertex = heapq.heappop(priority_queue)
            
            # Skip if we've already processed this vertex.
            if current_distance > distances[current_vertex]:
                continue
            
            # Store the current vertex in the result dictionary.
            shortest_paths[current_vertex] = current_distance
            
            # Explore neighbors of the current vertex.
            if current_vertex in self.graph:
                for neighbor, weight in self.graph[current_vertex]:
                    distance = current_distance + weight
                    
                    # If the new distance is shorter, update it and add the neighbor to the priority queue.
                    if distance < distances[neighbor]:
                        distances[neighbor] = distance
                        heapq.heappush(priority_queue, (distance, neighbor))
        
        # Remove the source vertex from the result dictionary.
        shortest_paths.pop(source)
        
        # Filter out nodes that are not reachable from the source.
        shortest_paths = {vertex: distance for vertex, distance in shortest_paths.items() if distance != float('infinity')}
        
        return shortest_paths
