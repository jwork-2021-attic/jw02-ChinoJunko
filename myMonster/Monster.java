package myMonster;

import myMonster.Line.Position;

public class Monster implements Linable {

    static Monster[] monsters;

    private final int employee_number;
    private final int r;
    private final int g;
    private final int b;

    private Position position;

    Monster(int[] rgb, int num) {
        this.r = rgb[0];
        this.g = rgb[1];
        this.b = rgb[2];
        this.employee_number = num;
    }

    public static int[] getColor(int monster_rank){
        int r,g,b;
        int column_size=16;
        int column=(monster_rank-1)%column_size;
        if(column*3<column_size){
            r=255;
            g=(255*3*column)/column_size;
            b=0;
        }else if(column*2<column_size){
            r=750-(column*250*6)/column_size;
            g=255;
            b=0;
        }else if(column*3<column_size*2){
            r=0;
            g=255;
            b=(column*250*6)/column_size-750;
        }else if(column*6<column_size*5){
            r=0;
            g=1250-(column*250*6)/column_size;
            b=255;
        }else{
            r=(150*column*6)/column_size-750;
            g=0;
            b=255;
        }
        return new int[]{r,g,b};
    }

    public static Monster[] initMonsters(int monster_size){
        monsters = new Monster[monster_size+1];
        for (int i = 1; i <= monster_size; i++) {
            monsters[i] = new Monster(getColor(i),i);
        }
        return monsters;
    }

    public static Monster getMonsterByRank(int monster_rank) {
        return monsters[monster_rank];
    }

    public int rank() {
        return this.employee_number;
    }

    @Override
    public String toString() {
        return "\033[48;2;" + this.r + ";" + this.g + ";" + this.b + ";38;2;0;0;0m    "  + String.format("%-3d",this.rank()) + "  \033[0m";
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public Position getPosition() {
        return this.position;
    }

    public void swapPosition(Monster another) {
        Position p = another.position;
        this.position.setLinable(another);
        p.setLinable(this);
    }

    @Override
    public int getValue() {
        return this.rank();
    }

}