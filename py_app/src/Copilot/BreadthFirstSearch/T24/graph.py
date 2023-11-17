class Graph:
    def __init__(self, vertices):
        self.vertices = vertices
        self.adjacency_list = [[] for i in range(vertices)]

    def add_edge(self, u, v):
        self.adjacency_list[u].append(v)
        self.adjacency_list[v].append(u)

    def bfs(self, vertex):
        visited = [False] * self.vertices
        queue = []
        visited[vertex] = True
        queue.append(vertex)
        while len(queue) != 0:
            vertex = queue.pop(0)
            print(vertex)
            for i in self.adjacency_list[vertex]:
                if visited[i] == False:
                    queue.append(i)
                    visited[i] = True