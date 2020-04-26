package dijkstrasalgorithm;

public class GraphPathsDriver {

  public static void main(String[] args) {
    // Create vertices.

    Vertex A = new Vertex("A");
    Vertex B = new Vertex("B");
    Vertex C = new Vertex("C");
    // Store in an array of vertices
    Vertex[] vertices = new Vertex[3];
    vertices[0] = A;
    vertices[1] = B;
    vertices[2] = C;
    // Create edge weight matrix and use to create graph.
    int[][] distances = { { 0, 1, 3 }, { 1, 0, 1 }, { 3, 1, 0 } };
    GraphMatrix graph1 = new GraphMatrix(vertices, distances);
    // Print out graph for 20 points.
    System.out.println(graph1);
    graph1.Dijkstra(0);
    System.out.println(graph1);
    graph1.Dijkstra(1);
    graph1.Dijkstra(2);

    // Create vertices.
    Vertex A2 = new Vertex("A");
    Vertex B2 = new Vertex("B");
    Vertex C2 = new Vertex("C");
    Vertex D2 = new Vertex("D");
    Vertex E2 = new Vertex("E");
    // Store in an array of vertices
    Vertex[] vertices2 = new Vertex[5];
    vertices2[0] = A2;
    vertices2[1] = B2;
    vertices2[2] = C2;
    vertices2[3] = D2;
    vertices2[4] = E2;
    // Create edge weight matrix and use to create graph.
    int[][] distances2 = { { 0, 1, 3, 5, 1 }, { 1, 0, 1, 3, 2 }, { 3, 1, 0, 2, 3 }, { 5, 3, 2, 0, 4 },
        { 1, 2, 3, 4, 0 } };
    GraphMatrix graph2 = new GraphMatrix(vertices2, distances2);
    // Print out graph for 20 points.
    System.out.println(graph2);
    // Call Dijkstra with Vertex A index. Uncomment once implemented.
    // Test with more challenging graphs.
    graph2.Dijkstra(0);
    graph2.Dijkstra(2);
    graph2.Dijkstra(3);
    graph2.Dijkstra(4);

    // Create vertices.
    Vertex A3 = new Vertex("A");
    Vertex B3 = new Vertex("B");
    Vertex C3 = new Vertex("C");
    Vertex D3 = new Vertex("D");
    Vertex E3 = new Vertex("E");
    Vertex F3 = new Vertex("F");
    Vertex G3 = new Vertex("G");
    Vertex H3 = new Vertex("H");
    Vertex I3 = new Vertex("I");
    Vertex J3 = new Vertex("J");
    // Store in an array of vertices
    Vertex[] vertices3 = new Vertex[10];
    vertices3[0] = A3;
    vertices3[1] = B3;
    vertices3[2] = C3;
    vertices3[3] = D3;
    vertices3[4] = E3;
    vertices3[5] = F3;
    vertices3[6] = G3;
    vertices3[7] = H3;
    vertices3[8] = I3;
    vertices3[9] = J3;

    // Create edge weight matrix and use to create graph.

    int[][] distances3 = { { 0, 0, 0, 13, 15, 0, 0, 0, 8, 0 }, { 0, 0, 0, 0, 0, 0, 0,  0, 17, 0 },
                           { 0, 0, 0, 0, 0,  0, 0, 11, 5, 0 }, { 13, 0, 0, 0, 7, 10, 0, 4, 0, 0 }, 
                           { 15, 0, 0, 7, 0, 12, 0, 0, 9, 1 }, { 0, 0, 0, 10, 12, 0, 0, 2, 0, 6 }, 
                           { 0, 0, 0, 0,  0, 0, 0, 0, 0, 16 }, { 0, 0, 11, 4, 0, 2, 0, 0, 0, 14 },
                           { 8, 17, 5,  0, 9, 0, 0, 0, 0, 3 }, { 0, 0, 0, 0, 1, 6, 16, 14, 3, 0 }, };
    GraphMatrix graph3 = new GraphMatrix(vertices3, distances3);
    // Print out graph for 20 points.
    System.out.println(graph3);

    graph3.Dijkstra(0);
    graph3.Dijkstra(7);

  }

}
