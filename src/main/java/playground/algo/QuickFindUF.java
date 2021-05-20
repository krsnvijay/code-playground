package playground.algo;

import java.util.Arrays;

public class QuickFindUF {
    int[] arr;

    public QuickFindUF(int n) {
        this.arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
    }

    public boolean connected(int i, int j) {
        return arr[i] == arr[j];
    }

    public void union(int p, int q) {
        int pid = arr[p];
        int qid = arr[q];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == pid) {
                arr[i] = qid;
            }
        }
    }

    @Override
    public String toString() {
        return "QuickFindUF{" +
                "arr=" + Arrays.toString(arr) +
                '}';
    }

    public static void main(String[] args) {
        QuickFindUF quickFindUF = new QuickFindUF(6);
        quickFindUF.union(1,2);
        quickFindUF.union(3,4);
        quickFindUF.union(4,5);
        System.out.println(quickFindUF);
        System.out.println(quickFindUF.connected(1,4));
        System.out.println(quickFindUF.connected(3,5));


    }
}
