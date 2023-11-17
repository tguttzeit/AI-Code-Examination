
class Kruskal:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = []
        self.graph_dict = {}

    def add_edge(self, source, destination, weight):
        self.graph.append([source, destination, weight])
        self.graph_dict[(source, destination)] = weight

    def run_kruskal_algorithm(self):
        self.graph.sort(key=lambda x: x[2])
        visited = set()
        mst = []
        for edge in self.graph:
            if len(visited) == self.vertices:
                break
            if edge[0] not in visited or edge[1] not in visited:
                visited.add(edge[0])
                visited.add(edge[1])
                mst.append(edge)
        return mst
