class Kruskal:
    def __init__(self, vertices):
        self.vertices = vertices
        self.edges = []

    def add_edge(self, source, destination, weight):
        self.edges.append((source, destination, weight))

    def find(self, parent, vertex):
        if parent[vertex] == vertex:
            return vertex
        return self.find(parent, parent[vertex])

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
        result = []
        self.edges = sorted(self.edges, key=lambda edge: edge[2])  # Sort edges by weight
        parent = [i for i in range(self.vertices)]
        rank = [0] * self.vertices
        edge_count = 0

        while edge_count < self.vertices - 1:
            source, destination, weight = self.edges.pop(0)
            x = self.find(parent, source)
            y = self.find(parent, destination)

            if x != y:
                result.append((source, destination, weight))
                self.union(parent, rank, x, y)
                edge_count += 1

        return result
