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
        priority_queue = [(0, source)]
        
        while priority_queue:
            dist, current_vertex = heapq.heappop(priority_queue)
            
            if current_vertex in shortest_paths:
                continue
                
            shortest_paths[current_vertex] = dist
            
            if current_vertex in self.graph:
                for neighbor, weight in self.graph[current_vertex]:
                    if neighbor not in shortest_paths:
                        heapq.heappush(priority_queue, (dist + weight, neighbor))
                        
        return shortest_paths
