from collections import defaultdict


class Graph:
    def __init__(self, vertices):
        self.vertices = vertices
        self.adjacency_list = defaultdict(list)

    def add_edge(self, vertex1, vertex2):
        if vertex1 < self.vertices and vertex2 < self.vertices:
            self.adjacency_list[vertex1].append(vertex2)
            self.adjacency_list[vertex2].append(vertex1)
        else:
            raise ValueError("Vertices should be within the range of 0 to vertices-1.")

    def bfs(self, start_vertex):
        if start_vertex < 0 or start_vertex >= self.vertices:
            raise ValueError("Start vertex should be within the range of 0 to vertices-1.")

        visited = [False] * self.vertices
        result = []
        queue = []

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
