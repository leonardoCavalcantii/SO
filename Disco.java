public class Disco {

    final static int NUM_BLOCOS = 100;
    final static int NUM_TRILHAS = 5;
    final static int TAMANHO_TRILHA = NUM_BLOCOS / NUM_TRILHAS;
    final static int TAMANHO_FILA = 20;

    int[][] trilhas;
    double avgSeek;
    double avgRotation;
    Escalonador escalonador;
    int[] filaBlocos;
    Braco braco;


    public Disco(double avgSeek, int rpms) {
        this.avgSeek = avgSeek;
        // TODO: Ajeitar isso
        this.avgRotation = rpms / TAMANHO_TRILHA;
        this.trilhas = new int[NUM_TRILHAS][TAMANHO_TRILHA];
        this.filaBlocos = new int[TAMANHO_FILA];
        this.escalonador = new FCFS();
        this.braco = new Braco();
    }

    public void SetEscalonador(Escalonador escalonador) {
        this.escalonador = escalonador;
    }

    public void write(int[] blocos) {
        this.filaBlocos = blocos;
    }

    public int write() {
        this.filaBlocos = this.escalonador.run(this.filaBlocos);
        int timeTotal = 0;
        for (int i = 0; i < this.filaBlocos.length; i++) {
            int bloco = filaBlocos[i];
            int deslocamentoVertical = (bloco / TAMANHO_TRILHA) - braco.getPosTrilha();
            int deslocamentoHorizontal = (bloco % TAMANHO_TRILHA) - braco.getPosBloco();
            timeTotal += Math.abs(deslocamentoVertical) * avgSeek + Math.abs(deslocamentoHorizontal) * avgRotation;
            braco.setPosTrilha(braco.getPosTrilha() + deslocamentoVertical);
            braco.setPosBloco(braco.getPosBloco() + deslocamentoHorizontal);
        }

        return timeTotal;
    }

}
