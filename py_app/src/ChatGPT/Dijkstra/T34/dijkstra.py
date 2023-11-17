import heapq

class Dijkstra:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = [[] for _ in range(vertices)]

    def add_edge(self, source, destination, weight):
        self.graph[source].append((destination, weight))
        self.graph[destination].append((source, weight))  # Assuming an undirected graph

    def find_shortest_paths(self, source):
        # Initialize distances and visited flags
        distances = [float('inf')] * self.vertices
        distances[source] = 0
        visited = [False] * self.vertices

        # Create a priority queue (min heap) to store vertices with their distances
        priority_queue = [(0, source)]

        # Initialize the result dictionary
        shortest_paths = {}

        while priority_queue:
            # Get the vertex with the smallest distance
            current_distance, current_vertex = heapq.heappop(priority_queue)

            # Skip if already visited
            if visited[current_vertex]:
                continue

            # Mark the current vertex as visited
            visited[current_vertex] = True

            # Store the shortest distance to the current vertex in the result dictionary
            shortest_paths[current_vertex] = current_distance

            # Update distances to neighboring vertices
            for neighbor, weight in self.graph[current_vertex]:
                distance = current_distance + weight
                if distance < distances[neighbor]:
                    distances[neighbor] = distance
                    heapq.heappush(priority_queue, (distance, neighbor))

        # Convert distances to a dictionary
        result = {}
        for i, distance in enumerate(distances):
            if distance != float('inf'):
                result[i] = distance

        return result
