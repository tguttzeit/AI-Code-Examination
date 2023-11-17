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
        # Initialize distances and predecessors
        distances = {vertex: float('infinity') for vertex in range(1, self.vertices + 1)}
        predecessors = {vertex: None for vertex in range(1, self.vertices + 1)}

        # The distance to the source vertex is 0
        distances[source] = 0

        # Priority queue to select the vertex with the smallest distance
        priority_queue = [(0, source)]

        while priority_queue:
            current_distance, current_vertex = heapq.heappop(priority_queue)

            # Ignore if we've already processed this vertex
            if current_distance > distances[current_vertex]:
                continue

            for neighbor, weight in self.graph.get(current_vertex, []):
                distance = current_distance + weight

                # If this path is shorter than the stored distance, update it
                if distance < distances[neighbor]:
                    distances[neighbor] = distance
                    predecessors[neighbor] = current_vertex
                    heapq.heappush(priority_queue, (distance, neighbor))

        # Create a dictionary of shortest paths
        shortest_paths = {}
        for vertex in range(1, self.vertices + 1):
            if distances[vertex] != float('infinity'):
                shortest_paths[vertex] = {'distance': distances[vertex], 'path': self._get_path(predecessors, source, vertex)}

        return shortest_paths

    def _get_path(self, predecessors, source, target):
        path = []
        while target is not None:
            path.insert(0, target)
            target = predecessors[target]
        return path
