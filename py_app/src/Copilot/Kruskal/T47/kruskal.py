class Kruskal:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = []

    def add_edge(self, source, destination, weight):
        self.graph.append([source, destination, weight])

    def find_parent(self, parent, i):
        if parent[i] == i:
            return i
        return self.find_parent(parent, parent[i])

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
            i = i + 1
            source_parent = self.find_parent(parent, source)
            destination_parent = self.find_parent(parent, destination)
            if source_parent != destination_parent:
                e = e + 1
                result.append([source, destination, weight])
                self.union(parent, rank, source_parent, destination_parent)
        return result
