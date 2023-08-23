import javax.lang.model.element.Element;

public class sorters {

  public int[] a = new int[10];
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

    public int binarySearchFirst(int[] a, int key) {
    
    int left = 0;
    int right = a.length - 1;
    int mid = (left + right) / 2;
    while (left < right) {
      if (key <= a[mid]) {
        right = mid;
      } else {
        left = mid + 1;
      }
   
    }
    if (a[left] != key) {
      return -1;
    }
   return left;
  }
    
  public int binarySearchLast(int[] a, int key) {
    
    int left = 0;
    int right = a.length - 1;
    int mid = (left + right + 1) / 2;
    while (left < right) {
      if (key >= a[mid]) {
        left = mid;
      } else {
        right = mid - 1;
      }
   
    }
    if (a[left] != key) {
      return -1;
    }
   return left;
  }
    


  public void selectionSort(int[] a) {
    int min;
    int temp;
    for (int i = 0; i < a.length - 1; i++) {
      min = i;
      for (int j = i + 1; j < a.length; j++) {
        if (a[j] < a[min]) {
          min = j;
        }
      }
      temp = a[i];
      a[i] = a[min];
      a[min] = temp;
    }
  }

  public void insertionSort(int[] a) {
    int temp;
    for (int i = 1; i < a.length; i++) {
      for (int j = i; j > 0; j--) {
        if (a[j] < a[j - 1]) {
          temp = a[j];
          a[j] = a[j - 1];
          a[j - 1] = temp;
        }
      }
    }
  }
    


  public void mergeSort(int[] a , int left, int right) {
    if (left < right) {
      int mid = (left + right) / 2;
      mergeSort(a, left, mid);
      mergeSort(a, mid + 1, right);
      merge(a, left, mid, right);
    }
  }

  public void merge(int[] a, int left, int mid, int right) {
    int[] temp = new int[right - left + 1];
    int i = left;
    int j = mid + 1;
    for (int k = 0; k < temp.length; k++) {
      // check whether i or j is out of bound
      if (i > mid) {
        temp[k] = a[j++];
      } else if (j > right) {
        temp[k] = a[i++];
        // compare i and j (also when at the very end of recursion)
      } else if (a[i] < a[j]) {
        temp[k] = a[i++];
      } else {
        temp[k] = a[j++];
      }
    }
    for (int k = 0; k < temp.length; k++) {
      a[left++] = temp[k];
    }



  }
    

  
  
  public void quickSort(int[] a, int left, int right) {
    if (left < right) {
      int pivot = partition(a, left, right);
      quickSort(a, left, pivot - 1);
      quickSort(a, pivot + 1, right);
    }
  }

    public int partition(int[] a, int left, int right) {
    int pivot = a[right];
    int i = right - 1;
    while (i >= left) {
      if (a[i] > pivot && i == pivot - 1) {
        swap(a, i, right);
        i--;
        pivot--;
      } else if (a[i] < pivot) {
        i--;
      } else {
        swap(a, i, pivot - 1);
        swap(a, pivot - 1, pivot);
        pivot--;
        i--;
      } 

    }
    return pivot;
  }

  public int partitionNotInPlace(int[] a, int left, int right) {
    int pivot = a[right];
    int[] temp = new int[right - left + 1];
    int i = 0;
    int j = right - left;
    int newPivot = pivot;
    for (int k = left; k <= right; k++) {
      if (a[k] < pivot) {
        temp[i++] = a[k];
      } else {
        temp[j--] = a[k];
        newPivot--;
      }
    }
    for (int k = 0; k < temp.length; k++) {
      a[left++] = temp[k];
    }
    return newPivot;
  }
  public void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;

  }
  
  public int quickSelect(int[] a, int k) {
    int left = 0;
    int right = a.length - 1;
    while (left < right) {
      int pivot = partition(a, left, right);
      if (pivot == k - 1) {
        return a[k - 1];
      } else if (pivot < k - 1) {
        left = pivot + 1;
      } else {
        right = pivot - 1;
      }
    }
    return a[left];
  }

  public void countingSort(byte [] a) {
    int[] count = new int[256];
    for (int i = 0; i < a.length; i++) {
      count[a[i]]++;
    }
    int index = 0;
    for (int i = 0; i < count.length; i++) {
      while (count[i] > 0) {
        a[index++] = (byte) i;
        count[i]--;
      }
    }
  }
    
  public void countingSortStable(Element [] a) {
    int[] count = new int[5];
    for (int i = 0; i < a.length; i++) {
      count[a[i].type]++;
    }
    int []nextPos = new int[5];
    nextPos[0] = 0;
    for (int i = 1; i < count.length; i++) {
      nextPos[i] = nextPos[i - 1] + count[i - 1];
    }
    Element[] temp = new Element[a.length];
    for (int i = 0; i < a.length; i++) {
      temp[nextPos[a[i].type]++] = a[i];
    }
    for (int i = 0; i < a.length; i++) {
      a[i] = temp[i];
    }
  }

  public void radixSort(int [] a) {
    int max = a[0];
    for (int i = 1; i < a.length; i++) {
      if (a[i] > max) {
        max = a[i];
      }
    }
    for (int exp = 1; max/exp > 0; exp *= 10) {
      radixInsertionSort(a, exp);
    }
  }
    
  }

  public void radixInsertionSort(int[] a, int exp) {
    int temp;
    for (int i = 1; i < a.length; i++) {
      for (int j = i; j > 0; j--) {
        if ((a[j]/exp)%10 < (a[j - 1]/exp)%10) {
          temp = a[j];
          a[j] = a[j - 1];
          a[j - 1] = temp;
        }
      }
    }
  }

  
}
