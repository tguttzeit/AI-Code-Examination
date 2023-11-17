class Kruskal:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = []

    def add_edge(self, source, destination, weight):
        self.graph.append([source, destination, weight])

    def find(self, parent, i):
        if parent[i] == i:
            return i
        return self.find(parent, parent[i])

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
        i = 0
        e = 0

        self.graph = sorted(self.graph, key=lambda item: item[2])

        parent = []
        rank = []

        for node in range(self.vertices):
            parent.append(node)
            rank.append(0)

        while e < self.vertices - 1:
            source, destination, weight = self.graph[i]
            i += 1
            x = self.find(parent, source)
            y = self.find(parent, destination)

            if x != y:
                e += 1
                result.append([source, destination, weight])
                self.union(parent, rank, x, y)

        return result
