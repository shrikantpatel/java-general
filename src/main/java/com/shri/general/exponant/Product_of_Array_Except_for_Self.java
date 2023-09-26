package com.shri.general.exponant;

/**
 * Product of Array Except for Self
 * https://www.youtube.com/watch?v=riBWq1DvVb8
 */
public class Product_of_Array_Except_for_Self {

    /* this method is simple but does work for array with 0 as element in it.
     */
    private static void approach1(int[] input) {
        int product = 1;

        // Iterate first all element to get the product of all the element
        for (int index = 0; index < input.length; index++) {
            product = product * input[index];
        }

        // Iterate through array, product / element = product of rest of element of the array ie except the element itself
        for (int index = 0; index < input.length; index++) {
            System.out.print(product / input[index] + " ");
        }
    }

    private static void approach2(int[] input) {
        int product = 1;

        // lets say array is
        // 1,      2,      3,      4,      5,     6
        int[] leftSideProduct = new int[input.length];
        int[] rightSideProduct = new int[input.length];

        // left side product is
        //1,      2,      6,      24,     120,    720
        leftSideProduct[0] = input[0];
        for (int index = 1; index < input.length; index++) {
            leftSideProduct[index] = leftSideProduct[index - 1] * input[index];
        }

        //right side product is
        //720,    720,    360,    120,    30,      6
        rightSideProduct[input.length - 1] = input[input.length - 1];
        for (int index = input.length - 2; index >= 0; index--) {
            rightSideProduct[index] = rightSideProduct[index + 1] * input[index];
        }

        // product of all element Except the element at Index itself = left side product[index-1] * right side product[index+1]
        //720     360     240     180     144     120
        System.out.print(rightSideProduct[1] + " ");
        for (int index = 1; index < input.length - 1; index++) {
            System.out.print(leftSideProduct[index - 1] * rightSideProduct[index + 1] + " ");
        }
        System.out.print(leftSideProduct[input.length - 2] + " ");
    }

    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 3, 4, 5, 6};
        approach1(input);
        System.out.println();
        approach2(input);
        System.out.println();
        System.out.println("********************************");

        int[] input1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        approach1(input1);
        System.out.println();
        approach2(input1);
        System.out.println();
        System.out.println("********************************");

        int[] input2 = new int[]{1, 12, 4, 4, 5, 6, 2, 2, 9};
        approach1(input2);
        System.out.println();
        approach2(input2);
        System.out.println();
        System.out.println("********************************");

        int[] input3 = new int[]{1, 12, 4, 4, 5, 6, 2, 2, 9};
        approach1(input3);
        System.out.println();
        approach2(input3);
        System.out.println();
        System.out.println("********************************");
    }
}
