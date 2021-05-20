package playground.algo;

import java.util.Arrays;

public class QuickUnionUF {
    int[] arr;

    public QuickUnionUF(int n) {
        this.arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
    }

    private int root(int i) {
        while (arr[i] != i) i = arr[i];
        return i;
    }

    public boolean connected(int i, int j) {
        return root(i) == root(j);
    }

    public void union(int p, int q) {
        int pRoot = root(p);
        int qRoot = root(q);
        arr[pRoot] = qRoot;
    }

    @Override
    public String toString() {
        return "QuickFindUF{" +
                "arr=" + Arrays.toString(arr) +
                '}';
    }

    public static void main(String[] args) {
        QuickUnionUF quickUnionUF = new QuickUnionUF(6);
        quickUnionUF.union(1, 2);
        quickUnionUF.union(3, 4);
        quickUnionUF.union(4, 5);
        System.out.println(quickUnionUF);
        System.out.println(quickUnionUF.connected(1, 4));
        System.out.println(quickUnionUF.connected(3, 5));


    }
}
