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
        x_set = self.find_parent(parent, x)
        y_set = self.find_parent(parent, y)
        parent[x_set] = y_set

    def run_kruskal_algorithm(self):
        self.graph.sort(key=lambda edge: edge[2])  # Sort edges by weight
        minimum_spanning_tree = []
        parent = [-1] * self.vertices

        edge_count = 0
        while edge_count < self.vertices - 1:
            source, destination, weight = self.graph.pop(0)
            x = self.find_parent(parent, source)
            y = self.find_parent(parent, destination)

            if x != y:
                minimum_spanning_tree.append((source, destination, weight))
                self.union(parent, x, y)
                edge_count += 1

        return minimum_spanning_tree
