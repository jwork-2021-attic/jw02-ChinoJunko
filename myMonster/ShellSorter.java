package myMonster;

public class ShellSorter implements Sorter{

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
    public void sort(){
        for(int gap=a.length/2;gap>0;gap/=2){
            for(int i=gap;i<a.length;i++){
                int j = i;
                while(j-gap>=0 && a[j]<a[j-gap]){
                    swap(j,j-gap);
                    j-=gap;
                }
            }
        }
    }

    @Override
    public String getPlan() {
        return this.plan;
    }
}
