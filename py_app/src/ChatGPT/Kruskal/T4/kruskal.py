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
        x_set = self.find(parent, x)
        y_set = self.find(parent, y)
        parent[x_set] = y_set

    def run_kruskal_algorithm(self):
        self.graph.sort(key=lambda edge: edge[2])
        minimal_spanning_tree = []
        parent = [-1] * self.vertices

        for edge in self.graph:
            source, destination, weight = edge
            source_set = self.find(parent, source)
            destination_set = self.find(parent, destination)

            if source_set != destination_set:
                minimal_spanning_tree.append((source, destination, weight))
                self.union(parent, source_set, destination_set)

        return minimal_spanning_tree
