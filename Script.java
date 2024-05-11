import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Script {

    public static void main(String[] args) {
        final double AVG_SEEK = 9;
        final int RPMS = 7200;
        Disco disco = new Disco(AVG_SEEK, RPMS);
        disco.setEscalonador(new SPTF());
    
        Integer[] blocos = new Integer[] {
            59, 11, 60, 15, 3, 54, 55, 63, 19, 20, 54, 54, 19, 13, 55, 40, 18, 60, 37, 0, 39, 35, 9, 78, 70, 47, 60, 47, 14, 4, 74, 55, 15, 37, 19, 30, 8, 18, 60, 36, 31, 30, 66, 18, 58, 11, 14, 79, 26, 5, 36, 27, 8, 24, 70, 75, 72, 14, 21, 2, 25, 57, 39, 41, 30, 41, 68, 27, 55, 59, 10, 63, 24, 79, 33, 66, 27, 36, 25, 32
        };

        System.out.println("Lista de blocos: ");
        int numBlocos = 80;
        int largura = 10;
        int j = 0;
        for(int linha = 0; linha < numBlocos / largura; linha++) {
            for(int coluna = 0; coluna < largura; coluna++) {
                System.out.print(blocos[j] + " ");
                j++;
            }
            System.out.println();
        }
        System.out.println();

        disco.write(blocos);
        System.out.println("Tempo total SPTF (ms): " + disco.write());
    }

}
