public class MyUtils {
    public static void game369EX(int num) {
        String result = is369(num);
        System.out.println(num+result);
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
