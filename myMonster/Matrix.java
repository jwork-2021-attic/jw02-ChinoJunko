package myMonster;

public class Matrix extends Line{
    private int length,width;
    public Matrix(int length,int width) {
        super(length*width);
        this.length = length;
        this.width = width;
    }

    public void put(Linable linable, int len,int wid) {
        if (this.positions[len*16+wid] == null) {
            this.positions[len*16+wid] = new Position(null);
        }
        this.positions[len*16+wid].setLinable(linable);
    }

    public Linable get(int len,int wid) {
        if ((len*16+wid < 0) || (len*16+wid > positions.length)) {
            return null;
        } else {
            return positions[len*16+wid].linable;
        }
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

    @Override
    public Linable[] toArray() {
        Linable[] linables = new Linable[this.positions.length];

        for (int i = 0; i < linables.length; i++) {
            linables[i] = positions[i].linable;
        }

        return linables;

    }
}
