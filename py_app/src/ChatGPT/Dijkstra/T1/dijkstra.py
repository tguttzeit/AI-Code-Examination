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
        distances = {vertex: float('inf') for vertex in range(self.vertices)}
        distances[source] = 0
        
        # Priority queue to keep track of vertices and their minimum distances
        min_heap = [(0, source)]
        
        while min_heap:
            # Get the vertex with the minimum distance from the priority queue
            current_distance, current_vertex = heapq.heappop(min_heap)
            
            # Skip if the current distance is greater than the previously recorded distance
            if current_distance > distances[current_vertex]:
                continue
            
            # Explore neighbors of the current vertex
            if current_vertex in self.graph:
                for neighbor, weight in self.graph[current_vertex]:
                    distance = current_distance + weight
                    # If a shorter path is found, update the distance
                    if distance < distances[neighbor]:
                        distances[neighbor] = distance
                        heapq.heappush(min_heap, (distance, neighbor))
        
        # Create the result dictionary, skipping nodes with infinite distances
        shortest_paths = {}
        for vertex, distance in distances.items():
            if distance != float('inf'):
                shortest_paths[vertex] = distance
        
        return shortest_paths
