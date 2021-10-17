package homeworks.second;

public class MySort {

    public static void main(String[] args) {

        Notebook[] notebooks = {
                new Notebook(2500, 4, "Lenuvo"),
                new Notebook(2500, 4, "MacNote"),
                new Notebook(2500, 4, "Xamiou"),
                new Notebook(2500, 4, "Asos"),
                new Notebook(2500, 12, "Asos"),
                new Notebook(2500, 16, "MacNote"),
                new Notebook(2500, 20, "Eser"),
                new Notebook(2500, 24, "Xamiou"),
                new Notebook(2500, 4, "Lenuvo"),
                new Notebook(2500, 4, "Asos"),
                new Notebook(2500, 4, "MacNote"),
                new Notebook(2500, 12, "Eser"),
                new Notebook(2500, 12, "Xamiou"),
                new Notebook(500, 4, "Lenuvo"),
                new Notebook(500, 12, "Asos"),
                new Notebook(500, 16, "Asos"),
                new Notebook(500, 20, "Asos"),
                new Notebook(500, 16, "MacNote"),
                new Notebook(400, 20, "Eser"),
                new Notebook(500, 24, "Xamiou"),
                new Notebook(500, 4, "Lenuvo"),
                new Notebook(850, 12, "Asos"),
                new Notebook(500, 16, "MacNote"),
                new Notebook(1000, 20, "Eser"),
                new Notebook(500, 24, "Xamiou"),
                new Notebook(2500, 12, "Xamiou"),
                new Notebook(500, 4, "Lenuvo"),
                new Notebook(1220, 12, "Asos"),
                new Notebook(1100, 16, "Asos"),
                new Notebook(500, 20, "Asos"),
                new Notebook(600, 16, "MacNote"),
                new Notebook(500, 20, "Eser"),
                new Notebook(700, 24, "Xamiou"),
                new Notebook(800, 4, "Lenuvo"),
                new Notebook(900, 12, "Asos"),        };

        sortInsertObj(notebooks);

        for (Notebook n : notebooks) {
            System.out.println(n.toString());
        }
    }

    public static void sortInsertObj(Notebook[] notebooks) {
        int in, out;
        for (out = 1; out < notebooks.length; out++) {
            Notebook temp = notebooks[out];
            in = out;
            while (in > 0 && !notebooks[in-1].compareTo(temp)) {
                notebooks[in] = notebooks[in-1];
                --in;
            }
            notebooks[in] = temp;
        }
    }
}

