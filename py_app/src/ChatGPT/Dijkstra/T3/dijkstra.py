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
        distances = {node: float('inf') for node in range(self.vertices)}
        distances[source] = 0
        priority_queue = [(0, source)]
        shortest_paths = {}
        
        while priority_queue:
            current_distance, current_node = heapq.heappop(priority_queue)
            
            if current_distance > distances[current_node]:
                continue
            
            for neighbor, weight in self.graph.get(current_node, []):
                distance = current_distance + weight
                
                if distance < distances[neighbor]:
                    distances[neighbor] = distance
                    heapq.heappush(priority_queue, (distance, neighbor))
                    shortest_paths[neighbor] = current_node
        
        result = {}
        for node, distance in distances.items():
            if distance != float('inf'):
                path = self._construct_path(shortest_paths, source, node)
                result[node] = (distance, path)
        
        return result
    
    def _construct_path(self, shortest_paths, source, destination):
        path = []
        while destination != source:
            path.insert(0, destination)
            destination = shortest_paths[destination]
        path.insert(0, source)
        return path
