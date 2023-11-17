
class Kruskal:
    def __init__(self, vertices):
        self.vertices = vertices
        self.edges = []
        self.parent = {}

    def add_edge(self, source, destination, weight):
        self.edges.append([source, destination, weight])

    def find_parent(self, vertex):
        if self.parent[vertex] == vertex:
            return vertex
        return self.find_parent(self.parent[vertex])

    def union(self, vertex1, vertex2):
        self.parent[vertex1] = vertex2

    def run_kruskal_algorithm(self):
        self.edges = sorted(self.edges, key=lambda item: item[2])
        minimum_spanning_tree = []
        for vertex in range(self.vertices):
            self.parent[vertex] = vertex
        for edge in self.edges:
            vertex1 = self.find_parent(edge[0])
            vertex2 = self.find_parent(edge[1])
            if vertex1 != vertex2:
                minimum_spanning_tree.append(edge)
                self.union(vertex1, vertex2)
        return minimum_spanning_tree
