class Graph:
    def __init__(self, vertices):
        self.vertices = vertices
        self.adjacency_list = [[] for _ in range(vertices)]

    def bfs(self, vertex):
        # write your code here
        result = []
        queue = [vertex]
        visited = [0 for _ in range(self.vertices)]
        visited[vertex] = 1
        while queue:
            cur = queue.pop(0)
            result.append(cur)
            for i in self.adjacency_list[cur]:
                if visited[i] == 0:
                    queue.append(i)
                    visited[i] = 1
        return result

    def add_edge(self, v1, v2):
        # write your code here
        self.adjacency_list[v1].append(v2)
        self.adjacency_list[v2].append(v1)
