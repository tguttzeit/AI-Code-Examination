from collections import defaultdict, deque


class Graph:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = defaultdict(list)

    def add_edge(self, u, v):
        self.graph[u].append(v)

    def bfs(self, vertex):
        visited = [False] * self.vertices
        result = []

        queue = deque()
        queue.append(vertex)
        visited[vertex] = True

        while queue:
            current_vertex = queue.popleft()
            result.append(current_vertex)

            for neighbor in self.graph[current_vertex]:
                if not visited[neighbor]:
                    queue.append(neighbor)
                    visited[neighbor] = True

        return result
