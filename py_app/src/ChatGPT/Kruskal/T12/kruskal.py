class Kruskal:
    def __init__(self, vertices):
        self.vertices = vertices
        self.edges = []

    def add_edge(self, source, destination, weight):
        self.edges.append((source, destination, weight))

    def find_parent(self, parent, vertex):
        if parent[vertex] == -1:
            return vertex
        if parent[vertex] != vertex:
            return self.find_parent(parent, parent[vertex])
        return vertex

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
            source_parent = self.find_parent(parent, source)
            destination_parent = self.find_parent(parent, destination)

            if source_parent != destination_parent:
                minimal_spanning_tree.append((source, destination, weight))
                self.union(parent, source_parent, destination_parent)

        return minimal_spanning_tree
