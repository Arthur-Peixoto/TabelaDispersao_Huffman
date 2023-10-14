package Dados;

import Entity.Veiculo;

public class No {
    No proximo;
    public Veiculo veiculo;

    public No( Veiculo veiculo, No Next){
        this.veiculo = veiculo;
        proximo = Next;
    }

    public Veiculo getValor(){
        return veiculo;
    }
}
