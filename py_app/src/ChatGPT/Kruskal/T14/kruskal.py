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
        self.graph.sort(key=lambda edge: edge[2])
        minimal_spanning_tree = []
        parent = [i for i in range(self.vertices)]
        rank = [0] * self.vertices
        num_edges = 0

        for edge in self.graph:
            source, destination, weight = edge
            source_parent = self.find_parent(parent, source)
            destination_parent = self.find_parent(parent, destination)

            if source_parent != destination_parent:
                minimal_spanning_tree.append(edge)
                self.union(parent, rank, source_parent, destination_parent)
                num_edges += 1

            if num_edges == self.vertices - 1:
                break

        return minimal_spanning_tree
