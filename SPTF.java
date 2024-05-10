import java.util.Arrays;

public class SPTF implements Escalonador {
    
    public Integer[] run(Integer[] blocos) {
        Integer[] result = blocos;
        Arrays.sort(result);
        return result;
    }

}
