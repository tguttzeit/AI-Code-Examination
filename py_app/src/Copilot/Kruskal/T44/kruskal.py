class Kruskal:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = []
        self.parent = []
        self.rank = []

    def add_edge(self, source, destination, weight):
        self.graph.append([source, destination, weight])

    def find(self, i):
        if self.parent[i] == i:
            return i
        return self.find(self.parent[i])

    def union(self, source, destination):
        source_parent = self.find(source)
        destination_parent = self.find(destination)
        if self.rank[source_parent] < self.rank[destination_parent]:
            self.parent[source_parent] = destination_parent
        elif self.rank[source_parent] > self.rank[destination_parent]:
            self.parent[destination_parent] = source_parent
        else:
            self.parent[destination_parent] = source_parent
            self.rank[source_parent] += 1

    def run_kruskal_algorithm(self):
        result = []
        i = 0
        e = 0
        self.graph = sorted(self.graph, key=lambda item: item[2])
        self.parent = []
        self.rank = []
        for node in range(self.vertices):
            self.parent.append(node)
            self.rank.append(0)
        while e < self.vertices - 1:
            source, destination, weight = self.graph[i]
            i = i + 1
            source_parent = self.find(source)
            destination_parent = self.find(destination)
            if source_parent != destination_parent:
                e = e + 1
                result.append([source, destination, weight])
                self.union(source_parent, destination_parent)
        return result
