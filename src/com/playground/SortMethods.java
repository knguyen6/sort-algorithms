package com.playground;

import java.util.Arrays;
import java.util.Random;


/**
 * @author Kon Nguyen
 *
 */
public class SortMethods {


    private static Random random = new Random();

    /**
     *  Bubble sort:
     * Looping thru unsorted List and compare every 2 elements next to each other till end of array.
     * Largest element will be bubble to the back of the array.
     * Next iteration thru unsorted List will end before the largest element.
     *
     * Keep bubbling the next largest element to the back, next to larger one.
     *
     * @param unsortedList
     * @return sorted list
     */
    public int[] bubbleSort(int[] unsortedList){
        int[] sortedList = Arrays.copyOf(unsortedList, unsortedList.length );

        if (unsortedList.length < 2)
            return unsortedList;

        int endPointer = sortedList.length;
        while (endPointer != 0){
            for (int i = 1; i < endPointer; i++){
                if (sortedList[i-1] > sortedList[i]) {
                    swap(sortedList, i, i - 1);
                }
            }


            //larger number is moving to the end of array, decrement endPointer:
            endPointer--;
        }
        return sortedList;
    }


    /**
     * Quick sort an array list
     * @param unsortedList original unsorted array.
     * @return copy of unsorted list in sorted order.
     */
    public int[] quickSort(int[] unsortedList){
        int[] sortedList = Arrays.copyOf(unsortedList, unsortedList.length);

        if (sortedList.length < 2)
            return sortedList;

        doQuickSort(sortedList, 0, sortedList.length-1);

        return sortedList;
    }


    /**
     * Do the quicksort by recursively partition the unsorted list from a pivot
     * @param list unsorted list
     * @param left left partition to pivot index
     * @param right right partition start from pivot index
     */
    private void doQuickSort(int[] list, int left, int right){

        if (left < right) {
            int pivot = partition(list, left, right);
            doQuickSort(list, left, pivot-1); //recursion partition and sort on the left side
            doQuickSort(list, pivot+1, right); //recursion partition and sort right side
        }

    }


    /**
     * Partition for quick sort.
     * Choose a pivot: last element of the list.
     * Left pointer i : will keep track of all element < pivot on its left side.
     *
     * Run thru the list, if an element <= pivot, move it to left of the left pointer (i)
     * Then increment left pointer: i++
     * At the end of for-loop, since all element on the left of left pointer (i) < pivot, we
     *  swap i and pivot..
     *
     *  The final left pointer (i) is the new pivot for next partition.
     *  @return index of pivot
     */
    private int partition(int[] list, int left, int right){

        int i = left, pivot = right;

        for (int j = left; j < right; j++){
            if (list[j] <= list[pivot]) {
                swap(list, i, j );
                i++;
            }
        }
        swap(list, pivot, i);

        //return new pivot
        return i;
    }


    /**
     * Merge sort :
     *
     * Find mid point of the unsorted array, split original array into 2 sub arrays: left, right
     * For each sub array, keep splitting in half recursively.
     * Base case: until length of each sub array < 2, keep splitting
     *
     * When all sub arrays are at base case then:
     * compare each element in 2 sub arrays and put the smaller into a new array, call merged array.
     * The leftover elements in one array will be added to the end of the merged array.
     * Again, recursively doing this until all elements in original unsorted array are sorted.
     *
     @param unsortedList: orginal unsorted array
     @return  sortedList: a sorted array of original unsorted array.
     */
    public int[] mergeSort(int[] unsortedList){
        int[] sortedList = Arrays.copyOf(unsortedList, unsortedList.length);

        //base case:
        if (sortedList.length < 2)
            return sortedList;


        //if more than 1 element in array, split array in 1/2, then put them in seperated array:
        int[] left = new int[unsortedList.length/2];
        int[] right = new int[unsortedList.length - (unsortedList.length)/2];




        for (int i = 0; i< unsortedList.length; i++){
            if (i < unsortedList.length/2)
                left[i] = unsortedList[i];
            else
                right[i - unsortedList.length/2] = unsortedList[i];
        }

        //do merge sort on left array and right array:
        left = mergeSort(left);
        right = mergeSort(right);

        return mergeList(left, right);
    }




    /**
     * Compare first element in array left and right, smaller element will be add to mergedList.
     @param left: left array
     @param right: right array
     @return mergedList: sorted and merged array of left and right.
     */
    private int[] mergeList(int[] left, int[] right){


        int i = 0, j=0,k=0;
        int[] mergedList = new int[left.length + right.length];




        while(i < left.length && j < right.length){
            if (left[i] < right[j]){
                mergedList[k] = left[i];
                i++; //added an element in left array to merge list, increment ptr
            } else {
                mergedList[k] = right[j];
                j++;//added an element in right array to mergedList, increment ptr.
            }
            k++;
        }


        //previous while loops is done, means that either left or right array is done
        // now we add the rest of the other array to mergedList
        while ( i < left.length){
            mergedList[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length){
            mergedList[k] = right[j];
            j++;
            k++;
        }
        return mergedList;
    }



    /**
     *
     * Selection sort:
     * One loop to keep track of 1st element, 2nd element, etc till end of unsortedList: i=0
     * Another loop to loop thru unsortedList to find smallest element: j=i+1.
     * Once found the smallest at j, swap it with item at i in unsortedList, then i++.
     *
     * In general, find smallest item in array, then swap it w/ first position in unsortedList,
     * then find 2nd largest, swap with 2nd position in unsortedList and so on.
     *
     * @param unsortedList : original unsortedList
     * @return sortedList :sorted list
     */
    public int[] selectionSort(int[] unsortedList){
        int[] sortedList = Arrays.copyOf(unsortedList, unsortedList.length);




        for (int i = 0; i < sortedList.length-1; i++){
            int min = i; //initalize index of min element at i, then start checking:
            for (int j = i+1; j < sortedList.length; j++){
                if (sortedList[j] < sortedList[min]){
                    min = j;
                }
            }
            swap(sortedList, min, i);
        }




        return  sortedList;
    }




    /**
     * Insertion sort:
     * If unsortedList has only 1 element, then it's sorted.
     *
     * Loop thru unsortedList starting at index i=1:
     * a)Start compare current element at i in the loop with previous elements.
     * b)When element at i <  previous element, slide previous element to the right 1 space.
     * Repeat a) and b) until element at i found its correct position, which is smaller than all
     * the elements that it compared to.
     *
     * Repeat the process inside the loop till array is sorted.
     *
     * @param unsortedList
     * @return sortedList: result is a sorted list.
     */
    public int[] insertionSort(int[] unsortedList){
        int[] sortedList = Arrays.copyOf(unsortedList, unsortedList.length);




        //there's only 1 element or empty array, then it's sorted.
        if (unsortedList.length < 2)
            return unsortedList;




        //there's more than 1 element in unsortedList:
        for (int i = 1; i < sortedList.length; i++){
            int ptr = sortedList[i];
            int correctPosition = i;




            //start compare element at i with previous:
            for (int j = i-1; j >=0; j--){




                if (sortedList[j] > ptr) {
                    sortedList[j+1] = sortedList[j];
                    correctPosition = j;
                }
                else
                    break;
            }


            //if there's a correct position in one of the previous position, put the ptr there:
            if (correctPosition != i){
                sortedList[correctPosition] = ptr;
            }
        }
        return sortedList;
    }


    /*
     * Helper: Swap 2 item at idx1 and idx2 from list.
     */
    private void swap(int[] list, int idx1, int idx2){
        int temp = list[idx1];
        list[idx1] = list[idx2];
        list[idx2] = temp;
    }
}


