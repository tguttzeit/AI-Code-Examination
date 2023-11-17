class Graph:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = [[] for i in range(vertices)]
        self.visited = [False for i in range(vertices)]

    def bfs(self, vertex):
        self.visited = [False for i in range(self.vertices)]
        queue = []
        queue.append(vertex)
        self.visited[vertex] = True
        while len(queue) != 0:
            vertex = queue.pop(0)
            print(vertex, end = " ")
            for i in self.graph[vertex]:
                if self.visited[i] == False:
                    queue.append(i)
                    self.visited[i] = True

    def add_edge(self, vertex1, vertex2):
        self.graph[vertex1].append(vertex2)
        self.graph[vertex2].append(vertex1)
