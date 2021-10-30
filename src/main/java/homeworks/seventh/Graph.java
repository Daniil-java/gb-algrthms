package homeworks.seventh;

public interface Graph {

    void addVertex(String label);

    boolean addEdge(String startLabel, String secondLabel, String... others);
    boolean addEdge(String startLabel, String secondLabel);

    boolean addEdge(String startLabel, String secondLabel, int distance);

    int getSize();

    void display();


    void dfs(String startLabel);

    void toFindShortWay(String startLabel, String finishLabel);


    void bfs(String startLabel);

}
