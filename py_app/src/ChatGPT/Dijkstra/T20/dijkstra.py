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
        # Initialize distances to all nodes as infinity except the source node.
        distances = {vertex: float('infinity') for vertex in range(1, self.vertices + 1)}
        distances[source] = 0

        # Priority queue to store vertices to be processed.
        priority_queue = [(0, source)]

        while priority_queue:
            current_distance, current_vertex = heapq.heappop(priority_queue)

            # Skip this node if we've already processed it with a shorter distance.
            if current_distance > distances[current_vertex]:
                continue

            # Visit neighbors of the current vertex.
            if current_vertex in self.graph:
                for neighbor, weight in self.graph[current_vertex]:
                    distance = current_distance + weight

                    # If a shorter path is found, update the distance.
                    if distance < distances[neighbor]:
                        distances[neighbor] = distance
                        heapq.heappush(priority_queue, (distance, neighbor))

        # Remove nodes with infinite distances (no path).
        shortest_paths = {vertex: distance for vertex, distance in distances.items() if distance != float('infinity')}
        return shortest_paths
