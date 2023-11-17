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
        # Initialize distances to all nodes as infinity and the source as 0.
        distances = {node: float('inf') for node in range(self.vertices)}
        distances[source] = 0
        
        # Priority queue to keep track of nodes to visit next.
        priority_queue = [(0, source)]
        
        while priority_queue:
            current_distance, current_node = heapq.heappop(priority_queue)
            
            # If the current distance is greater than the stored distance, skip this node.
            if current_distance > distances[current_node]:
                continue
            
            # Explore neighbors of the current node.
            if current_node in self.graph:
                for neighbor, weight in self.graph[current_node]:
                    distance = current_distance + weight
                    # If a shorter path is found, update the distance and add to the queue.
                    if distance < distances[neighbor]:
                        distances[neighbor] = distance
                        heapq.heappush(priority_queue, (distance, neighbor))
        
        # Create a dictionary to store the shortest paths from the source.
        shortest_paths = {}
        for node, distance in distances.items():
            if distance != float('inf'):
                shortest_paths[node] = distance
        
        return shortest_paths