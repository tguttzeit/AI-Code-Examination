class Graph:
    def __init__(self, vertices):
        self.vertices = vertices
        self.adj_list = [[] for i in range(vertices)]
        self.visited = [False]*vertices

    def add_edge(self, u, v):
        self.adj_list[u].append(v)

    def bfs(self, vertex):
        queue = []
        visited = []
        queue.append(vertex)
        self.visited[vertex] = True
        while queue:
            vertex = queue.pop(0)
            visited.append(vertex)
            for i in self.adj_list[vertex]:
                if self.visited[i] == False:
                    queue.append(i)
                    self.visited[i] = True
        return visited
