class Kruskal:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = []

    def add_edge(self, source, destination, weight):
        self.graph.append((source, destination, weight))

    def find_parent(self, parent, node):
        if parent[node] == -1:
            return node
        if parent[node] != node:
            return self.find_parent(parent, parent[node])
        return node

    def union(self, parent, x, y):
        x_set = self.find_parent(parent, x)
        y_set = self.find_parent(parent, y)
        parent[x_set] = y_set

    def run_kruskal_algorithm(self):
        result = []
        self.graph = sorted(self.graph, key=lambda item: item[2])
        parent = [-1] * self.vertices

        edge_count = 0
        index = 0

        while edge_count < self.vertices - 1:
            source, destination, weight = self.graph[index]
            index += 1
            x = self.find_parent(parent, source)
            y = self.find_parent(parent, destination)

            if x != y:
                edge_count += 1
                result.append((source, destination, weight))
                self.union(parent, x, y)

        return result
