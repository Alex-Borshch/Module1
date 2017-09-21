public class Map {


    private Vertex[] vertexList;
    private int vertexCount;
    private int[][] matrix;

    public Map() {

        Reader reader = new Reader();
        int matrixSize = reader.getMatrixSize();
        matrix = new int[matrixSize][matrixSize];
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = 0;
            }
        }
        vertexCount = 0;
        vertexList = new Vertex[matrixSize];

    }

    public void addVertex(String name, int label, int x, int y) {
        vertexList[vertexCount++] = new Vertex(name, label, x, y);
    }
    public void addVertex(int label) {
        vertexList[vertexCount++] = new Vertex(label);
    }
    public void addVertex() {
        vertexList[vertexCount++] = new Vertex();
    }


    public void addEdge(int begin, int end, int weight) {
        matrix[begin][end] = weight;
        matrix[end][begin] = weight;
    }

    private int calcWeight(int begin, int end) {
        return ((vertexList[begin].getX() - vertexList[end].getX()) ^ 2 + (vertexList[begin].getY() - vertexList[end].getY()) ^ 2) ^ 1 / 2;
    }

    public void algorithm() {
        for (int i = 0; i < matrix.length; i ++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] != 0 && !vertexList[j].isVisited()) {
                    if (matrix[i][j] + vertexList[i].getLabel() < vertexList[j].getLabel()) {
                        vertexList[j].setLabel(vertexList[i].getLabel() + matrix[i][j]);
                    }
                }
            }
            vertexList[i].setVisited(true);
        }


    }



}
