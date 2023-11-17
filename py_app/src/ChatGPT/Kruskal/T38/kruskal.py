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

    def union(self, parent, rank, source, destination):
        source_parent = self.find_parent(parent, source)
        destination_parent = self.find_parent(parent, destination)

        if rank[source_parent] < rank[destination_parent]:
            parent[source_parent] = destination_parent
        elif rank[source_parent] > rank[destination_parent]:
            parent[destination_parent] = source_parent
        else:
            parent[destination_parent] = source_parent
            rank[source_parent] += 1

    def run_kruskal_algorithm(self):
        result = []
        self.graph = sorted(self.graph, key=lambda item: item[2])
        parent = [i for i in range(self.vertices)]
        rank = [0] * self.vertices
        edge_count = 0

        for edge in self.graph:
            source, destination, weight = edge
            if edge_count < self.vertices - 1:
                source_parent = self.find_parent(parent, source)
                destination_parent = self.find_parent(parent, destination)

                if source_parent != destination_parent:
                    result.append(edge)
                    edge_count += 1
                    self.union(parent, rank, source_parent, destination_parent)
            else:
                break

        return result
