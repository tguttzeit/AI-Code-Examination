class Kruskal:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = []

    def add_edge(self, source, destination, weight):
        self.graph.append((source, destination, weight))

    def find_parent(self, parent, node):
        if parent[node] == -1:
            return node
        return self.find_parent(parent, parent[node])

    def union(self, parent, x, y):
        x_root = self.find_parent(parent, x)
        y_root = self.find_parent(parent, y)
        parent[x_root] = y_root

    def run_kruskal_algorithm(self):
        self.graph = sorted(self.graph, key=lambda item: item[2])
        minimal_spanning_tree = []
        parent = [-1] * self.vertices

        edge_count = 0
        while edge_count < self.vertices - 1:
            source, destination, weight = self.graph.pop(0)
            x = self.find_parent(parent, source)
            y = self.find_parent(parent, destination)

            if x != y:
                minimal_spanning_tree.append((source, destination, weight))
                self.union(parent, x, y)
                edge_count += 1

        return minimal_spanning_tree
