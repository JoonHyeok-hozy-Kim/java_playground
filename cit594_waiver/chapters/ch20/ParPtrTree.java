package cit594_waiver.chapters.ch20;

public class ParPtrTree {
    private int[] array;

    ParPtrTree(int size){
        array = new int[size];
        for (int i=0; i<size; i++){
            array[i] = -1;
        }
    }

    public void UNION(int a, int b){
        int root1 = FIND(a);
        int root2 = FIND(b);
        if (root1 != root2){
            array[root1] = root2;
        }
    }

    public int FIND(int curr){
        while (array[curr] != -1){
            curr = array[curr];
        }
        return curr;
    }
}
