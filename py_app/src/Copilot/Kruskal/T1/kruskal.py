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

    def union(self, parent, rank, x, y):
        parent_x = self.find_parent(parent, x)
        parent_y = self.find_parent(parent, y)
        if rank[parent_x] < rank[parent_y]:
            parent[parent_x] = parent_y
        elif rank[parent_x] > rank[parent_y]:
            parent[parent_y] = parent_x
        else:
            parent[parent_y] = parent_x
            rank[parent_x] += 1

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
            parent_source = self.find_parent(parent, source)
            parent_destination = self.find_parent(parent, destination)
            if parent_source != parent_destination:
                e += 1
                result.append([source, destination, weight])
                self.union(parent, rank, parent_source, parent_destination)
        return result
