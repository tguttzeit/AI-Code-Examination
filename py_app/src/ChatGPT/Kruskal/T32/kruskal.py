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

    def union(self, parent, rank, u, v):
        root_u = self.find_parent(parent, u)
        root_v = self.find_parent(parent, v)

        if rank[root_u] < rank[root_v]:
            parent[root_u] = root_v
        elif rank[root_u] > rank[root_v]:
            parent[root_v] = root_u
        else:
            parent[root_v] = root_u
            rank[root_u] += 1

    def run_kruskal_algorithm(self):
        result = []
        self.graph = sorted(self.graph, key=lambda item: item[2])
        parent = [i for i in range(self.vertices)]
        rank = [0] * self.vertices
        edge_count = 0

        while edge_count < self.vertices - 1:
            source, destination, weight = self.graph.pop(0)
            x = self.find_parent(parent, source)
            y = self.find_parent(parent, destination)

            if x != y:
                result.append((source, destination, weight))
                self.union(parent, rank, x, y)
                edge_count += 1

        return result
