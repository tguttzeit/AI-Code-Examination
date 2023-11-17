class Kruskal:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = []

    def add_edge(self, source, destination, weight):
        self.graph.append((source, destination, weight))

    def find(self, parent, node):
        if parent[node] == node:
            return node
        return self.find(parent, parent[node])

    def union(self, parent, rank, x, y):
        x_root = self.find(parent, x)
        y_root = self.find(parent, y)

        if rank[x_root] < rank[y_root]:
            parent[x_root] = y_root
        elif rank[x_root] > rank[y_root]:
            parent[y_root] = x_root
        else:
            parent[y_root] = x_root
            rank[x_root] += 1

    def run_kruskal_algorithm(self):
        self.graph = sorted(self.graph, key=lambda item: item[2])
        parent = []
        rank = []
        mst = []

        for node in range(self.vertices):
            parent.append(node)
            rank.append(0)

        i = 0
        while len(mst) < self.vertices - 1:
            source, destination, weight = self.graph[i]
            i += 1
            x = self.find(parent, source)
            y = self.find(parent, destination)

            if x != y:
                mst.append((source, destination, weight))
                self.union(parent, rank, x, y)

        return mst
