public class Main {
    public static final String input = "ABCDEFGHIJKLMNOUPRSTUWXYZabcdefghijklmnouprstuwxyz";

    public static void main(String[] args) {
        long startTimeStream = System.nanoTime();
        String reversedWithStream = reverseStringWithStream();
        long stopTimeStream = System.nanoTime();
        System.out.println(stopTimeStream - startTimeStream + " result with stream: " + reversedWithStream);

        long startTimeLoop = System.nanoTime();
        String reversedWithLoop = reversedWithLoop();
        long stopTimeLoop = System.nanoTime();
        System.out.println(stopTimeLoop - startTimeLoop + " result with loop: " + reversedWithLoop);

        long startTimeRecursion = System.nanoTime();
        String reversedWithRecursion = reversedWithRecursion(input, input.length()-1);
        long stopTimeRecursion = System.nanoTime();
        System.out.println(stopTimeRecursion - startTimeRecursion + " result with recursion: " + reversedWithRecursion);

        long startTimeStringBuilder = System.nanoTime();
        String reversedWithStringBuilder = reversedWithStringBuilder();
        long stopTimeStringBuilder = System.nanoTime();
        System.out.println(stopTimeStringBuilder - startTimeStringBuilder + " result with StringBuilder: " + reversedWithStringBuilder);
    }

    private static String reversedWithRecursion(String stringToReverse, int index) {
        if (index == 0) {
            return String.valueOf(stringToReverse.charAt(0));
        }
        char letter = stringToReverse.charAt(index);
        return letter + reversedWithRecursion(stringToReverse, index - 1);
    }

    private static String reversedWithLoop() {
        String result = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            result = result + input.charAt(i);
        }
        return result;
    }

    private static String reversedWithStringBuilder() {
        return new StringBuilder(input).reverse().toString();
    }

    private static String reverseStringWithStream() {
        return input.chars()
                .mapToObj(x -> (char) x)
                .reduce("", (a, x) -> x + a, (s1, s2) -> s2 + s1);
    }
}
