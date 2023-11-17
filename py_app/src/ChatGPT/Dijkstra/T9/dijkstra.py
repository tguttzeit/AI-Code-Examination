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
        # Initialize distances and previous nodes
        distances = {v: float('inf') for v in range(1, self.vertices + 1)}
        distances[source] = 0
        previous = {v: None for v in range(1, self.vertices + 1)}

        # Priority queue to keep track of the vertices to visit
        priority_queue = [(0, source)]

        while priority_queue:
            current_distance, current_vertex = heapq.heappop(priority_queue)

            if current_distance > distances[current_vertex]:
                continue

            if current_vertex in self.graph:
                for neighbor, weight in self.graph[current_vertex]:
                    distance = current_distance + weight

                    if distance < distances[neighbor]:
                        distances[neighbor] = distance
                        previous[neighbor] = current_vertex
                        heapq.heappush(priority_queue, (distance, neighbor))

        # Create a dictionary to store the shortest paths
        shortest_paths = {}
        for vertex in range(1, self.vertices + 1):
            if distances[vertex] != float('inf'):
                shortest_paths[vertex] = {
                    'distance': distances[vertex],
                    'path': self.construct_path(previous, source, vertex)
                }

        return shortest_paths

    def construct_path(self, previous, source, destination):
        path = []
        while destination is not None:
            path.insert(0, destination)
            destination = previous[destination]
        return path if path[0] == source else []
