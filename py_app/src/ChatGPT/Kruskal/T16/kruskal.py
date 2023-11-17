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

    def union(self, parent, rank, x, y):
        x_root = self.find_parent(parent, x)
        y_root = self.find_parent(parent, y)

        if rank[x_root] < rank[y_root]:
            parent[x_root] = y_root
        elif rank[x_root] > rank[y_root]:
            parent[y_root] = x_root
        else:
            parent[y_root] = x_root
            rank[x_root] += 1

    def run_kruskal_algorithm(self):
        self.edges.sort(key=lambda x: x[2])
        result = []
        parent = [i for i in range(self.vertices)]
        rank = [0] * self.vertices
        total_weight = 0

        for edge in self.edges:
            source, destination, weight = edge
            x = self.find_parent(parent, source)
            y = self.find_parent(parent, destination)

            if x != y:
                result.append(edge)
                self.union(parent, rank, x, y)
                total_weight += weight

        return result
