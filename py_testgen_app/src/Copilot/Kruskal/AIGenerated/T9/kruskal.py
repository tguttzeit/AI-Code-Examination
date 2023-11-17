class Kruskal:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = []

    def add_edge(self, source, destination, weight):
        self.graph.append([source, destination, weight])

    def run_kruskal_algorithm(self):
        parent = []
        rank = []

        def find(i):
            if parent[i] == i:
                return i
            return find(parent[i])

        def union(i, j):
            iroot = find(i)
            jroot = find(j)
            if rank[iroot] < rank[jroot]:
                parent[iroot] = jroot
            elif rank[iroot] > rank[jroot]:
                parent[jroot] = iroot
            else:
                parent[jroot] = iroot
                rank[iroot] += 1

        self.graph = sorted(self.graph, key=lambda item: item[2])
        result = []
        i, e = 0, 0
        for node in range(self.vertices):
            parent.append(node)
            rank.append(0)
        while e < self.vertices - 1:
            u, v, w = self.graph[i]
            i += 1
            x = find(u)
            y = find(v)
            if x != y:
                e += 1
                result.append([u, v, w])
                union(x, y)
        return result
