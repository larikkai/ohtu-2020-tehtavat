
package ohtu.kivipaperisakset.io;

import java.util.Scanner;

public class ConsoleIO implements IO {
    
    private final Scanner scanner = new Scanner(System.in);

    public void print(String print) {
        System.out.println(print);
    }

    public String read() {
        return scanner.nextLine();
    }

    public String readLine(String string) {
        System.out.println(string);
        return scanner.nextLine();
    }
    
}
