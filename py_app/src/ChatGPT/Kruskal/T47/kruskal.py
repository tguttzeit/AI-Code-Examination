class Kruskal:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = []

    def add_edge(self, source, destination, weight):
        self.graph.append((source, destination, weight))

    def find_parent(self, parent, node):
        if parent[node] == node:
            return node
        return self.find_parent(parent, parent[node])

    def union(self, parent, rank, source, destination):
        source_parent = self.find_parent(parent, source)
        dest_parent = self.find_parent(parent, destination)

        if rank[source_parent] < rank[dest_parent]:
            parent[source_parent] = dest_parent
        elif rank[source_parent] > rank[dest_parent]:
            parent[dest_parent] = source_parent
        else:
            parent[dest_parent] = source_parent
            rank[source_parent] += 1

    def run_kruskal_algorithm(self):
        self.graph.sort(key=lambda edge: edge[2])
        minimum_spanning_tree = []
        parent = [i for i in range(self.vertices)]
        rank = [0] * self.vertices

        for edge in self.graph:
            source, destination, weight = edge
            source_parent = self.find_parent(parent, source)
            dest_parent = self.find_parent(parent, destination)

            if source_parent != dest_parent:
                minimum_spanning_tree.append((source, destination, weight))
                self.union(parent, rank, source_parent, dest_parent)

        return minimum_spanning_tree
