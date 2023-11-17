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
        # Initialize distances to all vertices as infinite and the source as 0.
        distances = {vertex: float('inf') for vertex in range(1, self.vertices + 1)}
        distances[source] = 0

        # Initialize the priority queue with the source node.
        priority_queue = [(0, source)]

        # Initialize the result dictionary.
        shortest_paths = {}

        while priority_queue:
            # Get the vertex with the smallest distance.
            current_distance, current_vertex = heapq.heappop(priority_queue)

            # If the current distance is greater than the stored distance, skip it.
            if current_distance > distances[current_vertex]:
                continue

            # Store the shortest path to the current vertex.
            shortest_paths[current_vertex] = current_distance

            # Explore neighbors of the current vertex.
            if current_vertex in self.graph:
                for neighbor, weight in self.graph[current_vertex]:
                    distance = current_distance + weight

                    # If this path is shorter, update the distance and add to the priority queue.
                    if distance < distances[neighbor]:
                        distances[neighbor] = distance
                        heapq.heappush(priority_queue, (distance, neighbor))

        # Remove the source vertex from the result.
        shortest_paths.pop(source, None)

        # Filter out vertices with infinite distance (unreachable).
        shortest_paths = {vertex: distance for vertex, distance in shortest_paths.items() if distance != float('inf')}
        
        return shortest_paths
