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

    def union(self, parent, rank, node1, node2):
        root1 = self.find_parent(parent, node1)
        root2 = self.find_parent(parent, node2)

        if rank[root1] < rank[root2]:
            parent[root1] = root2
        elif rank[root1] > rank[root2]:
            parent[root2] = root1
        else:
            parent[root2] = root1
            rank[root1] += 1

    def run_kruskal_algorithm(self):
        result = []
        self.edges.sort(key=lambda x: x[2])
        parent = list(range(self.vertices))
        rank = [0] * self.vertices

        i, edge_count = 0, 0

        while edge_count < self.vertices - 1:
            source, destination, weight = self.edges[i]
            i += 1
            root1 = self.find_parent(parent, source)
            root2 = self.find_parent(parent, destination)

            if root1 != root2:
                result.append((source, destination, weight))
                self.union(parent, rank, root1, root2)
                edge_count += 1

        return result
