class Graph:
    def __init__(self, vertices):
        self.vertices = vertices
        self.adj_list = [[] for _ in range(vertices)]

    def bfs(self, vertex):
        result = []
        queue = []
        visited = [False] * self.vertices
        queue.append(vertex)
        visited[vertex] = True
        while queue:
            vertex = queue.pop(0)
            result.append(vertex)
            for adjacent in self.adj_list[vertex]:
                if not visited[adjacent]:
                    queue.append(adjacent)
                    visited[adjacent] = True
        return result

    def add_edge(self, vertex1, vertex2):
        if vertex1 < self.vertices and vertex2 < self.vertices:
            self.adj_list[vertex1].append(vertex2)
            self.adj_list[vertex2].append(vertex1)

    def print_graph(self):
        for i in range(self.vertices):
            print("Vertex", i, ":", self.adj_list[i])
