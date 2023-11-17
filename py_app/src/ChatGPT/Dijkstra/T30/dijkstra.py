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
        shortest_paths = {source: 0}
        priority_queue = [(0, source)]

        while priority_queue:
            current_distance, current_vertex = heapq.heappop(priority_queue)

            if current_distance > shortest_paths[current_vertex]:
                continue

            if current_vertex in self.graph:
                for neighbor, weight in self.graph[current_vertex]:
                    distance = current_distance + weight
                    if distance < shortest_paths.get(neighbor, float('inf')):
                        shortest_paths[neighbor] = distance
                        heapq.heappush(priority_queue, (distance, neighbor))

        # Remove nodes with no path
        shortest_paths = {node: distance for node, distance in shortest_paths.items() if distance != float('inf')}
        return shortest_paths
