import java.util.Queue;
import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;

public class Disco {

    final static int NUM_BLOCOS = 100;
    final static int NUM_TRILHAS = 5;
    final static int TAMANHO_TRILHA = NUM_BLOCOS / NUM_TRILHAS;
    final static int TAMANHO_FILA = 20;

    int[][] trilhas;
    double avgSeek;
    double avgRotation;
    Escalonador escalonador;
    Integer[] filaBlocos;
    Braco braco;
    Queue<Agendamento> agendamentos;


    public Disco(double avgSeek, int rpms) {
        this.avgSeek = avgSeek;
        // TODO: Ajeitar isso
        // this.avgRotation = rpms / TAMANHO_TRILHA;
        this.avgRotation = 0.72; // colocar esse valor fixo por enquanto: 0.72ms
        this.trilhas = new int[NUM_TRILHAS][TAMANHO_TRILHA];
        this.filaBlocos = new Integer[TAMANHO_FILA];
        this.escalonador = new FCFS();
        this.braco = new Braco();
        this.agendamentos = new LinkedList<Agendamento>();
    }

    public void setEscalonador(Escalonador escalonador) {
        this.escalonador = escalonador;
    }

    public void setAgendamentos(List<Agendamento> agendamentos) {
        agendamentos.sort((x, y) -> x.getTempo() - y.getTempo());
        this.agendamentos = new LinkedList<Agendamento>(agendamentos);
    }

    public void write(Integer[] blocos) {
        this.filaBlocos = Arrays.copyOf(blocos, blocos.length);
    }

    public int write() {
        this.filaBlocos = this.escalonador.run(this.filaBlocos);
        int timeTotal = 0;
        Agendamento proximoAgendamento = agendamentos.poll();
        for (int i = 0; i < this.filaBlocos.length; i++) {
            if (proximoAgendamento != null && i == proximoAgendamento.getTempo()) {
                this.filaBlocos = addBloco(i, this.filaBlocos, proximoAgendamento.getBloco());
                timeTotal += write();
                // this.filaBlocos = this.escalonador.run(this.filaBlocos);
                // proximoAgendamento = agendamentos.poll();
            }

            int bloco = filaBlocos[i];
            int deslocamentoVertical = (bloco / TAMANHO_TRILHA) - braco.getPosTrilha();
            int deslocamentoHorizontal = (bloco % TAMANHO_TRILHA) - braco.getPosBloco();
            timeTotal += Math.abs(deslocamentoVertical) * avgSeek + Math.abs(deslocamentoHorizontal) * avgRotation;
            braco.setPosTrilha(braco.getPosTrilha() + deslocamentoVertical);
            braco.setPosBloco(braco.getPosBloco() + deslocamentoHorizontal);
        }

        return timeTotal;
    }

    private Integer[] addBloco(int inicio, Integer[] fila, int novoBloco) {
        Integer[] novaFila = new Integer[fila.length + 1 - inicio];
        for(int i = 0; i < novaFila.length - 1; i++) {
            novaFila[i] = fila[inicio++];
        } 
        novaFila[novaFila.length - 1] = novoBloco;
        
        return novaFila;
    }

}
