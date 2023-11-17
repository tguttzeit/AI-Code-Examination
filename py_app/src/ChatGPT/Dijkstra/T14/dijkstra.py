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
        # Initialize distances and a priority queue
        distances = {v: float('inf') for v in range(1, self.vertices + 1)}
        distances[source] = 0
        priority_queue = [(0, source)]
        
        # Initialize the shortest paths dictionary
        shortest_paths = {}
        
        while priority_queue:
            dist, current = heapq.heappop(priority_queue)
            
            # Skip if we have already processed this node
            if current in shortest_paths:
                continue
            
            shortest_paths[current] = dist
            
            if current in self.graph:
                for neighbor, weight in self.graph[current]:
                    new_dist = dist + weight
                    if new_dist < distances[neighbor]:
                        distances[neighbor] = new_dist
                        heapq.heappush(priority_queue, (new_dist, neighbor))
        
        # Remove unreachable nodes from the output
        shortest_paths = {k: v for k, v in shortest_paths.items() if v != float('inf')}
        
        return shortest_paths

