# Source: https://www.techiedelight.com/kruskals-algorithm-for-finding-minimum-spanning-tree/

class Kruskal:

    def __init__(self, vertices):
        self.edges = []
        self.vertices = vertices
    
    def add_edge(self, source, destination, weight):
        self.edges.append((source, destination, weight))

    # Function to construct MST using Kruskal’s algorithm
    def run_kruskal_algorithm(self):
        # stores the edges present in MST
        mst = list()

        # Initialize `DisjointSet` class.
        # Create a singleton set for each element of the universe.
        ds = self.DisjointSet()
        ds.make_set(self.vertices)

        index = 0

        # sort edges by increasing weight
        self.edges.sort(key=lambda x: x[2])

        # MST contains exactly `number_of_nodes -1` edges
        while len(mst) != self.vertices - 1:

            # consider the next edge with minimum weight from the graph
            (src, dest, weight) = self.edges[index]
            index = index + 1

            # find the root of the sets to which two endpoints
            # vertices of the next edge belongs
            x = ds.find(src)
            y = ds.find(dest)

            # if both endpoints have different parents, they belong to
            # different connected components and can be included in MST
            if x != y:
                mst.append((src, dest, weight))
                ds.union(x, y)

        return mst

    class DisjointSet:
        parent = {}

        # perform MakeSet operation
        def make_set(self, number_of_nodes):
            # create disjoint sets (one for each vertex)
            for i in range(number_of_nodes):
                self.parent[i] = i

        # Find the root of the set in which element `k` belongs
        def find(self, k):
            # if `k` is root
            if self.parent[k] == k:
                return k

            # recur for the parent until we find the root
            return self.find(self.parent[k])

        # Perform Union of two subsets
        def union(self, a, b):
            # find the root of the sets in which elements `x` and `y` belongs
            x = self.find(a)
            y = self.find(b)

            self.parent[x] = y
