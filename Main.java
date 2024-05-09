import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        final double AVG_SEEK = 9;
        final int RPMS = 7200;
        Disco disco = new Disco(AVG_SEEK, RPMS);
        disco.setEscalonador(new FCFS());
    
        final int NUM_BLOCOS = 80;
        int[] blocos = new int[NUM_BLOCOS];
        blocos = new int[] {
            78, 40, 67, 47, 37, 27, 75, 31, 0, 33, 56, 32, 24, 43, 76, 53, 76, 45, 12, 58, 45, 14, 60, 71, 22, 40, 73, 14, 57, 29, 32, 71, 35, 6, 76, 68, 18, 25, 45, 67, 13, 55, 35, 49, 65, 46, 9, 69, 61, 34, 79, 48, 51, 35, 32, 63, 47, 11, 3, 10, 67, 38, 76, 77, 33, 14, 50, 0, 2, 3, 12, 20, 51, 51, 4, 77, 15, 11, 61, 7
        };

        System.out.println("Lista de blocos: " + Arrays.toString(blocos));

        disco.write(blocos);
        System.out.println("Tempo total (ms): " + disco.write());
    }
    
}
