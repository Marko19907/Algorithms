package searching;

public class BinarySearch {

    /**
     * Binary search
     */
    public static int binarySearch(final int[] array, final int requestedValue) {
        if (array == null) {
            throw new IllegalArgumentException("The given array can not be null!");
        }

        int left = 0;
        int right = array.length - 1;

        int pointer = midPoint(left, right);
        int value;

        while (right - left > 0) {
            value = array[pointer];

            if (value < requestedValue) {
                // value is smaller, discard everything to the left

                left = pointer;
                pointer = 1 + midPoint(left, right);
            }
            else if (value > requestedValue) {
                // value is bigger, discard everything to the right

                right = pointer;
                pointer = midPoint(left, right);
            }
            else {
                return array[pointer];
            }
        }

        return -1;
    }

    /**
     * Finds the mid-point between the two given numbers.
     */
    private static int midPoint(int min, int max) {
        return Math.floorDiv((max + min), 2);
    }

    /**
     * Binary search recursive
     */
    public static int binarySearchRecursive(final int[] array, final int requestedValue) {
        if (array == null) {
            throw new IllegalArgumentException("The given array can not be null!");
        }

        int left = 0;
        int right = array.length - 1;
        int pointer = midPoint(left, right);

        return recurse(array, requestedValue, left, right, pointer);
    }

    /**
     * A step in the recursive binary search algorithm
     */
    private static int recurse(final int[] array, final int requestedValue, int left, int right, int pointer) {
        if ((right - left) == 0) {
            return -1;
        }

        int value = array[pointer];
        if (value < requestedValue) {
            // value is smaller, discard everything to the left
            left = pointer;
            pointer = 1 + midPoint(left, right);
            return recurse(array, requestedValue, left, right, pointer);
        }
        else if (value > requestedValue) {
            // value is bigger, discard everything to the right
            right = pointer;
            pointer = midPoint(left, right);
            return recurse(array, requestedValue, left, right, pointer);
        }
        else {
            return array[pointer];
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{
                1, 3, 5
        };
        if (binarySearch(array, 1) != 1) {
            System.out.println("Broken search!, case 1");
        }
        if (binarySearch(array, 3) != 3) {
            System.out.println("Broken search!, case 3");
        }
        if (binarySearch(array, 5) != 5) {
            System.out.println("Broken search!, case 5");
        }
        if (binarySearch(array, 555) != -1) {
            System.out.println("Broken search!, case 555");
        }

        System.out.println(binarySearch(array, 1));


        int[] array2 = new int[] {
                2, 3, 4, 10, 40, 45, 60, 100, 321, 555, 1329, 4325
        };
        if (binarySearch(array2, 4325) != 4325) {
            System.out.println("Broken search!, case 4325");
        }
        if (binarySearch(array2, 4) != 4) {
            System.out.println("Broken search!, case 4");
        }
        if (binarySearch(array2, 321) != 321) {
            System.out.println("Broken search!, case 321");
        }
        if (binarySearch(array2, 51524) != -1) {
            System.out.println("Broken search!, case 51524");
        }


        System.out.println("====================");
        System.out.println("Recursive tests");
        System.out.println("====================");


        if (binarySearchRecursive(array, 1) != 1) {
            System.out.println("Broken search!, case 1");
        }
        if (binarySearchRecursive(array, 3) != 3) {
            System.out.println("Broken search!, case 3");
        }
        if (binarySearchRecursive(array, 5) != 5) {
            System.out.println("Broken search!, case 5");
        }
        if (binarySearchRecursive(array, 555) != -1) {
            System.out.println("Broken search!, case 555");
        }

        System.out.println(binarySearchRecursive(array, 1));


        if (binarySearchRecursive(array2, 4325) != 4325) {
            System.out.println("Broken search!, case 4325");
        }
        if (binarySearchRecursive(array2, 4) != 4) {
            System.out.println("Broken search!, case 4");
        }
        if (binarySearchRecursive(array2, 321) != 321) {
            System.out.println("Broken search!, case 321");
        }
        if (binarySearchRecursive(array2, 51524) != -1) {
            System.out.println("Broken search!, case 51524");
        }
    }
}
