class Kruskal:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = []

    def add_edge(self, source, destination, weight):
        self.graph.append([source, destination, weight])

    def run_kruskal_algorithm(self):
        self.graph.sort(key=lambda item: item[2])
        parent = []
        rank = []

        for node in range(self.vertices):
            parent.append(node)
            rank.append(0)

        minimum_spanning_tree = []
        index = 0

        while len(minimum_spanning_tree) < self.vertices - 1:
            source, destination, weight = self.graph[index]
            index += 1
            source_parent = self.find(parent, source)
            destination_parent = self.find(parent, destination)

            if source_parent != destination_parent:
                minimum_spanning_tree.append([source, destination, weight])
                self.union(parent, rank, source_parent, destination_parent)

        return minimum_spanning_tree

    def find(self, parent, node):
        if parent[node] == node:
            return node
        return self.find(parent, parent[node])

    def union(self, parent, rank, source_parent, destination_parent):
        if rank[source_parent] < rank[destination_parent]:
            parent[source_parent] = destination_parent
        elif rank[source_parent] > rank[destination_parent]:
            parent[destination_parent] = source_parent
        else:
            parent[destination_parent] = source_parent
            rank[source_parent] += 1
