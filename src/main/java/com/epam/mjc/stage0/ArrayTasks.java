package com.epam.mjc.stage0;






/**
 * Here are the tasks for working with the arrays.
 * <p>
 * The usage of any additional packages (such as java.util.*) is forbidden.
 */
public class ArrayTasks {

    /**
     * Return a String[] array that will list all the seasons of the year, starting with winter.
     */
    public String[] seasonsArray() {
    	String[] seasonString = new String[] {"winter", "spring", "summer", "autumn"};
    	return seasonString;
    	
    }

    /**
     * Generate an int[] array of consecutive positive integers
     * starting at 1 of the given length (length parameter > 0).
     * <p>
     * Example:
     * <p>
     * length = 1  -> [1]
     * length = 3  -> [1, 2, 3]
     * length = 5  -> [1, 2, 3, 4, 5]
     */
    public int[] generateNumbers(int length) {
    	int[] result = new int[length];
    	for(int i = 0; i <= length - 1; i++) {
    		result[i] = ++i;
    	}
    	return result;
    }

    /**
     * Find the sum of all elements of the int[] array.
     * <p>
     * Example:
     * <p>
     * arr = [1, 3, 5]   -> sum = 9
     * arr = [5, -3, -4] -> sum = -2
     */
    public int totalSum(int[] arr) {
    	int result = arr[arr.length - 1];
    	int[] copy = new int[arr.length - 1];
    	if (copy.length < 1) {
			return arr[0];
		}
    	System.arraycopy(arr, 0, copy, 0, arr.length - 1);
    	return result + totalSum(copy);
    }

    /**
     * Return the index of the first occurrence of number in the arr array.
     * If there is no such element in the array, return -1.
     * <p>
     * Example:
     * <p>
     * arr = [99, -7, 102], number = -7    ->   2
     * arr = [5, -3, -4],   number = 10    ->  -1
     */
    public int findIndexOfNumber(int[] arr, int number) {
    	for(int i = 0; i <= arr.length - 1; i++) {
    		if (arr[i] == number) {
				return i;
			}
    	}
    	return -1;
    }

    /**
     * Return the new String[] array obtained from the arr array
     * by reversing the order of the elements.
     * <p>
     * Example:
     * <p>
     * arr = ["Bob", "Nick"]               -> ["Nick", "Bob"]
     * arr = ["pineapple", "apple", "pen"] -> ["pen", "apple", "pineapple"]
     */
    public String[] reverseArray(String[] arr) {
    	String[] reversedArrayStrings = new String[arr.length];
    	for(int i = arr.length - 1; i >= 0; i--) {
    		reversedArrayStrings[-(i - arr.length + 1)] = arr[i];
    	}
    	return reversedArrayStrings;
    }

    /**
     * Return new int[] array obtained from arr int[] array
     * by choosing positive numbers only.
     * P.S. 0 is not a positive number =)
     * <p>
     * Example:
     * <p>
     * arr = [1,-2, 3]      -> [1, 3]
     * arr = [-1, -2, -3]   -> []
     * arr = [1, 2]         -> [1, 2]
     */
    public int[] getOnlyPositiveNumbers(int[] arr) {
    	int[] positiveInts = new int[arr.length];
    	int indexOfPosiviveIntsArray = 0;
    		for(int i = 0; i <= arr.length - 1; i++) {
    			if (arr[i] > 0) {
					positiveInts[indexOfPosiviveIntsArray] = arr[i];
					indexOfPosiviveIntsArray++;
				}
    		}
    		if (indexOfPosiviveIntsArray == 0) {
				return new int[0];
			}
    		int[] result = new int[indexOfPosiviveIntsArray];
    		System.arraycopy(positiveInts, 0, result, 0, indexOfPosiviveIntsArray);
    		return result;
    }

    /**
     * Return a sorted, ragged, two-dimensional int[][] array following these rules:
     * Incoming one-dimensional arrays must be arranged in ascending order of their length;
     * numbers in all one-dimensional arrays must be in ascending order.
     * <p>
     * Example:
     * <p>
     * arr = [[3, 1, 2,], [3,2]] -> [[2, 3], [1, 2, 3]]
     * arr = [[5, 4], [7]]       -> [[7], [4, 5]]
     */
    public int[][] sortRaggedArray(int[][] arr) {
    	for(int j = 0; j <= arr.length - 1; j++) {
    		int[] numbersAscending = new int[arr[j].length];
    		System.arraycopy(arr[j], 0, numbersAscending, 0, arr[j].length);
    		
    		int temp;
    		 
            for (int i = numbersAscending.length / 2 - 1; i >= 0; i--)                
            {
                heapify(numbersAscending, numbersAscending.length, i);
            }
           
     
            for (int i = numbersAscending.length - 1; i > 0; i--)                           
            {
                temp = numbersAscending[0];                                                  
                numbersAscending[0] = numbersAscending[i];
                numbersAscending[i] = temp;
                heapify(numbersAscending, i, 0);                                            
            }
            System.arraycopy(numbersAscending, 0, arr[j], 0, arr[j].length);
        }
    	
    	int[] arrayOfStrokesInMultyArray = new int[arr.length];
    	int[] numbersOfStroke = new int[arr.length];
    	for(int i = 0; i <= arrayOfStrokesInMultyArray.length - 1; i++) {
    		arrayOfStrokesInMultyArray[i] = arr[i].length;
    		numbersOfStroke[i] = i;
    	}
    	int temp = 0;
    	boolean sorted = false;
    	while (!sorted) {
    		sorted = true;
			for(int i = 0; i < arrayOfStrokesInMultyArray.length - 1; i++) {
				if (arrayOfStrokesInMultyArray[i] >= arrayOfStrokesInMultyArray[i+1] ) {
					temp = arrayOfStrokesInMultyArray[i];
					arrayOfStrokesInMultyArray[i] = arrayOfStrokesInMultyArray[i+1];
					arrayOfStrokesInMultyArray[i+1] = temp;
					temp = numbersOfStroke[i];
					numbersOfStroke[i] = numbersOfStroke[i+1];
					numbersOfStroke[i+1] = temp;
					sorted = false;
				}
			}
		}
    	int[][] sortedArray = new int[arr.length][];
    	for(int i = 0; i <= sortedArray.length - 1; i++) {
    		sortedArray[i] = arr[numbersOfStroke[i]];
			}
     	return sortedArray;
    }
        void heapify(int arr[], int n, int i)
        {
            int MAX = i; 
            int left = 2 * i + 1; 
            int right = 2 * i + 2; 
            int temp;

            if (left < n && arr[left] > arr[MAX])            
            {
                MAX = left;
            }
     
            if (right < n && arr[right] > arr[MAX])            
            {
                MAX = right;
            }
            if (MAX != i) {
                temp = arr[i];
                arr[i] = arr[MAX];
                arr[MAX] = temp;
                heapify(arr, n, MAX);
            }
        }
}

