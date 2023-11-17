import heapq

class Dijkstra:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = [[] for _ in range(vertices)]

    def add_edge(self, source, destination, weight):
        self.graph[source].append((destination, weight))
        self.graph[destination].append((source, weight))  # If the graph is undirected

    def find_shortest_paths(self, source):
        # Initialize distances to all vertices as infinity and the source vertex as 0
        distances = [float('inf')] * self.vertices
        distances[source] = 0

        # Priority queue to store vertices to visit
        priority_queue = [(0, source)]

        # Dictionary to store the shortest paths
        shortest_paths = {}

        while priority_queue:
            current_distance, current_vertex = heapq.heappop(priority_queue)

            # If we've already processed this vertex, skip it
            if current_distance > distances[current_vertex]:
                continue

            # Add the current vertex to the shortest_paths dictionary
            shortest_paths[current_vertex] = current_distance

            # Explore neighbors of the current vertex
            for neighbor, weight in self.graph[current_vertex]:
                distance = current_distance + weight

                # If this path is shorter than the previously known distance, update it
                if distance < distances[neighbor]:
                    distances[neighbor] = distance
                    heapq.heappush(priority_queue, (distance, neighbor))

        # Filter out vertices with no path from the result
        shortest_paths = {k: v for k, v in shortest_paths.items() if v != float('inf')}

        return shortest_paths
