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
        self.edges = sorted(self.edges, key=lambda edge: edge[2])  # Sort edges by weight
        minimal_spanning_tree = []
        parent = [i for i in range(self.vertices)]

        num_edges = 0
        index = 0

        while num_edges < self.vertices - 1:
            source, destination, weight = self.edges[index]
            index += 1

            source_parent = self.find_parent(parent, source)
            destination_parent = self.find_parent(parent, destination)

            if source_parent != destination_parent:
                minimal_spanning_tree.append((source, destination, weight))
                num_edges += 1
                parent[source_parent] = destination_parent

        return minimal_spanning_tree
