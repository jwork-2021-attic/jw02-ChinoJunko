package myMonster;

//import org.springframework.boot.loader.JarLauncher;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Locale;

public class Scene {
    private static boolean ISMATRIX = false;
    private static int COUNT=-1;
    private static String SORTER;
    public static void main(String[] args) throws Exception {

        try {
            if (args.length == 0) {
                throw new Exception();
            }

            int k = 0;

            while(true) {

                if (k >= args.length) {
                    if (COUNT != -1 && SORTER != null) {
                        break;
                    }
                    throw new Exception();
                }

                if (!args[k].equals("-h") && !args[k].equals("--help")) {
                    if (!args[k].equals("-c") && !args[k].equals("--count")) {
                        if (!args[k].equals("-s") && !args[k].equals("--sorter")) {
                            if (args[k].equals("-m") || args[k].equals("--matrix")) {
                                ++k;
                                ISMATRIX = Boolean.parseBoolean(args[k]);
                            }
                        } else {
                            ++k;
                            SORTER = args[k].toLowerCase(Locale.ROOT);
                            if(SORTER.contains("b")){
                                SORTER="b";
                            }else if (SORTER.contains("q")){
                                SORTER="q";
                            }else if (SORTER.contains("s")){
                                SORTER="s";
                            }else {
                                throw new Exception();
                            }
                        }
                    } else {
                        ++k;
                        try {
                            COUNT= Integer.valueOf(args[k]).intValue();
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    throw new Exception();
                }
                ++k;
            }

        } catch (Exception var3) {
            System.out.println("Scene: A stop motion Scene(myMonster)\n\nUsage:\n\tjava Scene [-h] [-c COUNT] [-s SORTER] [-m BOOLEAN]\n\nArguments:\n\t-h, --help\t\t\tDisplay this message.\n\t-c, --count\t\t\tDefine the count of monsters to sort\n\t-s, --sorter\t\t\tSpecify the method used to sort(OPTIONS:BubbleSorter/BubbleSort/Bubble/B,QuickSorter/QuickSort/Quick/Q,ShellSorter/ShellSort/Shell/S or the lowercase)\n\t-m, --matrix\t\t\tSpecify if the sharp is a matrix. (Set to false by default)");
            System.exit(0);
        }

        Monster.initMonsters(COUNT);

        RandomRanker randomRanker = new RandomRanker();
        randomRanker.makeNewRandom(COUNT);

        Line queue;
        if(ISMATRIX){
            queue = new Matrix(COUNT/16,16);
        }else {
            queue = new Line(COUNT);
        }

        for (int i = 0; i < COUNT; i++) {
            queue.put(Monster.monsters[i+1], randomRanker.getRandom()[i]);
        }

        Snake theSnake = Snake.getTheSnake();

        Sorter sorter;
        switch (SORTER){
            case "b":
                sorter = new BubbleSorter();break;
            case "q":
                sorter = new QuickSorter();break;
            default:
                sorter = new ShellSorter();break;
        }

        theSnake.setSorter(sorter);

        String log = theSnake.lineUp(queue);

        BufferedWriter writer;
        writer = new BufferedWriter(new FileWriter("result.txt"));
        writer.write(log);
        writer.flush();
        writer.close();

        //JarLauncher.main(new String[]{"-f", "result.txt", "-l", "false", "-c", "true", "-fps", "120"});

    }

}
