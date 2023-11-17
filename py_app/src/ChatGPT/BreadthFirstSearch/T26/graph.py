from collections import defaultdict


class Graph:
    def __init__(self, vertices):
        self.vertices = vertices
        self.adjacency_list = defaultdict(list)

    def add_edge(self, u, v):
        if 0 <= u < self.vertices and 0 <= v < self.vertices:
            self.adjacency_list[u].append(v)
            self.adjacency_list[v].append(u)  # Assuming an undirected graph

    def bfs(self, start_vertex):
        if 0 <= start_vertex < self.vertices:
            visited = [False] * self.vertices
            queue = []
            result = []

            visited[start_vertex] = True
            queue.append(start_vertex)

            while queue:
                current_vertex = queue.pop(0)
                result.append(current_vertex)

                for neighbor in self.adjacency_list[current_vertex]:
                    if not visited[neighbor]:
                        visited[neighbor] = True
                        queue.append(neighbor)

            return result
        else:
            raise ValueError("Invalid start vertex")
