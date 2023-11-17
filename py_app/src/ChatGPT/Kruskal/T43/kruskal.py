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

    def union(self, parent, rank, source, destination):
        source_root = self.find_parent(parent, source)
        dest_root = self.find_parent(parent, destination)

        if rank[source_root] < rank[dest_root]:
            parent[source_root] = dest_root
        elif rank[source_root] > rank[dest_root]:
            parent[dest_root] = source_root
        else:
            parent[dest_root] = source_root
            rank[source_root] += 1

    def run_kruskal_algorithm(self):
        self.edges.sort(key=lambda edge: edge[2])
        parent = [i for i in range(self.vertices)]
        rank = [0] * self.vertices
        minimum_spanning_tree = []

        for edge in self.edges:
            source, destination, weight = edge
            source_root = self.find_parent(parent, source)
            dest_root = self.find_parent(parent, destination)

            if source_root != dest_root:
                minimum_spanning_tree.append(edge)
                self.union(parent, rank, source_root, dest_root)

        return minimum_spanning_tree
