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
        self.edges.sort(key=lambda x: x[2])  # Sort edges by weight
        result = []
        parent = [-1] * self.vertices

        while len(result) < self.vertices - 1:
            source, destination, weight = self.edges.pop(0)
            x = self.find_parent(parent, source)
            y = self.find_parent(parent, destination)

            if x != y:
                result.append((source, destination, weight))
                self.union(parent, x, y)

        return result
