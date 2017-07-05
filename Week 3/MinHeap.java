import java.util.*;
import java.io.*;

public class MinHeap{
  static int cnt = 0;
  static ArrayList<Integer> list = new ArrayList<Integer>();
  public static int LeftChild(int i, int size){
    int ans = (2*i + 1) >= size ? -1 : 2*i + 1;
    return ans;

  }
  public static int RightChild(int i, int size){
    int ans = (2*i + 2) >= size ? -1 : 2*i + 2;
    return ans;
  }

  public static void swap (int a[], int x, int y){
    int temp = a[x];
    list.add(x);
    list.add(y);
    a[x] = a[y];
    a[y] = temp;
  }
  public static void SiftDown(int i, int a[]){
    int minIndex = i;
    int size = a.length;
    int l = LeftChild(i, size);
    int r = RightChild(i, size);

    if(l!=-1){
      if(l<size && a[l] < a[minIndex])
      minIndex = l;
    }

    if(r!=-1){
      if(r<size && a[r] < a[minIndex])
      minIndex = r;
    }

    if(minIndex!=i){
      swap(a, i, minIndex);
      cnt++;
      // System.out.print("Swapped " + i + " and " + minIndex);
      SiftDown(minIndex, a);
    }


  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int a[] = new int[n];
    for(int i=0;i<n;i++)
    a[i] = sc.nextInt();

    int start = n/2;
    for(int i = start; i>=0;i--){
      SiftDown(i,a);
    }
    System.out.println(cnt);
    int listsize = list.size();
    for(int i=0;i<listsize;i=i+2){
      Integer one = list.get(i);
      Integer two = list.get(i+1);
      System.out.print(one +" " + two);
      System.out.println();
    }
    // for(Integer x : list)
    // System.out.print(x + " ");

  }
}
