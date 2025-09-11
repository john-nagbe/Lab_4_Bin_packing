package Lab_4_Bin_packing;

//import java.util.ArrayList;
//import java.util.Stack;
import java.util.*;
import java.util.Scanner;

public class BinpackingFFD {

    System.out.println("Bin - Packing Algorithm IS object(First Fit Decreasing)");System.out.println("Enter the number of items in set");

    public static void main() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Enter" + n + "items:");
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        System.out.println("Enter the bin size:");
        int size = sc.nextInt();
        int[] sequence = sort(a);
        binPacking(sequence, size, n);
        sc.close();
    }

public static void binPacking(int[] a, int size, int n) {
    int binCount = 0;
    int[] binValues = new int[n];

    for (int i = 0; i < binValues.length; i++)
                    binValues[i] = size;
    
    for (int i = 0; i < n; i++)
            for (int j = 0; j < binValues.length; j++)
            {
                if (binValues[j] - a[i] >= 0)
                {
                    binValues[j] -= a[i];
                    break;
                }
            }
    for (int i = 0; i < binValues.length; i++)
            if (binValues[i] != size)
            binCount++;
    System.out.println("Number of bins require using first fit decreasing algorithm is:" + binCount);
}

static int[] sort(int[] sequence)
{
    
}
}
