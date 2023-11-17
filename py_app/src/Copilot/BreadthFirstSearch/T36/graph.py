class Graph:
    class Graph:
        def __init__(self, vertices):
            self.vertices = vertices
            self.adj_list = [[] for i in range(vertices)]

        def bfs(self, vertex):
            visited = [False] * self.vertices
            queue = []
            visited[vertex] = True
            queue.append(vertex)
            while queue:
                s = queue.pop(0)
                print(s, end=" ")
                for i in self.adj_list[s]:
                    if visited[i] == False:
                        queue.append(i)
                        visited[i] = True
            print()

        def add_edge(self, src, dst):
            self.adj_list[src].append(dst)
            self.adj_list[dst].append(src)
