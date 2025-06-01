package at.fhj.msd;

public class InterpolationSearch {
  public static int interpolationSearch(int[] a, int x) {
    int low = 0;
    int high = a.length - 1;

    while (low <= high && x >= a[low] && x <= a[high]) {
      if (a[low] == a[high]) {
        if (a[low] == x)
          return low;
        else
          return -1;
      }

      int pos = low + ((x - a[low]) * (high - low)) / (a[high] - a[low]);

      if (pos < 0 || pos >= a.length)
        break;

      if (a[pos] == x)
        return pos;
      if (a[pos] < x)
        low = pos + 1;
      else
        high = pos - 1;
    }

    return -1;
  }
}
