import java.util.ArrayList;
import java.util.*;

public class BinpackingFFD {


    //System.out.println("Bin - Packing Algorithm IS object(First Fit Decreasing)");System.out.println("Enter the number of items in set");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input from the console
        System.out.println("Enter bin capacity B, number of items n, and the item, sizes:");
        // Example input: 20 9 12 3 7 16 9 4 1 10
        int capacity = scanner.nextInt();
        int n = scanner.nextInt();
        List<Integer> items = new ArrayList<>();
        int totalItemSize = 0;
        for (int i = 0; i < n; i++){
            int itemSize = scanner.nextInt();
            items.add(itemSize);
            totalItemSize += itemSize;    
        }
        
        // Let's apply the First Fit Decreasing (FFD) algorithm
        List<List<Integer>> bins = new ArrayList<>();
        List<Integer> unpackedItems = new ArrayList<>();
        int[] binRemainingCapacity = new int[3];
        Arrays.fill(binRemainingCapacity, capacity);

        // sort the items in decreasing order
        Collections.sort(items, Collections.reverseOrder());

        // Iterate and place items 
        for (int item : items) {
            boolean placed = false;
            for (int i = 0; i < 3; i++){
                if (item <= binRemainingCapacity[i]) {
                    if (bins.size() <= i){
                        bins.add(new ArrayList<>());
                    }
                    bins.get(i).add(item);
                    binRemainingCapacity[i] -= item;
                    placed = true;
                    break;
                }
            } // the case that if an item is not placed
            if (!placed) {
                unpackedItems.add(item);
            }
        }
        // Calculate total unused space
        int unusedBinSpace = 0;
        for (int remaining : binRemainingCapacity) {
            unusedBinSpace += remaining;
        }
        int totalUnusedSpace = unusedBinSpace;
        for (int unpackedItem : unpackedItems) {
            totalUnusedSpace += unpackedItem;
        }
        // Print the output
         System.out.println("\n--- Bin Packing Results (FFD) ---");
        System.out.println("Bin Capacity (B): " + capacity);
        System.out.println("Number of Bins (N): 3");
        for (int i = 0; i < bins.size(); i++) {
            System.out.println("Bin " + (i + 1) + ": " + bins.get(i) + ", Unused Space: " + binRemainingCapacity[i]);
    }
    System.out.println("Unpacked Items: " + unpackedItems);
        System.out.println("Total unused space (includes unpacked items): " + totalUnusedSpace);
        System.out.println("Total item size: " + totalItemSize);

        scanner.close();
    }
}
