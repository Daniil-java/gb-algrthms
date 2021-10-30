package homeworks.seventh;

public class Main {

    public static void main(String[] args) {
        toFindShortWay();
    }

    private static void toFindShortWay() {
        Graph graph = new GraphImpl(32);
        graph.addVertex("Москва");
        graph.addVertex("Тула");
        graph.addVertex("Липецк");
        graph.addVertex("Воронеж");
        graph.addVertex("Рязань");
        graph.addVertex("Тамбов");
        graph.addVertex("Саратов");
        graph.addVertex("Калуга");
        graph.addVertex("Орёл");
        graph.addVertex("Курск");

        graph.addEdge("Москва", "Рязань", 200);
        graph.addEdge("Москва", "Калуга", 196);
        graph.addEdge("Москва", "Тула", 182);
        graph.addEdge("Тула", "Липецк", 293);
        graph.addEdge("Липецк", "Воронеж", 134);
        graph.addEdge("Рязань", "Тамбов", 291);
        graph.addEdge("Тамбов", "Саратов", 385);
        graph.addEdge("Саратов", "Воронеж", 513);
        graph.addEdge("Калуга", "Орёл", 210);
        graph.addEdge("Орёл", "Курск", 161);
        graph.addEdge("Курск", "Воронеж", 223);

        graph.toFindShortWay("Москва", "Воронеж");
    }
}
