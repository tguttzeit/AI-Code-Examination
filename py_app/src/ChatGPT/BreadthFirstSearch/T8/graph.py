from collections import defaultdict

class Graph:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = defaultdict(list)

    def add_edge(self, u, v):
        if u < 0 or u >= self.vertices or v < 0 or v >= self.vertices:
            raise ValueError("Invalid vertex value")
        self.graph[u].append(v)

    def bfs(self, start_vertex):
        if start_vertex < 0 or start_vertex >= self.vertices:
            raise ValueError("Invalid start_vertex value")

        visited = [False] * self.vertices  # Mark all vertices as not visited
        result = []  # To store the visited nodes in BFS order

        # Create a queue for BFS
        queue = []

        # Mark the source node as visited and enqueue it
        queue.append(start_vertex)
        visited[start_vertex] = True

        while queue:
            # Dequeue a vertex from the queue and append it to the result list
            current_vertex = queue.pop(0)
            result.append(current_vertex)

            # Get all adjacent vertices of the dequeued vertex
            # If an adjacent vertex has not been visited, mark it visited and enqueue it
            for neighbor in self.graph[current_vertex]:
                if not visited[neighbor]:
                    queue.append(neighbor)
                    visited[neighbor] = True

        return result
