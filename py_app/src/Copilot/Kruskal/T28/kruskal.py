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

    def apply_union(self, parent, rank, x, y):
        x_parent = self.find_parent(parent, x)
        y_parent = self.find_parent(parent, y)

        if rank[x_parent] < rank[y_parent]:
            parent[x_parent] = y_parent
        elif rank[x_parent] > rank[y_parent]:
            parent[y_parent] = x_parent
        else:
            parent[y_parent] = x_parent
            rank[x_parent] += 1

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
            x = self.find_parent(parent, source)
            y = self.find_parent(parent, destination)

            if x != y:
                e += 1
                result.append([source, destination, weight])
                self.apply_union(parent, rank, x, y)
        return result
