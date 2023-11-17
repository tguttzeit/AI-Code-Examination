class Kruskal:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = []

    def add_edge(self, source, destination, weight):
        self.graph.append((source, destination, weight))

    def find_parent(self, parent, node):
        if parent[node] == -1:
            return node
        if parent[node] != node:
            return self.find_parent(parent, parent[node])
        return node

    def union(self, parent, x, y):
        x_root = self.find_parent(parent, x)
        y_root = self.find_parent(parent, y)
        parent[x_root] = y_root

    def run_kruskal_algorithm(self):
        self.graph.sort(key=lambda x: x[2])  # Sort edges by weight
        result = []
        parent = [-1] * self.vertices

        for edge in self.graph:
            source, destination, weight = edge
            source_parent = self.find_parent(parent, source)
            dest_parent = self.find_parent(parent, destination)

            if source_parent != dest_parent:
                result.append(edge)
                self.union(parent, source_parent, dest_parent)

        return result
