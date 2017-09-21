public class Vertex {
    private String name;
    private int label;
    private int x,y;
    private boolean isVisited;

    public void setLabel(int label) {
        this.label = label;
    }

    public int getLabel() {

        return label;
    }

    public Vertex (String name, int label, int x, int y){
        this.name = name;
        this.label = label;

        this.isVisited = false;
        this.x = x;
        this.y = y;
    }
    public Vertex (String name, int x, int y){
        this.name = name;
        this.label = Integer.MAX_VALUE;

        this.isVisited = false;
        this.x = x;
        this.y = y;
    }
    public Vertex (int label){

        this.label = label;

        this.isVisited = false;

    }
    public Vertex (){

        this.label = Integer.MAX_VALUE;

        this.isVisited = false;

    }

    public String getName() {
        return name;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
