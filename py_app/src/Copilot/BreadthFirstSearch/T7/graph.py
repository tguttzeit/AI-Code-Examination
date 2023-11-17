class Graph:

    def __init__(self, vertices):
        self.vertices = vertices
        self.adjacency_list = [[] for _ in range(vertices)]

    def add_edge(self, u, v):
        self.adjacency_list[u].append(v)

    def bfs(self, vertex):
        visited = [False] * self.vertices
        queue = [vertex]
        visited[vertex] = True
        result = []
        while queue:
            vertex = queue.pop(0)
            result.append(vertex)
            for adjacent in self.adjacency_list[vertex]:
                if not visited[adjacent]:
                    queue.append(adjacent)
                    visited[adjacent] = True
        return result
