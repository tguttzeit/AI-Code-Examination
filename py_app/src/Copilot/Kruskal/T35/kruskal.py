class Kruskal:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = []
        self.parent = [i for i in range(vertices)]
        self.rank = [0 for i in range(vertices)]

    def add_edge(self, source, destination, weight):
        self.graph.append([source, destination, weight])

    def find(self, vertex):
        if self.parent[vertex] != vertex:
            self.parent[vertex] = self.find(self.parent[vertex])
        return self.parent[vertex]

    def union(self, vertex1, vertex2):
        root1 = self.find(vertex1)
        root2 = self.find(vertex2)
        if self.rank[root1] < self.rank[root2]:
            self.parent[root1] = root2
        elif self.rank[root1] > self.rank[root2]:
            self.parent[root2] = root1
        else:
            self.parent[root1] = root2
            self.rank[root2] += 1

    def run_kruskal_algorithm(self):
        self.graph = sorted(self.graph, key=lambda item: item[2])
        min_spanning_tree = []
        index = 0
        while len(min_spanning_tree) < self.vertices - 1:
            source, destination, weight = self.graph[index]
            index += 1
            root1 = self.find(source)
            root2 = self.find(destination)
            if root1 != root2:
                min_spanning_tree.append([source, destination, weight])
                self.union(root1, root2)
        return min_spanning_tree
