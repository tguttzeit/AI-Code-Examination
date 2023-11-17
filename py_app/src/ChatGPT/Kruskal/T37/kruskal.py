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
        result = []
        self.edges = sorted(self.edges, key=lambda x: x[2])
        parent = [i for i in range(self.vertices)]
        rank = [0] * self.vertices
        edge_count = 0

        for edge in self.edges:
            source, destination, weight = edge
            if edge_count == self.vertices - 1:
                break
            source_parent = self.find_parent(parent, source)
            dest_parent = self.find_parent(parent, destination)
            if source_parent != dest_parent:
                result.append((source, destination, weight))
                edge_count += 1
                self.union(parent, rank, source_parent, dest_parent)

        return result