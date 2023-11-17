class Kruskal:
    def __init__(self, vertices):
        self.vertices = vertices
        self.edges = []

    def add_edge(self, source, destination, weight):
        self.edges.append((source, destination, weight))

    def find(self, parent, node):
        if parent[node] == node:
            return node
        return self.find(parent, parent[node])

    def union(self, parent, rank, source, destination):
        source_root = self.find(parent, source)
        dest_root = self.find(parent, destination)

        if rank[source_root] < rank[dest_root]:
            parent[source_root] = dest_root
        elif rank[source_root] > rank[dest_root]:
            parent[dest_root] = source_root
        else:
            parent[dest_root] = source_root
            rank[source_root] += 1

    def run_kruskal_algorithm(self):
        self.edges.sort(key=lambda x: x[2])  # Sort edges by weight
        minimum_spanning_tree = []
        parent = [i for i in range(self.vertices)]
        rank = [0] * self.vertices
        num_edges_added = 0

        for edge in self.edges:
            source, destination, weight = edge
            source_root = self.find(parent, source)
            dest_root = self.find(parent, destination)

            if source_root != dest_root:
                minimum_spanning_tree.append(edge)
                self.union(parent, rank, source_root, dest_root)
                num_edges_added += 1

            if num_edges_added == self.vertices - 1:
                break

        return minimum_spanning_tree
