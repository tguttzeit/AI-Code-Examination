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

    def union(self, parent, rank, source, destination):
        source_root = self.find(parent, source)
        destination_root = self.find(parent, destination)

        if rank[source_root] < rank[destination_root]:
            parent[source_root] = destination_root
        elif rank[source_root] > rank[destination_root]:
            parent[destination_root] = source_root
        else:
            parent[destination_root] = source_root
            rank[source_root] += 1

    def run_kruskal_algorithm(self):
        result = []
        self.graph = sorted(self.graph, key=lambda item: item[2])  # Sort edges by weight

        parent = [i for i in range(self.vertices)]
        rank = [0] * self.vertices

        i = 0
        while len(result) < self.vertices - 1:
            source, destination, weight = self.graph[i]
            i += 1

            source_root = self.find(parent, source)
            destination_root = self.find(parent, destination)

            if source_root != destination_root:
                result.append((source, destination, weight))
                self.union(parent, rank, source_root, destination_root)

        return result
