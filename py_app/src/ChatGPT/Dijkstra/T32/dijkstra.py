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
        distances = {vertex: float('infinity') for vertex in range(1, self.vertices + 1)}
        distances[source] = 0
        
        # Priority queue to keep track of the vertices to visit
        priority_queue = [(0, source)]
        
        # Dictionary to store the shortest path to each vertex
        shortest_paths = {}
        
        while priority_queue:
            current_distance, current_vertex = heapq.heappop(priority_queue)
            
            # If current_distance is greater than the known distance, skip
            if current_distance > distances[current_vertex]:
                continue
            
            for neighbor, weight in self.graph.get(current_vertex, []):
                distance = current_distance + weight
                
                # If a shorter path is found, update the distance and add to the priority queue
                if distance < distances[neighbor]:
                    distances[neighbor] = distance
                    heapq.heappush(priority_queue, (distance, neighbor))
                    shortest_paths[neighbor] = current_vertex
        
        # Create the output dictionary containing shortest paths
        shortest_paths_result = {}
        for vertex, parent in shortest_paths.items():
            path = []
            while vertex != source:
                path.append(vertex)
                vertex = parent
            path.append(source)
            path.reverse()
            shortest_paths_result[vertex] = path
        
        return shortest_paths_result
