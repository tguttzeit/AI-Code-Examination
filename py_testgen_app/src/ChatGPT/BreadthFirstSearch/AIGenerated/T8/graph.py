from collections import defaultdict, deque


class Graph:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = defaultdict(list)

    def add_edge(self, vertex1, vertex2):
        if vertex1 <= self.vertices and vertex2 <= self.vertices:
            self.graph[vertex1].append(vertex2)
        else:
            raise ValueError("Vertices should be within the specified range.")

    def bfs(self, start_vertex):
        if start_vertex > self.vertices:
            raise ValueError("Start vertex should be within the specified range.")

        visited = [False] * (self.vertices + 1)
        result = []

        queue = deque()
        queue.append(start_vertex)
        visited[start_vertex] = True

        while queue:
            current_vertex = queue.popleft()
            result.append(current_vertex)

            for neighbor in self.graph[current_vertex]:
                if not visited[neighbor]:
                    queue.append(neighbor)
                    visited[neighbor] = True

        return result
