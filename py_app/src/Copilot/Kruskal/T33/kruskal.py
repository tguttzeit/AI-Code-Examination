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

    def kruskal_algorithm(self):
        result = []
        i = 0
        e = 0
        self.graph = sorted(self.graph, key=lambda item: item[2])
        parent = []
        for node in range(self.vertices):
            parent.append(node)
        while e < self.vertices - 1:
            source, destination, weight = self.graph[i]
            i = i + 1
            x = self.find_parent(parent, source)
            y = self.find_parent(parent, destination)
            if x != y:
                e = e + 1
                result.append([source, destination, weight])
                parent[x] = y
        return result
