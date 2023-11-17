class Kruskal:
    def __init__(self, vertices):
        self.vertices = vertices
        self.edges = []

    def add_edge(self, source, destination, weight):
        self.edges.append((source, destination, weight))

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
        self.edges.sort(key=lambda x: x[2])  # Sort edges by weight
        minimum_spanning_tree = []
        parent = [-1] * self.vertices

        for edge in self.edges:
            source, destination, weight = edge
            source_root = self.find_parent(parent, source)
            destination_root = self.find_parent(parent, destination)

            if source_root != destination_root:
                minimum_spanning_tree.append((source, destination, weight))
                self.union(parent, source_root, destination_root)

        return minimum_spanning_tree
