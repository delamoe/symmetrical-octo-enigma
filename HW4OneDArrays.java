/*
 * Class	:	HW4OneDArrays.java
 *
 * Purpose 	:	HW4 One Dimensional Arrays
 * 				10979 CIS131 Prog & Problem Solv II 
 *
 * Developer:	E de la Montaña
 *
 * Date		:	9/22/2018
 */
public class HW4OneDArrays {
    public static void main(String[] args) {
        String hBars = "🙃 🤑 😲 ☹ ️🙁 😖 😞 😟 😤 😢 😭 😠 😷 🤒 🤕 😇 🤓 💀 🤖 🤗 😬 😰 😱 😳 😵 🤐 😡 😴 ";
        // 1. Declares an array of 10 ints
        int[] array = new int[10];
        assignRandomValues(array);
        System.out.printf("%nBefore the sorting:%n%s%nArray Elements%n%s%n%s", hBars, hBars,
                arrayElementalDisplay(array));
        insertionSort(array);
        System.out.printf("%n%nAfter the sorting:%n%s%nArray Elements%n%s%n%s%n%s%n", hBars, hBars,
                arrayElementalDisplay(array), hBars);
        // 2. Declares an int to hold the index of the largest array element
        int minElementValue = 1, maxElementValue = 100;
        int arrayMaxIndex = indexOfArrayAndMaxValue(array, minElementValue)[1];
        int arrayMaxElement = indexOfArrayAndMaxValue(array, minElementValue)[0];
        // 3. Declares an int to hold the index of the smallest array element
        int arrayMinIndex = indexOfArrayAndMinValue(array, maxElementValue)[1];
        int arrayMinElement = indexOfArrayAndMinValue(array, maxElementValue)[0];
        // 4. Declares an int to hold the sum of the array elements
        int arraySum = arraySum(array);
        // 5. Declares a double to hold the value of the average of the array elements
        double arrayAvg = arrayAverage(array);
        displayResults(array, arrayMaxIndex, arrayMaxElement, arrayMinIndex, arrayMinElement, arraySum, arrayAvg,
                hBars);
    }

    // 6. Defines a method that assigns a random value to each array element
    public static void assignRandomValues(int[] arr) { // CHANGE TO void
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (1 + Math.random() * 100);
        }
    }

    // 7. Defines a method that displays all the elements in the array
    public static String arrayElementalDisplay(int[] arr) {
        String arrayList = "";
        for (int i = 0; i < arr.length; i++) {
            String punctuate = i == arr.length - 1 ? "" : " ";
            arrayList += String.format("%02d%s", arr[i], punctuate);
        }
        return arrayList;
    }

    // 8. Defines a method that sorts the array using the insertion technique (the
    // text provides sample code for this)
    public static void insertionSort(int[] list) {
        for (int i = 1; i < list.length; i++) {
            int currentElement = list[i];
            int k;
            for (k = i - 1; k >= 0 && list[k] > currentElement; k--) {
                list[k + 1] = list[k];
            }
            list[k + 1] = currentElement;
        }
    }

    // 9. Defines a method that identifies and returns the index of the highest
    // value in the array
    public static int[] indexOfArrayAndMaxValue(int[] arr, int minElementValue) {
        int[] max_index = { minElementValue, minElementValue };
        for (int i = 0; i < arr.length; i++) {
            if (max_index[0] < arr[i]) {
                max_index[0] = arr[i];
                max_index[1] = i;
            }
        }
        return max_index;
    }

    // 10. Defines a method that identifies and returns the index of the lowest
    // value in the array
    public static int[] indexOfArrayAndMinValue(int[] arr, int maxElementValue) {
        int[] min_index = { maxElementValue, maxElementValue };
        for (int i = 0; i < arr.length; i++) {
            if (min_index[0] > arr[i]) {
                min_index[0] = arr[i];
                min_index[1] = i;
            }
        }
        return min_index;
    }

    // 11. Defines a method that calculates the sum of the array elements
    public static int arraySum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    // 12. Defines a method that calculates the average of the array elements
    public static double arrayAverage(int[] arr) {
        double average = arraySum(arr) / (double) arr.length;
        return average;
    }

    // 13. Defines a method that displays the results calculated by the methods
    // described in items 5 through 8.
    public static void displayResults(int[] arr, int arrayMaxIndex, int arrayMaxElement, int arrayMinIndex,
            int arrayMinElement, int arraySum, double arrayAvg, String hBars) {
        String displayString = "";
        displayString += String.format("%nResults of Array Processing%n%s", hBars);
        displayString += String.format("%nThe index of the highest value is %d. It’s value is %d.", arrayMaxIndex, arrayMaxElement);
        displayString += String.format("%nThe index of the lowest value is %d. It’s value is %d.", arrayMinIndex, arrayMinElement);
        displayString += String.format("%nThe sum of the array elements is %d", arraySum(arr));
        displayString += String.format("%nThe average of the array elements is %5.1f", arrayAverage(arr));
        displayString += String.format("%n%s%n", hBars);
        System.out.printf("%s", displayString);
    }
}