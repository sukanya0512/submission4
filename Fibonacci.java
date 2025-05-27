public class Fibonacci {

    public static void generateFibonacci(int n) {
        System.out.println("Fibonacci Series up to " + n + " terms:");
        int first = 0, second = 1;

        for (int i = 1; i <= n; ++i) {
            System.out.print(first + " ");
            int next = first + second;
            first = second;
            second = next;
        }
    }
    public static void main (String[] args) {
        int numberOfTerms = 10;  
        generateFibonacci(numberOfTerms);
    }
}
