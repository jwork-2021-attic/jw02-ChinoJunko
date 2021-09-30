package myMonster;

public class RandomRanker {
    int[] random_array;
    public int[] makeNewRandom(int size){
        random_array = new int[size];
        for (int i = 0; i < size; i++) {
            random_array[i] = -1;
        }
        for (int i = 0; i < size; i++) {
            int idx = hash(i,size);
            while(random_array[idx]!=-1)
                idx = (idx+1)%size;
            random_array[idx] = i;
        }
        return random_array;
    }

    public int hash(int x,int size){
        return (7*x*x+167*x+31)%size;
    }

    public int[] getRandom(){
        return random_array;
    }
}
