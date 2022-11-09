package HW7;

import java.util.Scanner;

public class ExtendedEuclideanAlgorithm {
    // Given integers A and B with A>B>0, this algorithm computes gcd(A,B) and finds integers
    // s and t such that sA + tB = gcd(A,B), as well as the positive modular inverse

    public static int gcd(int a, int b){
        if (b != 0){
            int r = a%b;
            return gcd(b, r);
        }
        return a;
    }

    public static int positiveModInverse(int a, int n){
        if (gcd(a,n) != 1){
            System.out.println("ERROR: Inputs not valid");
            return 1;
        }
        return gcdExtended(a, n);
    }

    public static int gcdExtended(int a, int b){
        int olda = a;
        int oldb = b;
        int s = 1;
        int t = 0;
        int u = 0;
        int v = 1;

        /*
        Uncomment for table formatting
        -------------------------------
        System.out.println(" s\t\t t\t\t sA + tB");
        System.out.println(" " + s + "\t\t" + " " + t + "\t\t" + " " + ((s*a)+(t*b)));
         */

        while (b != 0){
            int r = a % b;
            int q = a/b;
            a = b;
            b = r;
            int newu = s-(u*q);
            int newv = t - (v*q);
            s = u;
            t = v;
            u = newu;
            v = newv;

            /*
            Uncomment for table
            --------------------
            if (s >= 0){
                System.out.print(" " + s + "\t\t");
            }
            else if(s < 0){
                System.out.print(s + "\t\t");
            }
            if (t >= 0){
                System.out.print(" " + t + "\t\t");
            }
            else if (t < 0){
                System.out.print(t + "\t\t");
            }
            if (((s*olda)+(t*oldb)) >= 0){
                System.out.println(" " + ((s*olda)+(t*oldb)));
            }
            else if (((s*olda)+(t*oldb)) < 0){
                System.out.println(((s*olda)+(t*oldb)));
            }
             */
        }
        return s;

    }

    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer greater than 0: ");
        int a = Integer.parseInt(input.nextLine());

        System.out.print("Enter an second integer greater than 0 and less than the first: ");
        int b = Integer.parseInt(input.nextLine());

        System.out.println("Smallest positive modular inverse = " + positiveModInverse(a, b));
    }
}
