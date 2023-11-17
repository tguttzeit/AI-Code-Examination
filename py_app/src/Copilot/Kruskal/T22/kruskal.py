class Kruskal:
    def __init__(self, vertices):
        self.vertices = vertices
        self.edges = []
        self.parent = {}
        self.rank = {}
        for i in range(self.vertices):
            self.parent[i] = i
            self.rank[i] = 0

    def add_edge(self, source, destination, weight):
        self.edges.append([source, destination, weight])

    def find(self, vertex):
        if self.parent[vertex] == vertex:
            return vertex
        else:
            return self.find(self.parent[vertex])

    def union(self, vertex1, vertex2):
        if self.rank[vertex1] > self.rank[vertex2]:
            self.parent[vertex2] = vertex1
        elif self.rank[vertex1] < self.rank[vertex2]:
            self.parent[vertex1] = vertex2
        else:
            self.parent[vertex1] = vertex2
            self.rank[vertex2] += 1

    def run_kruskal_algorithm(self):
        result = []
        i = 0
        e = 0
        self.edges = sorted(self.edges, key=lambda x: x[2])
        while e < self.vertices - 1:
            u, v, w = self.edges[i]
            i += 1
            x = self.find(u)
            y = self.find(v)
            if x != y:
                e += 1
                result.append([u, v, w])
                self.union(x, y)
        return result
