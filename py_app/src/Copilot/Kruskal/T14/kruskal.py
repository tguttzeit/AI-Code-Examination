class Kruskal:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = []
        self.graph_matrix = [[0 for column in range(vertices)] for row in range(vertices)]

    def add_edge(self, source, destination, weight):
        self.graph.append([source, destination, weight])

    def find(self, parent, i):
        if parent[i] == i:
            return i
        return self.find(parent, parent[i])

    def kruskal(self):
        result = []
        i = 0
        e = 0
        self.graph = sorted(self.graph, key=lambda item: item[2])
        parent = []
        rank = []
        for node in range(self.vertices):
            parent.append(node)
            rank.append(0)
        while e < self.vertices - 1:
            source, destination, weight = self.graph[i]
            i = i + 1
            x = self.find(parent, source)
            y = self.find(parent, destination)
            if x != y:
                e = e + 1
                result.append([source, destination, weight])
                self.union(parent, rank, x, y)
        return result

    def union(self, parent, rank, x, y):
        xroot = self.find(parent, x)
        yroot = self.find(parent, y)
        if rank[xroot] < rank[yroot]:
            parent[xroot] = yroot
        elif rank[xroot] > rank[yroot]:
            parent[yroot] = xroot
        else:
            parent[yroot] = xroot
            rank[xroot] += 1

    def print(self, result):
        print("Following are the edges in the constructed MST")
        for source, destination, weight in result:
            print("%d -- %d == %d" % (source, destination, weight))
