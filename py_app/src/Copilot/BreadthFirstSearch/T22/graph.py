class Graph:
    def __init__(self, vertices):
        self.vertices = vertices
        self.adj_list = [[] for i in range(self.vertices)]

    def add_edge(self, u, v):
        self.adj_list[u].append(v)
        self.adj_list[v].append(u)

    def bfs(self, vertex):
        queue = []
        visited = [False for i in range(self.vertices)]
        visited[vertex] = True
        queue.append(vertex)
        while len(queue) != 0:
            vertex = queue.pop(0)
            print(vertex, end=" ")
            for i in self.adj_list[vertex]:
                if visited[i] == False:
                    visited[i] = True
                    queue.append(i)

        # Driver code
