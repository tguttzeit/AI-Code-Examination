import heapq

class Dijkstra:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = [[] for _ in range(vertices)]

    def add_edge(self, source, destination, weight):
        self.graph[source].append((destination, weight))
        self.graph[destination].append((source, weight))  # Assuming an undirected graph

    def find_shortest_paths(self, source):
        # Initialize distances to all vertices as infinity and source as 0
        distances = [float('inf')] * self.vertices
        distances[source] = 0

        # Initialize a priority queue (min-heap) with (distance, vertex) tuples
        priority_queue = [(0, source)]

        # Initialize the shortest paths dictionary
        shortest_paths = {}

        while priority_queue:
            dist, current_vertex = heapq.heappop(priority_queue)

            # If the distance to the current_vertex is greater than the recorded distance, skip it
            if dist > distances[current_vertex]:
                continue

            shortest_paths[current_vertex] = dist

            for neighbor, weight in self.graph[current_vertex]:
                distance = dist + weight

                # If the newly calculated distance is less than the recorded distance, update it
                if distance < distances[neighbor]:
                    distances[neighbor] = distance
                    heapq.heappush(priority_queue, (distance, neighbor))

        # Create the result dictionary with shortest paths from the source
        result = {vertex: distance for vertex, distance in enumerate(distances) if distance != float('inf')}

        return result
