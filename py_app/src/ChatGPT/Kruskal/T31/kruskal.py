class Kruskal:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = []

    def add_edge(self, source, destination, weight):
        self.graph.append((source, destination, weight))

    def find_parent(self, parent, node):
        if parent[node] == node:
            return node
        return self.find_parent(parent, parent[node])

    def union(self, parent, rank, src, dest):
        root_src = self.find_parent(parent, src)
        root_dest = self.find_parent(parent, dest)

        if rank[root_src] < rank[root_dest]:
            parent[root_src] = root_dest
        elif rank[root_src] > rank[root_dest]:
            parent[root_dest] = root_src
        else:
            parent[root_dest] = root_src
            rank[root_src] += 1

    def run_kruskal_algorithm(self):
        result = []
        self.graph = sorted(self.graph, key=lambda item: item[2])
        parent = []
        rank = []

        for node in range(self.vertices):
            parent.append(node)
            rank.append(0)

        i = 0
        edge_count = 0
        while edge_count < self.vertices - 1:
            source, destination, weight = self.graph[i]
            i += 1
            root_source = self.find_parent(parent, source)
            root_destination = self.find_parent(parent, destination)

            if root_source != root_destination:
                edge_count += 1
                result.append((source, destination, weight))
                self.union(parent, rank, root_source, root_destination)

        return result
