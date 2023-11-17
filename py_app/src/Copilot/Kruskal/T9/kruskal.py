class Kruskal:
    def __init__(self, vertices):
        self.vertices = vertices
        self.edges = []

    def add_edge(self, source, destination, weight):
        self.edges.append((source, destination, weight))

    def run_kruskal_algorithm(self):
        self.edges = sorted(self.edges, key=lambda item: item[2])
        parent = []
        rank = []

        for node in range(self.vertices):
            parent.append(node)
            rank.append(0)

        minimum_spanning_tree = []
        index = 0

        while len(minimum_spanning_tree) < self.vertices - 1:
            source, destination, weight = self.edges[index]
            index = index + 1
            source_parent = self.find_parent(source, parent)
            destination_parent = self.find_parent(destination, parent)

            if source_parent != destination_parent:
                minimum_spanning_tree.append([source, destination, weight])
                self.union_nodes(source_parent, destination_parent, parent, rank)

        return minimum_spanning_tree

    def find_parent(self, vertex, parent):
        if parent[vertex] == vertex:
            return vertex
        return self.find_parent(parent[vertex], parent)

    def union_nodes(self, source_parent, destination_parent, parent, rank):
        if rank[source_parent] < rank[destination_parent]:
            parent[source_parent] = destination_parent
        elif rank[source_parent] > rank[destination_parent]:
            parent[destination_parent] = source_parent
        else:
            parent[destination_parent] = source_parent
            rank[source_parent] += 1
