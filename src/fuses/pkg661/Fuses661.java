package fuses.pkg661;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Fuses661 {

    public static void main(String[] args) {
        
        Scanner input =null;
        try{input=new Scanner(Paths.get("/home/habi/Desktop/input.in"));}
        catch(IOException io){System.out.println("io");}
        int n = input.nextInt(), m = input.nextInt(), c = input.nextInt();
        int num = 1;

        while (!(n == 0 && c == 0 && m == 0)) {
            int[] consu = new int[n];
            boolean[] sat = new boolean[n];
            for (int i = 0; i < n; i++) {
                consu[i] = input.nextInt();
            }
            int max = 0;
            int total = 0;
            for (int i = 0; i < m; i++) {
                int temp = input.nextInt() - 1;
                if (sat[temp]) {
                    sat[temp] = false;
                    total -= consu[temp];
                } else {

                    sat[temp] = true;
                    total += consu[temp];
                    if (total > c) {
                        break;
                    }
                    if (max < total) {
                        max = total;
                    }
                }

            }
            if (total > c) {
                System.out.println("Sequene " + num + "\n Fuse was blown.\n");
            } else {
                System.out.println("Sequene " + num + "\n Fuse was not blown.\n" + "Maximal power onsumption was " + max + " amperes.\n");
            }

            num++;
            n = input.nextInt();
            m = input.nextInt();
            c = input.nextInt();

        }

    }

}
