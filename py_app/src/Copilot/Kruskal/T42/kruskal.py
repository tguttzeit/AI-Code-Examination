class Kruskal:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = []
        self.parent = []

    def add_edge(self, source, destination, weight):
        self.graph.append([source, destination, weight])

    def find(self, i):
        if self.parent[i] == i:
            return i
        return self.find(self.parent[i])

    def union(self, source, destination):
        source_parent = self.find(source)
        destination_parent = self.find(destination)
        self.parent[source_parent] = destination_parent

    def run_kruskal_algorithm(self):
        minimum_spanning_tree = []
        self.graph = sorted(self.graph, key=lambda item: item[2])
        for vertex in range(self.vertices):
            self.parent.append(vertex)
        index = 0
        while len(minimum_spanning_tree) < self.vertices - 1:
            source, destination, weight = self.graph[index]
            index += 1
            source_parent = self.find(source)
            destination_parent = self.find(destination)
            if source_parent != destination_parent:
                minimum_spanning_tree.append([source, destination, weight])
                self.union(source_parent, destination_parent)
        return minimum_spanning_tree
