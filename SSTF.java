import java.util.Arrays;

public class SSTF implements Escalonador {
    
    public int[] run(int[] blocos) {
        int[] result = blocos;
        Arrays.sort(result);
        return result;
    }

}
