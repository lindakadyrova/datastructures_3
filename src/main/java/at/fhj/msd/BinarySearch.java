package at.fhj.msd;

public class BinarySearch {

  public static int binarySearch(int[] a, int x) {
    int left = 0;
    int right = a.length - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;

      if (a[mid] == x) {
        return mid;
      } else if (a[mid] < x) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    return -1; // not found
  }
}
