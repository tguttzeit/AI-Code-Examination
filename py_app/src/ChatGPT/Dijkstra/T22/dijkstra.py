import heapq

class Dijkstra:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = [[] for _ in range(vertices)]

    def add_edge(self, source, destination, weight):
        self.graph[source].append((destination, weight))
        self.graph[destination].append((source, weight))

    def find_shortest_paths(self, source):
        # Initialize distances to all vertices as infinity and the source as 0.
        distances = [float('inf')] * self.vertices
        distances[source] = 0
        
        # Create a priority queue to keep track of the next vertices to visit.
        priority_queue = [(0, source)]
        
        # Dictionary to store the shortest paths.
        shortest_paths = {}
        
        while priority_queue:
            # Get the vertex with the smallest distance from the priority queue.
            current_distance, current_vertex = heapq.heappop(priority_queue)
            
            # If the current distance is greater than the known distance, skip it.
            if current_distance > distances[current_vertex]:
                continue
            
            # Update the shortest path to the current vertex.
            shortest_paths[current_vertex] = current_distance
            
            # Explore neighbors of the current vertex.
            for neighbor, weight in self.graph[current_vertex]:
                distance = current_distance + weight
                
                # If the new distance is shorter than the known distance, update it and add to the queue.
                if distance < distances[neighbor]:
                    distances[neighbor] = distance
                    heapq.heappush(priority_queue, (distance, neighbor))
        
        # Create a dictionary to store the shortest paths excluding the source node.
        result = {}
        for vertex, distance in enumerate(distances):
            if vertex != source and distance != float('inf'):
                result[vertex] = distance
        
        return result
