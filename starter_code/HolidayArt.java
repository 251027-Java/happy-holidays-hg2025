/**
 * Holiday ASCII Art Generator
 * 
 * Your task: Create a festive Christmas tree using ASCII characters!
 * 
 * Basic tree structure:
 * * <- Star on top
 * *** <- Tree branches (odd numbers of *)
 * *****
 * *******
 * ||| <- Trunk
 */
public class HolidayArt {

    public static void main(String[] args) {
        // TODO: Parse command-line argument for tree height (default: 5)
        int height = 5;

        // Command-Line Arguments logic
        if (args.length > 0) {
            try {
                height = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                // Keep default height if input is not a number
            }
        }

        // TODO: Print the tree
        printTree(height);
    }

    /**
     * Prints a Christmas tree with the given height.
     * * @param height Number of branch levels (not including star and trunk)
     */
    public static void printTree(int height) {
        // TODO: Implement this method
        //
        // Steps:
        // 1. Print the star on top (centered)
        // 2. Loop through each level of branches
        // - Calculate spaces needed for centering
        // - Calculate stars needed (1, 3, 5, 7, ...)
        // 3. Print the trunk (centered)

        // System.out.println("Implement me!");

        System.out.println();

        // Track last character to keep ornaments evened out
        char lastChar = ' ';

        for (int n = 1; n <= height; n++) {
            // The top star needs 'height' spaces.
            // Each row needs (height - row_index + 1) spaces.
            System.out.print(" ".repeat(height - n + 1));

            if (n == 1) {
                // The star
                System.out.println("*");
            } else {
                // Branches with decorations
                int rowWidth = 2 * n - 1;
                for (int i = 0; i < rowWidth; i++) {
                    double rand = Math.random();
                    
                    // Place ornament if last character was star, not at edges
                    // and only 30% chance to place an ornament
                    if (lastChar == '*' && i < rowWidth - 1 && rand < 0.30) {
                        lastChar = (Math.random() < 0.5) ? 'o' : 'O';
                        System.out.print(lastChar);
                    } else {
                        System.out.print("*");
                        lastChar = '*';
                    }
                }
                System.out.println();
                lastChar = ' '; // Reset for next row
            }
        }
        
        
        // To center trunk, "|||", use (height - 1) spaces.
        System.out.println(" ".repeat(height - 1) + "|||");

        // Final festive message
        System.out.println("\n Happy Holidays! ");
    }
}