from collections import defaultdict, deque

class Graph:
    def __init__(self, vertices):
        self.vertices = vertices
        self.adjacency_list = defaultdict(list)

    def add_edge(self, u, v):
        self.adjacency_list[u].append(v)
        self.adjacency_list[v].append(u)

    def bfs(self, start_vertex):
        visited = [False] * (self.vertices + 1)
        result = []

        queue = deque()
        queue.append(start_vertex)
        visited[start_vertex] = True

        while queue:
            vertex = queue.popleft()
            result.append(vertex)

            for neighbor in self.adjacency_list[vertex]:
                if not visited[neighbor]:
                    queue.append(neighbor)
                    visited[neighbor] = True

        return result
