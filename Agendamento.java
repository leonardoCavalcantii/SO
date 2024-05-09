public class Agendamento {

    int bloco;
    int tempoDeChegada;

    
    public Agendamento(int tempoDeChegada, int bloco) {
        this.tempoDeChegada = tempoDeChegada;
        this.bloco = bloco;
    }

    public int getBloco() {
        return this.bloco;
    }

    public int getTempo() {
        return this.tempoDeChegada;
    }
}
