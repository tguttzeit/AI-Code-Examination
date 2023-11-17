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
        x_set = self.find_parent(parent, x)
        y_set = self.find_parent(parent, y)
        parent[x_set] = y_set

    def run_kruskal_algorithm(self):
        minimal_spanning_tree = []
        self.edges = sorted(self.edges, key=lambda edge: edge[2])
        parent = [-1] * self.vertices

        for edge in self.edges:
            source, destination, weight = edge
            if self.find_parent(parent, source) != self.find_parent(parent, destination):
                minimal_spanning_tree.append((source, destination, weight))
                self.union(parent, source, destination)

        return minimal_spanning_tree
