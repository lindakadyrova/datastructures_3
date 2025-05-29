package at.fhj.msd;

public class LinearSearch {
    public static int linearSearch(int a[], int x) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) {
                return i;
            }
        }
        return -1;
    }
}