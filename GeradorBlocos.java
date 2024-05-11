import java.util.Random;

public class GeradorBlocos {

    public static void main(String[] args) {
        final int NUM_BLOCOS = 80;
        Random rdn = new Random();
        rdn.setSeed(rdn.nextInt(NUM_BLOCOS));
        rdn.setSeed(rdn.nextInt(NUM_BLOCOS));
        String out = "[";
        for(int i = 0; i < NUM_BLOCOS; i++) {
            out += rdn.nextInt(NUM_BLOCOS);
            out += i + 1 == NUM_BLOCOS ? " " : ", ";
        }
        out += "]";
        
        System.out.println(out);
    }

}
