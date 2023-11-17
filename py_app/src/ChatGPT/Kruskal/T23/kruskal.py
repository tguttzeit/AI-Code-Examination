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

    def union(self, parent, rank, x, y):
        x_root = self.find(parent, x)
        y_root = self.find(parent, y)

        if rank[x_root] < rank[y_root]:
            parent[x_root] = y_root
        elif rank[x_root] > rank[y_root]:
            parent[y_root] = x_root
        else:
            parent[y_root] = x_root
            rank[x_root] += 1

    def run_kruskal_algorithm(self):
        minimum_spanning_tree = []
        self.edges = sorted(self.edges, key=lambda edge: edge[2])
        parent = [i for i in range(self.vertices)]
        rank = [0] * self.vertices
        edge_count = 0

        for edge in self.edges:
            source, destination, weight = edge
            source_root = self.find(parent, source)
            destination_root = self.find(parent, destination)

            if source_root != destination_root:
                minimum_spanning_tree.append((source, destination, weight))
                self.union(parent, rank, source_root, destination_root)
                edge_count += 1

            if edge_count == self.vertices - 1:
                break

        return minimum_spanning_tree
