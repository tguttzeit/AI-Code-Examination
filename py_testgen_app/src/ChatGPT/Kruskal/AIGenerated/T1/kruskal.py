class Kruskal:
    def __init__(self, vertices):
        self.vertices = vertices
        self.edges = []

    def add_edge(self, source, destination, weight):
        self.edges.append((source, destination, weight))

    def run_kruskal_algorithm(self):
        # Helper function to find the root of a set (connected component)
        def find_root(parent, node):
            if parent[node] == node:
                return node
            parent[node] = find_root(parent, parent[node])
            return parent[node]

        # Initialize parent and result lists
        parent = list(range(self.vertices))
        minimal_spanning_tree = []

        # Sort edges by weight in ascending order
        self.edges.sort(key=lambda edge: edge[2])

        for edge in self.edges:
            source, destination, weight = edge
            root_source = find_root(parent, source)
            root_destination = find_root(parent, destination)

            # If adding this edge doesn't create a cycle, add it to the MST
            if root_source != root_destination:
                minimal_spanning_tree.append(edge)
                parent[root_source] = root_destination

        return minimal_spanning_tree
