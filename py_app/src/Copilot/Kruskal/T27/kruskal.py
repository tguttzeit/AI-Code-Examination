class Kruskal:
    def __init__(self, vertices):
        self.V = vertices
        self.graph = []
        self.parent = []
        self.rank = []

    def add_edge(self, source, destination, weight):
        self.graph.append([source, destination, weight])

    def run_kruskal_algorithm(self):
        result = []
        i = 0
        e = 0
        self.graph = sorted(self.graph, key=lambda item: item[2])
        for node in range(self.V):
            self.parent.append(node)
            self.rank.append(0)
        while e < self.V - 1:
            s, d, w = self.graph[i]
            i = i + 1
            x = self.find(s)
            y = self.find(d)
            if x != y:
                e = e + 1
                result.append([s, d, w])
                self.union(x, y)
        return result

    def find(self, i):
        if self.parent[i] == i:
            return i
        return self.find(self.parent[i])

    def union(self, x, y):
        xroot = self.find(x)
        yroot = self.find(y)
        if self.rank[xroot] < self.rank[yroot]:
            self.parent[xroot] = yroot
        elif self.rank[yroot] < self.rank[xroot]:
            self.parent[yroot] = xroot
        else:
            self.parent[yroot] = xroot
            self.rank[xroot] = self.rank[xroot] + 1
