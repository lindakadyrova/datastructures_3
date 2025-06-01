package at.fhj.msd;

public class QuadraticBinarySearch {
  public static int quadraticBinarySearch(int[] a, int x) {
    int left = 0;
    int right = a.length - 1;

    while (left <= right) {
      int range = right - left;
      int mid = left + (range * range) / ((range == 0) ? 1 : (right - left + 1));

      if (mid >= a.length)
        mid = a.length - 1;

      if (a[mid] == x)
        return mid;
      else if (a[mid] < x)
        left = mid + 1;
      else
        right = mid - 1;
    }

    return -1;
  }
}
