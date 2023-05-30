public class Game369 {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.printf("%02d%s\n", i, is369(i));
        }
    }

    public static String playGame(int num) {
        String clapping = "";
        while (num > 0) {
            if (num % 10 == 3 || num % 10 == 6 || num % 10 == 9) {
                clapping += "*";
            }

            num /= 10;
        }

        return clapping;
    }

    public static String is369(int num) {
        int a = num / 10;
        int b = num % 10;
        String clapping = (b % 3 == 0 && b != 0) ? "*" : "";
        if (a == 0) {
            return clapping;
        }

        return clapping + is369(a);
    }
}
