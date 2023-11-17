class Graph:
    def __init__(self, vertices):
        self.vertices = vertices
        self.adjacency_list = [[] for i in range(vertices)]

    def add_edge(self, u, v):
        self.adjacency_list[u].append(v)
        self.adjacency_list[v].append(u)

    def bfs(self, start):
        visited = [False] * self.vertices
        queue = []
        queue.append(start)
        visited[start] = True
        result = []
        while queue:
            s = queue.pop(0)
            result.append(s)
            for i in self.adjacency_list[s]:
                if visited[i] == False:
                    queue.append(i)
                    visited[i] = True
        return result
