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
        root_source = self.find(parent, source)
        root_dest = self.find(parent, destination)

        if rank[root_source] < rank[root_dest]:
            parent[root_source] = root_dest
        elif rank[root_source] > rank[root_dest]:
            parent[root_dest] = root_source
        else:
            parent[root_dest] = root_source
            rank[root_source] += 1

    def run_kruskal_algorithm(self):
        self.edges.sort(key=lambda x: x[2])  # Sort edges by weight
        parent = [i for i in range(self.vertices)]
        rank = [0] * self.vertices
        min_spanning_tree = []

        for edge in self.edges:
            source, destination, weight = edge
            root_source = self.find(parent, source)
            root_dest = self.find(parent, destination)

            if root_source != root_dest:
                min_spanning_tree.append(edge)
                self.union(parent, rank, root_source, root_dest)

        return min_spanning_tree
