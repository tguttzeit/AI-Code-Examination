class Kruskal:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = []

    def add_edge(self, source, destination, weight):
        self.graph.append((source, destination, weight))

    def find(self, parent, vertex):
        if parent[vertex] == vertex:
            return vertex
        return self.find(parent, parent[vertex])

    def union(self, parent, rank, x, y):
        root_x = self.find(parent, x)
        root_y = self.find(parent, y)

        if rank[root_x] < rank[root_y]:
            parent[root_x] = root_y
        elif rank[root_x] > rank[root_y]:
            parent[root_y] = root_x
        else:
            parent[root_y] = root_x
            rank[root_x] += 1

    def run_kruskal_algorithm(self):
        result = []
        self.graph = sorted(self.graph, key=lambda item: item[2])
        parent = [i for i in range(self.vertices)]
        rank = [0] * self.vertices
        edge_count = 0
        index = 0

        while edge_count < self.vertices - 1:
            source, destination, weight = self.graph[index]
            index += 1
            root_source = self.find(parent, source)
            root_destination = self.find(parent, destination)

            if root_source != root_destination:
                edge_count += 1
                result.append((source, destination, weight))
                self.union(parent, rank, root_source, root_destination)

        return result
