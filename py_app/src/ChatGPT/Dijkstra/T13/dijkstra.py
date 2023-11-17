import heapq

class Dijkstra:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = [[] for _ in range(vertices)]

    def add_edge(self, source, destination, weight):
        self.graph[source].append((destination, weight))
        self.graph[destination].append((source, weight))  # Assuming an undirected graph

    def find_shortest_paths(self, source):
        # Initialize distances and visited array
        distances = [float('inf')] * self.vertices
        visited = [False] * self.vertices

        # Initialize distance to source vertex as 0
        distances[source] = 0

        # Create a priority queue (min heap) to store vertices
        priority_queue = [(0, source)]

        while priority_queue:
            # Get the vertex with the smallest distance from the priority queue
            dist, current_vertex = heapq.heappop(priority_queue)

            # Skip this vertex if it has already been visited
            if visited[current_vertex]:
                continue

            # Mark the current vertex as visited
            visited[current_vertex] = True

            # Update the distances of adjacent vertices
            for neighbor, edge_weight in self.graph[current_vertex]:
                if not visited[neighbor]:
                    new_distance = dist + edge_weight
                    if new_distance < distances[neighbor]:
                        distances[neighbor] = new_distance
                        heapq.heappush(priority_queue, (new_distance, neighbor))

        # Create a dictionary to store the shortest paths
        shortest_paths = {}
        for i in range(self.vertices):
            if i != source and distances[i] != float('inf'):
                shortest_paths[i] = distances[i]

        return shortest_paths