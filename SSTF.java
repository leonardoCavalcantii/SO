import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;

public class SSTF implements Escalonador {
    final int BLOCKS_BY_TRACK = 19;
    final int NUM_BLOCKS = 80;

    public Integer[] run(Integer[] blocos) {
        int limiteInf = 0;
        int limiteSup = BLOCKS_BY_TRACK;
        List<Integer> aux = new LinkedList<Integer>();
        while(limiteSup < NUM_BLOCKS) {
            for(int i = 0; i < blocos.length; i++) {
                int current = blocos[i];
                if(current >= limiteInf && current < limiteSup) 
                    aux.add(current);
            }
            limiteInf += 20;
            limiteSup += 20;
        }

        return aux.toArray(new Integer[aux.size()]);
    }

}
