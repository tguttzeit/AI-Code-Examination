from collections import defaultdict

class Graph:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = defaultdict(list)

    def add_edge(self, u, v):
        self.graph[u].append(v)

    def bfs(self, start_vertex):
        visited = [False] * self.vertices
        result = []

        # Create a queue for BFS
        queue = []

        # Mark the start_vertex as visited and enqueue it
        visited[start_vertex] = True
        queue.append(start_vertex)

        while queue:
            # Dequeue a vertex from the queue and add it to the result
            vertex = queue.pop(0)
            result.append(vertex)

            # Get all adjacent vertices of the dequeued vertex
            # If an adjacent vertex has not been visited, mark it as visited
            # and enqueue it
            for neighbor in self.graph[vertex]:
                if not visited[neighbor]:
                    visited[neighbor] = True
                    queue.append(neighbor)

        return result
