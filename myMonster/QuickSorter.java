package myMonster;

public class QuickSorter implements Sorter {

    private int[] a;
    private String plan = "";

    @Override
    public void load(int[] a) {
        this.a = a;
    }

    private void swap(int i, int j) {
        int temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        plan += "" + a[i] + "<->" + a[j] + "\n";
    }

    @Override
    public void sort() {
        quickSort(0,a.length-1);
    }
    public void quickSort(int left, int right){
        if(left<right){
            int p = partition(left,right);
            quickSort(left,p-1);
            quickSort(p+1,right);
        }
    }
    public int partition(int left, int right){
        int pivot = a[right],i=left-1;
        for (int j = left; j < right; j++) {
            if(a[j]<pivot){
                i++;
                swap(i,j);
            }
        }
        if(a[right]<a[i+1])
            swap(right,i+1);
        return i+1;
    }

    @Override
    public String getPlan() {
        return this.plan;
    }

}
