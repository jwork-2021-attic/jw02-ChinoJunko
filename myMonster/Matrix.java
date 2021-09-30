package myMonster;

public class Matrix extends Line{

    public Matrix(int length) {
        super(length);
    }


    @Override
    public String toString() {
        String lineString = "\t";
        int temp = 0;
        for (Position p : positions) {
            lineString += p.linable.toString();
            if(++temp%16==0) {
                temp = 0;
                lineString += "\n\t";
            }
        }
        lineString +="\n";
        return lineString;
    }

}
