package homeworks.seventh;

import java.util.*;

public class GraphImpl implements Graph {
    private final List<Vertex> vertexList;
    private final boolean[][] adjMatrix;
    private final int[][] intAdjMatrix;

    public GraphImpl(int maxVertexCount) {
        this.vertexList = new ArrayList<>(maxVertexCount);
        this.adjMatrix = new boolean[maxVertexCount][maxVertexCount];
        this.intAdjMatrix = new int[maxVertexCount][maxVertexCount];
    }

    @Override
    public void addVertex(String label) {
        vertexList.add(new Vertex(label));
    }

    @Override
    public boolean addEdge(String startLabel, String secondLabel) {
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(secondLabel);

        if (startIndex == -1 || endIndex == -1) {
            return false;
        }

        adjMatrix[startIndex][endIndex] = true;
        return true;
    }

    private int indexOf(String label) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexList.get(i).getLabel().equals(label)) {
                return i;
            }
        }
        return -1;
    }


    @Override
    public boolean addEdge(String startLabel, String secondLabel, String... others) {
        boolean result = addEdge(startLabel, secondLabel);

        for (String other : others) {
            result &= addEdge(startLabel, other);
        }

        return result;
    }

    @Override
    public boolean addEdge(String startLabel, String secondLabel, int distance) {
        addEdge(startLabel, secondLabel);
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(secondLabel);

        if (startIndex == -1 || endIndex == -1) {
            return false;
        }

        intAdjMatrix[startIndex][endIndex] = distance;
        return true;
    }

    @Override
    public int getSize() {
        return vertexList.size();
    }

    @Override
    public void display() {
        for (int i = 0; i < getSize(); i++) {
            System.out.print(vertexList.get(i));
            for (int j = 0; j < getSize(); j++) {
                if (adjMatrix[i][j]) {
                    System.out.print(" -> " + vertexList.get(j));
                }
            }
            System.out.println();
        }
    }

    @Override
    public void dfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Неверная вершина: " + startLabel);
        }

        Stack<Vertex> stack = new Stack<>();
        Vertex vertex = vertexList.get(startIndex);

        visitedVertex(stack, vertex);
        while (!stack.isEmpty()) {
            vertex = getNearUnvisitedVertex(stack.peek());
            if (vertex != null) {
                visitedVertex(stack, vertex);
            } else {
                stack.pop();
            }
        }
        System.out.println();
    }

    @Override
    public void toFindShortWay(String startLabel, String finishLabel) {
        int startIndex = indexOf(startLabel);
        int finishIndex = indexOf(finishLabel);
        if (startIndex == -1 || finishIndex == -1) {
            throw new IllegalArgumentException("Неверная вершина");
        }
        Stack<Vertex> stack = new Stack<>();
        Vertex vertex = vertexList.get(startIndex);
        visitedVertex(stack, vertex);
        int temp = startIndex;
        int temp1 = 0;
        int result = 100000;
        List<String> wayList = new ArrayList<>();
        List<String> tempList = new ArrayList<>();
        while (!stack.isEmpty()) {
            vertex = getNearUnvisitedVertex(stack.peek());
            if (vertex != null) {
                if (stack.size() == 1) {
                    temp1 = 0;
                    temp = startIndex;
                    setVisitedFalse(finishLabel);
                    tempList.clear();
                }
                visitedVertex(stack, vertex);
                temp1 += getDistance(temp, indexOf(vertex.getLabel()));
                temp = indexOf(vertex.getLabel());
                tempList.add(vertex.getLabel());
            } else {
                if (temp1 < result && temp1 != 0) {
                    result = temp1;
                    wayList.addAll(tempList);
                }
                stack.pop();
            }
        }

        System.out.println("Самый короткий путь от города " + startLabel + ": " + wayList.toString() + " - " + result + " км.");
    }

    private void setVisitedFalse(String label) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexList.get(i).getLabel().equals(label)) {
                vertexList.get(i).setVisited(false);
            }
        }
    }

    private int getDistance(int startIndex, int finishIndex) {
        return intAdjMatrix[startIndex][finishIndex];
    }

    private int getDistance(String startLabel, String finishLabel) {
        int startIndex = indexOf(startLabel);
        int finishIndex = indexOf(finishLabel);

        if (startIndex == -1 || finishIndex == -1) {
            throw new IllegalArgumentException("Неверная вершина");
        }

        return intAdjMatrix[startIndex][finishIndex];
    }


    private Vertex getNearUnvisitedVertex(Vertex vertex) {
        int currentIndex = vertexList.indexOf(vertex);
        for (int i = 0; i < getSize(); i++) {
            if (adjMatrix[currentIndex][i] && !vertexList.get(i).isVisited()) {
                return vertexList.get(i);
            }
        }
        return null;
    }

    private void visitedVertex(Stack<Vertex> stack, Vertex vertex) {
//        System.out.print(vertex.getLabel() + " ");
        stack.add(vertex);
        vertex.setVisited(true);
    }

//    private void visitedVertex(Stack<Vertex> stack, Vertex vertex, String label) {
//        System.out.print(vertex.getLabel() + " ");
//        stack.add(vertex);
//        if (vertex.getLabel() != label) {
//            vertex.setVisited(true);
//        }
//    }


    private void visitedVertex(Queue<Vertex> queue, Vertex vertex) {
        System.out.print(vertex.getLabel() + " ");
        queue.add(vertex);
        vertex.setVisited(true);
    }

    @Override
    public void bfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Неверная вершина: " + startLabel);
        }

        Queue<Vertex> queue = new LinkedList<>();
        Vertex vertex = vertexList.get(startIndex);

        visitedVertex(queue, vertex);
        while (!queue.isEmpty()) {
            vertex = getNearUnvisitedVertex(queue.peek());
            if (vertex != null) {
                visitedVertex(queue, vertex);
            } else {
                queue.remove();
            }
        }
        System.out.println();
    }

}
