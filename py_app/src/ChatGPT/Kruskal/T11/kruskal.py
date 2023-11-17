class Kruskal:
    def __init__(self, vertices):
        self.vertices = vertices
        self.edges = []

    def add_edge(self, source, destination, weight):
        self.edges.append((source, destination, weight))

    def find_parent(self, parent, node):
        if parent[node] == node:
            return node
        return self.find_parent(parent, parent[node])

    def run_kruskal_algorithm(self):
        self.edges.sort(key=lambda x: x[2])  # Sort edges by weight
        minimum_spanning_tree = []
        parent = [i for i in range(self.vertices)]

        for edge in self.edges:
            source, destination, weight = edge
            source_parent = self.find_parent(parent, source)
            dest_parent = self.find_parent(parent, destination)

            if source_parent != dest_parent:
                minimum_spanning_tree.append(edge)
                parent[source_parent] = dest_parent

        return minimum_spanning_tree
