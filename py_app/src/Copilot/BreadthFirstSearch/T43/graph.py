class Graph:
    def __init__(self, vertices):
        self.vertices = vertices
        self.adjacency_list = [[] for _ in range(vertices)]

    def bfs(self, vertex):
        visited = [False] * self.vertices
        queue = []
        queue.append(vertex)
        visited[vertex] = True
        while queue:
            vertex = queue.pop(0)
            print(vertex)
            for i in self.adjacency_list[vertex]:
                if not visited[i]:
                    queue.append(i)
                    visited[i] = True
        return visited

    def add_edge(self, vertex1, vertex2):
        self.adjacency_list[vertex1].append(vertex2)
        self.adjacency_list[vertex2].append(vertex1)
