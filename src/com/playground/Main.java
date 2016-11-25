package com.playground;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {

    /*
     * Just a list to store run time for each sort, to be use for graphing
     * [bubble sort, quick sort, merge sort, insertion sort, selection sort]
     */
    private static List<Long> timeSort10000 = new ArrayList<>();
    private static List<Long> timeSort50000 = new ArrayList<>();
    private static List<Long> timeSort100000 = new ArrayList<>();

    private static List<Long> memUsage10000 = new ArrayList<>();
    private static List<Long> memUsage50000 = new ArrayList<>();
    private static List<Long> memUsage100000 = new ArrayList<>();

    private static List<Long> timeSet1 = new ArrayList<>();
    private static List<Long> timeSet2 = new ArrayList<>();

    private static List<Long> memUsageSet1= new ArrayList<>();
    private static List<Long> memUsageSet2 = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        SortMethods sortMethods = new SortMethods();
        int[] testList = new int[] {12,3,0,11,333,2,4,0,0};
        sortMethods.quickSort(testList);

        System.out.println("\n \n ----------------- 10,000 reandom numbers ----");
        calculateTime10k(sortMethods);
        calculateMemoryUsage10k(sortMethods);

        System.out.println("\n \n ----------------- 50,000 reandom numbers ----");
        calculateTime50k(sortMethods);
        calculateMemoryUsage50k(sortMethods);

        System.out.println("\n \n ----------------- 100,000 reandom numbers ----");
        calculateTime100k(sortMethods);
        calculateMemoryUsage100k(sortMethods);

        System.out.println("\n \n ----------------- Set 1 -------------");
        calculateTimeSet1(sortMethods);
        calculateMemoryUsageSet1(sortMethods);

        System.out.println("\n \n ----------------- Set 2 --------------");
        calculateTimeSet2(sortMethods);
        calculateMemoryUsageSet2(sortMethods);

    }


    /**
     * Testing
     * @param sortMethods
     * @return
     */


    public static List<Long> calculateTime10k(SortMethods sortMethods){
        int[] set_10000 = Arrays.copyOf(get_array_random("src/data/10000_random.txt", 10000), 10000);

        //test bubble sort:
        long startTime = System.currentTimeMillis();
        sortMethods.bubbleSort(set_10000);
        long endTime = System.currentTimeMillis();
        long timeSpent = endTime - startTime;
        timeSort10000.add(timeSpent);


        //test quick sort:
        startTime = System.currentTimeMillis();
        sortMethods.quickSort(set_10000);
        endTime = System.currentTimeMillis();
        timeSpent = endTime - startTime;
        timeSort10000.add(timeSpent);


        //test merge sort:
        startTime = System.currentTimeMillis();
        sortMethods.mergeSort(set_10000);
        endTime = System.currentTimeMillis();
        timeSpent = endTime - startTime;
        timeSort10000.add(timeSpent);


        //test insertion sort:
        startTime = System.currentTimeMillis();
        sortMethods.insertionSort(set_10000);
        endTime = System.currentTimeMillis();
        timeSpent = endTime - startTime;
        timeSort10000.add(timeSpent);

        //test selection sort:
        startTime = System.currentTimeMillis();
        sortMethods.selectionSort(set_10000);
        endTime = System.currentTimeMillis();
        timeSpent = endTime - startTime;
        timeSort10000.add(timeSpent);

        System.out.println("[bubble sort, quicksort, merge sort, insertion sort, selection sort] ms = " + timeSort10000);

        return timeSort10000;
    }

    public static List<Long> calculateMemoryUsage10k(SortMethods sortMethods){
        int[] set_10000 = Arrays.copyOf(get_array_random("src/data/10000_random.txt", 10000), 10000);

        //test bubble sort:
        long freeMemoryBefore = Runtime.getRuntime().freeMemory();
        sortMethods.bubbleSort(set_10000);
        long freeMemoryAfter = Runtime.getRuntime().freeMemory();
        long memoryUsed = freeMemoryBefore - freeMemoryAfter;
        memUsage10000.add(memoryUsed);


        //test quick sort:
        freeMemoryBefore = Runtime.getRuntime().freeMemory();
        sortMethods.quickSort(set_10000);
        freeMemoryAfter = Runtime.getRuntime().freeMemory();
        memoryUsed = freeMemoryBefore - freeMemoryAfter;
        memUsage10000.add(memoryUsed);


        //test merge sort:
        freeMemoryBefore = Runtime.getRuntime().freeMemory();
        sortMethods.mergeSort(set_10000);
        freeMemoryAfter = Runtime.getRuntime().freeMemory();
        memoryUsed = freeMemoryBefore - freeMemoryAfter;
        memUsage10000.add(memoryUsed);


        //test insertion sort:
        freeMemoryBefore = Runtime.getRuntime().freeMemory();
        sortMethods.insertionSort(set_10000);
        freeMemoryAfter = Runtime.getRuntime().freeMemory();
        memoryUsed = freeMemoryBefore - freeMemoryAfter;
        memUsage10000.add(memoryUsed);

        //test selection sort:
        freeMemoryBefore = Runtime.getRuntime().freeMemory();
        sortMethods.selectionSort(set_10000);
        freeMemoryAfter = Runtime.getRuntime().freeMemory();
        memoryUsed = freeMemoryBefore - freeMemoryAfter;
        memUsage10000.add(memoryUsed);

        System.out.println("byte used [bubble sort, quicksort, merge sort, insertion sort, selection sort] = " + memUsage10000);

        return memUsage10000;
    }

    public static List<Long> calculateTime50k(SortMethods sortMethods){
        int[] set_50000 = Arrays.copyOf(get_array_random("src/data/50000_random.txt", 50000), 50000);

        //test bubble sort:
        long startTime = System.currentTimeMillis();
        sortMethods.bubbleSort(set_50000);
        long endTime = System.currentTimeMillis();
        long timeSpent = endTime - startTime;
        timeSort50000.add(timeSpent);


        //test quick sort:
        startTime = System.currentTimeMillis();
        sortMethods.quickSort(set_50000);
        endTime = System.currentTimeMillis();
        timeSpent = endTime - startTime;
        timeSort50000.add(timeSpent);


        //test merge sort:
        startTime = System.currentTimeMillis();
        sortMethods.mergeSort(set_50000);
        endTime = System.currentTimeMillis();
        timeSpent = endTime - startTime;
        timeSort50000.add(timeSpent);


        //test insertion sort:
        startTime = System.currentTimeMillis();
        sortMethods.insertionSort(set_50000);
        endTime = System.currentTimeMillis();
        timeSpent = endTime - startTime;
        timeSort50000.add(timeSpent);

        //test selection sort:
        startTime = System.currentTimeMillis();
        sortMethods.selectionSort(set_50000);
        endTime = System.currentTimeMillis();
        timeSpent = endTime - startTime;
        timeSort50000.add(timeSpent);
        System.out.println("[bubble sort, quicksort, merge sort, insertion sort, selection sort] ms = " + timeSort50000);

        return timeSort50000;
    }

    public static List<Long> calculateMemoryUsage50k(SortMethods sortMethods){
        int[] set_50000 = Arrays.copyOf(get_array_random("src/data/10000_random.txt", 50000), 50000);

        //test bubble sort:
        long freeMemoryBefore = Runtime.getRuntime().freeMemory();
        sortMethods.bubbleSort(set_50000);
        long freeMemoryAfter = Runtime.getRuntime().freeMemory();
        long memoryUsed = freeMemoryBefore - freeMemoryAfter;
        memUsage50000.add(memoryUsed);


        //test quick sort:
        freeMemoryBefore = Runtime.getRuntime().freeMemory();
        sortMethods.quickSort(set_50000);
        freeMemoryAfter = Runtime.getRuntime().freeMemory();
        memoryUsed = freeMemoryBefore - freeMemoryAfter;
        memUsage50000.add(memoryUsed);


        //test merge sort:
        freeMemoryBefore = Runtime.getRuntime().freeMemory();
        sortMethods.mergeSort(set_50000);
        freeMemoryAfter = Runtime.getRuntime().freeMemory();
        memoryUsed = freeMemoryBefore - freeMemoryAfter;
        memUsage50000.add(memoryUsed);


        //test insertion sort:
        freeMemoryBefore = Runtime.getRuntime().freeMemory();
        sortMethods.insertionSort(set_50000);
        freeMemoryAfter = Runtime.getRuntime().freeMemory();
        memoryUsed = freeMemoryBefore - freeMemoryAfter;
        memUsage50000.add(memoryUsed);

        //test selection sort:
        freeMemoryBefore = Runtime.getRuntime().freeMemory();
        sortMethods.selectionSort(set_50000);
        freeMemoryAfter = Runtime.getRuntime().freeMemory();
        memoryUsed = freeMemoryBefore - freeMemoryAfter;
        memUsage50000.add(memoryUsed);

        System.out.println("byte used [bubble sort, quicksort, merge sort, insertion sort, selection sort] = " + memUsage50000);

        return memUsage50000;
    }


    public static List<Long> calculateTime100k(SortMethods sortMethods){
        int[] set_100000 = Arrays.copyOf(get_array_random("src/data/100000_random.txt", 100000), 100000);


        //test bubble sort:
        long startTime = System.currentTimeMillis();
        sortMethods.bubbleSort(set_100000);
        long endTime = System.currentTimeMillis();
        long timeSpent = endTime - startTime;
        timeSort100000.add(timeSpent);


        //test quick sort:
        startTime = System.currentTimeMillis();
        sortMethods.quickSort(set_100000);
        endTime = System.currentTimeMillis();
        timeSpent = endTime - startTime;
        timeSort100000.add(timeSpent);

        //test merge sort:
        startTime = System.currentTimeMillis();
        sortMethods.mergeSort(set_100000);
        endTime = System.currentTimeMillis();
        timeSpent = endTime - startTime;
        timeSort100000.add(timeSpent);

        //test insertion sort:
        startTime = System.currentTimeMillis();
        sortMethods.insertionSort(set_100000);
        endTime = System.currentTimeMillis();
        timeSpent = endTime - startTime;
        timeSort100000.add(timeSpent);

        //test selection sort:
        startTime = System.currentTimeMillis();
        sortMethods.selectionSort(set_100000);
        endTime = System.currentTimeMillis();
        timeSpent = endTime - startTime;
        timeSort100000.add(timeSpent);
        System.out.println("[bubble sort, quicksort, merge sort, insertion sort, selection sort] ms = " + timeSort100000);

        return timeSort100000;
    }


    public static List<Long> calculateMemoryUsage100k(SortMethods sortMethods){
        int[] set_100000 = Arrays.copyOf(get_array_random("src/data/10000_random.txt", 100000), 100000);

        //test bubble sort:
        long freeMemoryBefore = Runtime.getRuntime().freeMemory();
        sortMethods.bubbleSort(set_100000);
        long freeMemoryAfter = Runtime.getRuntime().freeMemory();
        long memoryUsed = freeMemoryBefore - freeMemoryAfter;
        memUsage100000.add(memoryUsed);


        //test quick sort:
        freeMemoryBefore = Runtime.getRuntime().freeMemory();
        sortMethods.quickSort(set_100000);
        freeMemoryAfter = Runtime.getRuntime().freeMemory();
        memoryUsed = freeMemoryBefore - freeMemoryAfter;
        memUsage100000.add(memoryUsed);


        //test merge sort:
        freeMemoryBefore = Runtime.getRuntime().freeMemory();
        sortMethods.mergeSort(set_100000);
        freeMemoryAfter = Runtime.getRuntime().freeMemory();
        memoryUsed = freeMemoryBefore - freeMemoryAfter;
        memUsage100000.add(memoryUsed);


        //test insertion sort:
        freeMemoryBefore = Runtime.getRuntime().freeMemory();
        sortMethods.insertionSort(set_100000);
        freeMemoryAfter = Runtime.getRuntime().freeMemory();
        memoryUsed = freeMemoryBefore - freeMemoryAfter;
        memUsage100000.add(memoryUsed);

        //test selection sort:
        freeMemoryBefore = Runtime.getRuntime().freeMemory();
        sortMethods.selectionSort(set_100000);
        freeMemoryAfter = Runtime.getRuntime().freeMemory();
        memoryUsed = freeMemoryBefore - freeMemoryAfter;
        memUsage100000.add(memoryUsed);

        System.out.println("byte used [bubble sort, quicksort, merge sort, insertion sort, selection sort] = " + memUsage100000);

        return memUsage100000;
    }


    public static List<Long> calculateTimeSet1(SortMethods sortMethods){

        int[] dataSet = Arrays.copyOf(get_array_random("src/data/census_track_911_incident_response.txt", 35000), 35000);

        //test bubble sort:
        long startTime = System.currentTimeMillis();
        sortMethods.bubbleSort(dataSet);
        long endTime = System.currentTimeMillis();
        long timeSpent = endTime - startTime;
        timeSet1.add(timeSpent);


        //test quick sort:
        startTime = System.currentTimeMillis();
        sortMethods.quickSort(dataSet);
        endTime = System.currentTimeMillis();
        timeSpent = endTime - startTime;
        timeSet1.add(timeSpent);


        //test merge sort:
        startTime = System.currentTimeMillis();
        sortMethods.mergeSort(dataSet);
        endTime = System.currentTimeMillis();
        timeSpent = endTime - startTime;
        timeSet1.add(timeSpent);


        //test insertion sort:
        startTime = System.currentTimeMillis();
        sortMethods.insertionSort(dataSet);
        endTime = System.currentTimeMillis();
        timeSpent = endTime - startTime;
        timeSet1.add(timeSpent);

        //test selection sort:
        startTime = System.currentTimeMillis();
        sortMethods.selectionSort(dataSet);
        endTime = System.currentTimeMillis();
        timeSpent = endTime - startTime;
        timeSet1.add(timeSpent);

        System.out.println("[bubble sort, quicksort, merge sort, insertion sort, selection sort] ms = " + timeSet1);

        return timeSet1;
    }

    public static List<Long> calculateMemoryUsageSet1(SortMethods sortMethods){
        int[] set1 = Arrays.copyOf(get_array_random("src/data/census_track_911_incident_response.txt", 35000), 35000);

        //test bubble sort:
        long freeMemoryBefore = Runtime.getRuntime().freeMemory();
        sortMethods.bubbleSort(set1);
        long freeMemoryAfter = Runtime.getRuntime().freeMemory();
        long memoryUsed = freeMemoryBefore - freeMemoryAfter;
        memUsageSet1.add(memoryUsed);


        //test quick sort:
        freeMemoryBefore = Runtime.getRuntime().freeMemory();
        sortMethods.quickSort(set1);
        freeMemoryAfter = Runtime.getRuntime().freeMemory();
        memoryUsed = freeMemoryBefore - freeMemoryAfter;
        memUsageSet1.add(memoryUsed);


        //test merge sort:
        freeMemoryBefore = Runtime.getRuntime().freeMemory();
        sortMethods.mergeSort(set1);
        freeMemoryAfter = Runtime.getRuntime().freeMemory();
        memoryUsed = freeMemoryBefore - freeMemoryAfter;
        memUsageSet1.add(memoryUsed);


        //test insertion sort:
        freeMemoryBefore = Runtime.getRuntime().freeMemory();
        sortMethods.insertionSort(set1);
        freeMemoryAfter = Runtime.getRuntime().freeMemory();
        memoryUsed = freeMemoryBefore - freeMemoryAfter;
        memUsageSet1.add(memoryUsed);

        //test selection sort:
        freeMemoryBefore = Runtime.getRuntime().freeMemory();
        sortMethods.selectionSort(set1);
        freeMemoryAfter = Runtime.getRuntime().freeMemory();
        memoryUsed = freeMemoryBefore - freeMemoryAfter;
        memUsageSet1.add(memoryUsed);

        System.out.println("byte used [bubble sort, quicksort, merge sort, insertion sort, selection sort] = " + memUsageSet1);

        return memUsageSet1;
    }

    public static List<Long> calculateTimeSet2(SortMethods sortMethods){

        int[] dataSet = Arrays.copyOf(get_array_random("src/data/hospital_spending_by_claim.txt", 35000), 35000);

        //test bubble sort:
        long startTime = System.currentTimeMillis();
        sortMethods.bubbleSort(dataSet);
        long endTime = System.currentTimeMillis();
        long timeSpent = endTime - startTime;
        timeSet1.add(timeSpent);


        //test quick sort:
        startTime = System.currentTimeMillis();
        sortMethods.quickSort(dataSet);
        endTime = System.currentTimeMillis();
        timeSpent = endTime - startTime;
        timeSet1.add(timeSpent);


        //test merge sort:
        startTime = System.currentTimeMillis();
        sortMethods.mergeSort(dataSet);
        endTime = System.currentTimeMillis();
        timeSpent = endTime - startTime;
        timeSet1.add(timeSpent);


        //test insertion sort:
        startTime = System.currentTimeMillis();
        sortMethods.insertionSort(dataSet);
        endTime = System.currentTimeMillis();
        timeSpent = endTime - startTime;
        timeSet1.add(timeSpent);

        //test selection sort:
        startTime = System.currentTimeMillis();
        sortMethods.selectionSort(dataSet);
        endTime = System.currentTimeMillis();
        timeSpent = endTime - startTime;
        timeSet1.add(timeSpent);

        System.out.println("[bubble sort, quicksort, merge sort, insertion sort, selection sort] ms = " + timeSet1);

        return timeSet1;
    }

    public static List<Long> calculateMemoryUsageSet2(SortMethods sortMethods){
        int[] set2 = Arrays.copyOf(get_array_random("src/data/hospital_spending_by_claim.txt", 35000), 35000);

        //test bubble sort:
        long freeMemoryBefore = Runtime.getRuntime().freeMemory();
        sortMethods.bubbleSort(set2);
        long freeMemoryAfter = Runtime.getRuntime().freeMemory();
        long memoryUsed = freeMemoryBefore - freeMemoryAfter;
        memUsageSet2.add(memoryUsed);


        //test quick sort:
        freeMemoryBefore = Runtime.getRuntime().freeMemory();
        sortMethods.quickSort(set2);
        freeMemoryAfter = Runtime.getRuntime().freeMemory();
        memoryUsed = freeMemoryBefore - freeMemoryAfter;
        memUsageSet2.add(memoryUsed);


        //test merge sort:
        freeMemoryBefore = Runtime.getRuntime().freeMemory();
        sortMethods.mergeSort(set2);
        freeMemoryAfter = Runtime.getRuntime().freeMemory();
        memoryUsed = freeMemoryBefore - freeMemoryAfter;
        memUsageSet2.add(memoryUsed);


        //test insertion sort:
        freeMemoryBefore = Runtime.getRuntime().freeMemory();
        sortMethods.insertionSort(set2);
        freeMemoryAfter = Runtime.getRuntime().freeMemory();
        memoryUsed = freeMemoryBefore - freeMemoryAfter;
        memUsageSet2.add(memoryUsed);

        //test selection sort:
        freeMemoryBefore = Runtime.getRuntime().freeMemory();
        sortMethods.selectionSort(set2);
        freeMemoryAfter = Runtime.getRuntime().freeMemory();
        memoryUsed = freeMemoryBefore - freeMemoryAfter;
        memUsageSet2.add(memoryUsed);

        System.out.println("byte used [bubble sort, quicksort, merge sort, insertion sort, selection sort] = " + memUsageSet2);

        return memUsageSet2;
    }

    /**
     * Read in a file, put all numbers in an array.
     *
     * @return array of random numbers with 'size' elements
     */
    public static int[] get_array_random(String path, int size) {
        int[] set_numers = new int[size];

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                if (!line.isEmpty()) {
                    set_numers[i] = Integer.parseInt(line);
                    i++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return set_numers;
    }



}
