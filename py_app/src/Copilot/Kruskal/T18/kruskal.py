class Kruskal:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = []
        self.result = []

    def add_edge(self, source, destination, weight):
        self.graph.append([source, destination, weight])

    def find_parent(self, parent, i):
        if parent[i] == i:
            return i
        return self.find_parent(parent, parent[i])

    def union(self, parent, rank, x, y):
        root_x = self.find_parent(parent, x)
        root_y = self.find_parent(parent, y)

        if rank[root_x] < rank[root_y]:
            parent[root_x] = root_y
        elif rank[root_x] > rank[root_y]:
            parent[root_y] = root_x
        else:
            parent[root_y] = root_x
            rank[root_x] += 1

    def run_kruskal_algorithm(self):
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
            root_x = self.find_parent(parent, source)
            root_y = self.find_parent(parent, destination)

            if root_x != root_y:
                e += 1
                self.result.append([source, destination, weight])
                self.union(parent, rank, root_x, root_y)
        return self.result
