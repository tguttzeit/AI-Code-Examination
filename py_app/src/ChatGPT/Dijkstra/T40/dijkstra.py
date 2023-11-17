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
        # Initialize distances dictionary with infinity for all vertices except the source
        distances = {vertex: float('infinity') for vertex in range(self.vertices)}
        distances[source] = 0

        # Create a priority queue (min heap) for Dijkstra's algorithm
        priority_queue = [(0, source)]

        # Initialize the result dictionary for storing the shortest paths
        shortest_paths = {}

        while priority_queue:
            current_distance, current_vertex = heapq.heappop(priority_queue)

            # Skip if we've already processed this vertex with a shorter distance
            if current_distance > distances[current_vertex]:
                continue

            # Update the shortest paths to neighbors of the current vertex
            if current_vertex in self.graph:
                for neighbor, weight in self.graph[current_vertex]:
                    distance = current_distance + weight

                    # If this path is shorter than the previously recorded distance, update it
                    if distance < distances[neighbor]:
                        distances[neighbor] = distance
                        heapq.heappush(priority_queue, (distance, neighbor))

                        # Record the shortest path to the neighbor
                        shortest_paths[neighbor] = current_vertex

        # Create a dictionary of shortest paths from the source to each reachable vertex
        result = {}
        for vertex in range(self.vertices):
            if vertex != source:
                if vertex in shortest_paths:
                    path = []
                    current = vertex
                    while current is not None:
                        path.insert(0, current)
                        current = shortest_paths.get(current)
                    result[vertex] = path

        return result
