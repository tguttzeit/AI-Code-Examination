from collections import defaultdict, deque

class Graph:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = defaultdict(list)

    def add_edge(self, u, v):
        self.graph[u].append(v)
        self.graph[v].append(u)

    def bfs(self, vertex):
        visited = [False] * (self.vertices)
        result = []
        queue = deque()

        visited[vertex] = True
        queue.append(vertex)

        while queue:
            vertex = queue.popleft()
            result.append(vertex)

            for neighbor in self.graph[vertex]:
                if not visited[neighbor]:
                    visited[neighbor] = True
                    queue.append(neighbor)

        return result
