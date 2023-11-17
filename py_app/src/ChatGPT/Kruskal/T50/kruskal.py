class Kruskal:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = []

    def add_edge(self, source, destination, weight):
        self.graph.append((source, destination, weight))

    def find(self, parent, node):
        if parent[node] == node:
            return node
        return self.find(parent, parent[node])

    def union(self, parent, rank, u, v):
        root_u = self.find(parent, u)
        root_v = self.find(parent, v)

        if rank[root_u] < rank[root_v]:
            parent[root_u] = root_v
        elif rank[root_u] > rank[root_v]:
            parent[root_v] = root_u
        else:
            parent[root_v] = root_u
            rank[root_u] += 1

    def run_kruskal_algorithm(self):
        minimum_spanning_tree = []
        self.graph.sort(key=lambda x: x[2])  # Sort edges by weight
        parent = list(range(self.vertices))
        rank = [0] * self.vertices

        edge_count = 0
        index = 0

        while edge_count < self.vertices - 1:
            source, destination, weight = self.graph[index]
            index += 1

            root_source = self.find(parent, source)
            root_destination = self.find(parent, destination)

            if root_source != root_destination:
                minimum_spanning_tree.append((source, destination, weight))
                edge_count += 1
                self.union(parent, rank, root_source, root_destination)

        return minimum_spanning_tree
