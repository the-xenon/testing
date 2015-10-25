package xenon.webdriver.test;

/**
 * Created by xenon on 17.10.2015.
 */
public class test {
    public static void main(String[] args) {
        bookTest();
        //rivTest();
    }

    private static void bookTest() {
        (new BookTest()).start();
    }

    private static void rivTest() {
        //ITestStarter starter = new RivTest();
        ITestStarter starter = new BetaRivTest();
        starter.start();
    }

    private static void ArellMobileTest() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    if (k % 5 != 0) {
                        int num = k + j * 10 + i * 100;
                        if ((i + j + k) < 10 && num % 3 == 0) {
                            System.out.print(num + " ");
                        }
                    }
                }
            }
        }
        System.out.println("");

        for (int i = 0; i <= 1000; i++) {
            int j = i, sum = 0;
            do {
                sum += j % 10;
            } while ((j = j / 10) > 0);
            if (sum < 10 && i % 3 == 0 && i % 5 != 0) {
                System.out.print(i + " ");
            }
        }

        System.out.println("");

        for (int i = 0; i <= 1000; i += 3) {
            int j = i, sum = 0;
            do {
                sum += j % 10;
            } while ((j = j / 10) > 0);
            if (sum < 10 && i % 5 != 0) {
                System.out.print(i + " ");
            }
        }

        System.out.println("");

        final byte digitsCount = 4;
        byte[] digits = new byte[digitsCount];
        byte lastDigit = 0;
        do {
            if (digits[0] != 0 && digits[0] != 5) {
                int sum = digits[0];
                for (byte i = 1; i <= lastDigit; i++) {
                    sum += digits[i];
                }
                if (sum < 10) {
                    for (byte i = lastDigit; i >= 0; i--) {
                        System.out.print(digits[i]);
                    }
                    System.out.print(" ");
                }
            }

            digits[0] += 3;
            if (digits[0] >= 10) {
                digits[0] -= 10;
                byte i = 1;
                while (++digits[i] >= 10) {
                    digits[i] = 0;
                    i++;
                }
                if (i > lastDigit) {
                    lastDigit = i;
                }
            }

        } while (digits[3] != 1);
    }
}
