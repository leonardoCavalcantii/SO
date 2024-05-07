import java.util.Random;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        final double AVG_SEEK = 9;
        final int RPMS = 7200;
        Disco disco = new Disco(AVG_SEEK, RPMS);
    
        final int NUM_BLOCOS = 80;
        int[] blocos = new int[NUM_BLOCOS];
        Random randomGen = new Random();
        for (int i = 0; i < blocos.length; i++) {
            blocos[i] = randomGen.nextInt(NUM_BLOCOS);
        }   

        System.out.println("Blocos buffer: " + Arrays.toString(blocos));
    }
    
}
