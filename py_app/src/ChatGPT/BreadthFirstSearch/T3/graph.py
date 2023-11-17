from collections import defaultdict, deque

class Graph:
    def __init__(self, vertices):
        self.vertices = vertices
        self.adjacency_list = defaultdict(list)

    def add_edge(self, vertex1, vertex2):
        self.adjacency_list[vertex1].append(vertex2)
        self.adjacency_list[vertex2].append(vertex1)

    def bfs(self, start_vertex):
        visited = [False] * (self.vertices + 1)
        result = []
        queue = deque()

        visited[start_vertex] = True
        queue.append(start_vertex)

        while queue:
            current_vertex = queue.popleft()
            result.append(current_vertex)

            for neighbor in self.adjacency_list[current_vertex]:
                if not visited[neighbor]:
                    visited[neighbor] = True
                    queue.append(neighbor)

        return result
