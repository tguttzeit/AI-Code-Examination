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
        shortest_paths = {}
        priority_queue = [(0, source)]  # (distance, node)
        
        while priority_queue:
            current_distance, current_node = heapq.heappop(priority_queue)
            
            if current_node in shortest_paths:
                continue
            
            shortest_paths[current_node] = current_distance
            
            if current_node in self.graph:
                for neighbor, weight in self.graph[current_node]:
                    if neighbor not in shortest_paths:
                        heapq.heappush(priority_queue, (current_distance + weight, neighbor))
        
        shortest_paths.pop(source)  # Remove the source node from the result
        
        return shortest_paths
