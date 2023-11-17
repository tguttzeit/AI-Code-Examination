class Graph:
    def __init__(self, vertices):
        self.vertices = vertices
        self.list = [[] for i in range(vertices)]

    def bfs(self, vertex):
        visited = [False] * self.vertices
        queue = []
        queue.append(vertex)
        visited[vertex] = True
        visited_order = []
        while queue:
            vertex = queue.pop(0)
            visited_order.append(vertex)
            for i in self.list[vertex]:
                if visited[i] == False:
                    queue.append(i)
                    visited[i] = True
        return visited_order

    def add_edge(self, vertex1, vertex2):
        self.list[vertex1].append(vertex2)
        self.list[vertex2].append(vertex1)
