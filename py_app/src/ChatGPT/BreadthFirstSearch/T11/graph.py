from collections import defaultdict, deque


class Graph:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = defaultdict(list)

    def add_edge(self, u, v):
        # Add an edge between vertex u and v
        self.graph[u].append(v)

    def bfs(self, start_vertex):
        visited = [False] * (self.vertices)
        result = []

        # Create a queue for BFS
        queue = deque()

        # Mark the source node as visited and enqueue it
        queue.append(start_vertex)
        visited[start_vertex] = True

        while queue:
            # Dequeue a vertex from the queue and add it to the result
            vertex = queue.popleft()
            result.append(vertex)

            # Get all adjacent vertices of the dequeued vertex.
            # If an adjacent vertex has not been visited yet, mark it as visited and enqueue it.
            for neighbor in self.graph[vertex]:
                if not visited[neighbor]:
                    queue.append(neighbor)
                    visited[neighbor] = True

        return result
