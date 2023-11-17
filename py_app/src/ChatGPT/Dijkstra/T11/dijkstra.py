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
        # Initialize distances and visited nodes
        distances = {vertex: float('infinity') for vertex in range(1, self.vertices + 1)}
        distances[source] = 0
        visited = set()
        
        # Create a priority queue (min heap) to keep track of the nodes to visit
        priority_queue = [(0, source)]
        
        while priority_queue:
            # Get the node with the smallest distance from the priority queue
            current_distance, current_vertex = heapq.heappop(priority_queue)
            
            # Skip this node if we've already processed it
            if current_vertex in visited:
                continue
            
            # Mark the current node as visited
            visited.add(current_vertex)
            
            # Update distances to neighboring nodes
            if current_vertex in self.graph:
                for neighbor, weight in self.graph[current_vertex]:
                    distance = current_distance + weight
                    if distance < distances[neighbor]:
                        distances[neighbor] = distance
                        heapq.heappush(priority_queue, (distance, neighbor))
        
        # Create a dictionary of shortest paths
        shortest_paths = {vertex: distance for vertex, distance in distances.items() if distance != float('infinity')}
        
        return shortest_paths
