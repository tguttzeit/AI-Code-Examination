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
        min_heap = [(0, source)]
        
        while min_heap:
            (current_distance, current_vertex) = heapq.heappop(min_heap)
            
            if current_vertex in shortest_paths:
                continue
            
            shortest_paths[current_vertex] = current_distance
            
            if current_vertex in self.graph:
                for (neighbor, weight) in self.graph[current_vertex]:
                    if neighbor not in shortest_paths:
                        heapq.heappush(min_heap, (current_distance + weight, neighbor))
        
        shortest_paths.pop(source)  # Remove source from the result
        return shortest_paths
