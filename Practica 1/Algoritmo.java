public class Algoritmo {
    public Algoritmo() {
    }

    public static synchronized int expr(int x, int n) {
        if (n == 0) {
            return 1;
        } else {
            return (x / (expr(x, n - 1))) + (expr(x, n - 1));
        }
    }

    public static void fact(long n) {
        for (int i = 0; i < n; i++) {
            fact(n - 1);
        }
    }

    public static void f(long var0) {
        long var2 = 0L;
        int comp = 3; // 0 -> 1 | 1 -> log n | 2 -> n | 3 -> n long n
                      // 4 -> n2 | 5 -> n3 | 6 -> 2^n | 7 -> m!

        switch (comp) {
            case 0:
                for (int i = 0; i < 100000000; i++)
                    var2++;
                break;
            case 1:
                long c = 1;
                while (c < var0) {
                    c = 2 * c;
                }
                break;
            case 2:
                for (long var4 = 0; (long) var4 < var0; var4++) {
                    var2++;
                }
                break;
            case 3:
                long c2 = 1;
                for (long var4 = 0; (long) var4 < var0; var4++) {
                    while (c2 < var0) {
                        c2 = 2 * c2;
                    }
                    var2++;
                }
                break;
            case 4:
                for (long var4 = 0; (long) var4 < var0; var4++) {
                    for (long var5 = 0; (long) var5 < var0; var5++) {
                        var2++;
                    }
                }
                break;
            case 5:
                for (long var4 = 0; (long) var4 < var0; var4++) {
                    for (long var5 = 0; (long) var5 < var0; var5++) {
                        for (long var6 = 0; (long) var6 < var0; var6++) {
                            var2++;
                        }
                    }
                }
                break;
            case 6:
                expr(500, (int) var0);
                break;
            case 7:
                fact(var0);
                break;
            default:
                break;
        }
    }
}