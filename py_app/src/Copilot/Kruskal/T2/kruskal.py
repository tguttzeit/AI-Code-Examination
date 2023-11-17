class Kruskal:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = []
        self.parent = []
        self.rank = []

    def add_edge(self, source, destination, weight):
        self.graph.append([source, destination, weight])

    def run_kruskal_algorithm(self):
        self.graph = sorted(self.graph, key=lambda item: item[2])
        for node in range(self.vertices):
            self.parent.append(node)
            self.rank.append(0)
        self.minimal_spanning_tree = []
        index = 0
        while len(self.minimal_spanning_tree) < self.vertices - 1:
            source, destination, weight = self.graph[index]
            index += 1
            x = self.find(source)
            y = self.find(destination)
            if x != y:
                self.minimal_spanning_tree.append([source, destination, weight])
                self.union(x, y)
        return self.minimal_spanning_tree

    def find(self, node):
        if self.parent[node] == node:
            return node
        else:
            self.parent[node] = self.find(self.parent[node])
            return self.parent[node]

    def union(self, source, destination):
        if self.rank[source] < self.rank[destination]:
            self.parent[source] = destination
        elif self.rank[source] > self.rank[destination]:
            self.parent[destination] = source
        else:
            self.parent[destination] = source
            self.rank[source] += 1

