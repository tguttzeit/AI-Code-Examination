import heapq

class Dijkstra:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = {}
    
    def add_edge(self, source, destination, weight):
        if source not in self.graph:
            self.graph[source] = []
        self.graph[source].append((destination, weight))
    
    def find_shortest_paths(self, source):
        distance = {vertex: float('infinity') for vertex in range(1, self.vertices + 1)}
        distance[source] = 0
        priority_queue = [(0, source)]
        shortest_paths = {}

        while priority_queue:
            current_distance, current_vertex = heapq.heappop(priority_queue)

            if current_distance > distance[current_vertex]:
                continue

            for neighbor, weight in self.graph.get(current_vertex, []):
                distance_to_neighbor = current_distance + weight

                if distance_to_neighbor < distance[neighbor]:
                    distance[neighbor] = distance_to_neighbor
                    heapq.heappush(priority_queue, (distance_to_neighbor, neighbor))
                    shortest_paths[neighbor] = current_vertex

        # Build the shortest path dictionary
        shortest_path_dict = {}
        for vertex in range(1, self.vertices + 1):
            if vertex != source:
                if vertex in shortest_paths:
                    path = []
                    current_vertex = vertex
                    while current_vertex != source:
                        path.insert(0, current_vertex)
                        current_vertex = shortest_paths[current_vertex]
                    path.insert(0, source)
                    shortest_path_dict[vertex] = {
                        'path': path,
                        'distance': distance[vertex]
                    }

        return shortest_path_dict
