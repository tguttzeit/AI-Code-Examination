class Kruskal:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = []

    def add_edge(self, source, destination, weight):
        self.graph.append((source, destination, weight))

    def find(self, parent, vertex):
        if parent[vertex] == -1:
            return vertex
        return self.find(parent, parent[vertex])

    def union(self, parent, x, y):
        x_root = self.find(parent, x)
        y_root = self.find(parent, y)
        parent[x_root] = y_root

    def run_kruskal_algorithm(self):
        result = []
        self.graph = sorted(self.graph, key=lambda item: item[2])
        parent = [-1] * self.vertices

        for edge in self.graph:
            source, destination, weight = edge
            source_root = self.find(parent, source)
            destination_root = self.find(parent, destination)

            if source_root != destination_root:
                result.append(edge)
                self.union(parent, source_root, destination_root)

        return result
