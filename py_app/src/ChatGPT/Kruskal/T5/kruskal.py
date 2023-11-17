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
        self.edges.sort(key=lambda edge: edge[2])  # Sort edges by weight
        min_spanning_tree = []
        parent = [i for i in range(self.vertices)]

        while len(min_spanning_tree) < self.vertices - 1:
            source, destination, weight = self.edges.pop(0)

            source_parent = self.find_parent(parent, source)
            destination_parent = self.find_parent(parent, destination)

            if source_parent != destination_parent:
                min_spanning_tree.append((source, destination, weight))
                parent[source_parent] = destination_parent

        return min_spanning_tree
