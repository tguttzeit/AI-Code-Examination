class Kruskal:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = []
        self.parent = []
        self.rank = []

    def add_edge(self, source, destination, weight):
        self.graph.append([source, destination, weight])

    def find(self, i):
        if self.parent[i] != i:
            self.parent[i] = self.find(self.parent[i])
        return self.parent[i]

    def union(self, source, destination):
        source_root = self.find(source)
        destination_root = self.find(destination)

        if self.rank[source_root] < self.rank[destination_root]:
            self.parent[source_root] = destination_root
        elif self.rank[source_root] > self.rank[destination_root]:
            self.parent[destination_root] = source_root
        else:
            self.parent[destination_root] = source_root
            self.rank[source_root] += 1

    def run_kruskal_algorithm(self):
        result = []
        i = 0
        e = 0
        self.graph = sorted(self.graph, key=lambda item: item[2])
        for node in range(self.vertices):
            self.parent.append(node)
            self.rank.append(0)
        while e < self.vertices - 1:
            source, destination, weight = self.graph[i]
            i = i + 1
            source_root = self.find(source)
            destination_root = self.find(destination)
            if source_root != destination_root:
                e = e + 1
                result.append([source, destination, weight])
                self.union(source_root, destination_root)
        return result
