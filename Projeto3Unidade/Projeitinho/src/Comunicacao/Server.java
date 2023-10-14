package Comunicacao;

import Dados.HashTable;
import Dados.No;
import Entity.Veiculo;

public class Server {
    private HashTable tabelaHash;

    public Server() {
        tabelaHash = new HashTable(61);
    }

    public Veiculo consultarVeiculo(String chave) {
        No no = tabelaHash.buscar(chave);
        if (no != null) {
            return no.veiculo;
        } else {
            return null; // Retorna null se o veículo não for encontrado.
        }
    }
    

    public boolean cadastrarVeiculo(String data) {
        tabelaHash.inserir(data); // Inserir o objeto Veiculo, não a string "data"
        return true; 
    }
    

    public void removerVeiculo(String chave) {
        tabelaHash.remover(chave);
    }

    public void listarVeiculos() {
        // Obtém a lista de veículos formatada da tabela hash
        tabelaHash.imprimir();
    }

    public String encerrarConexao() {
        // Implementar lógica para encerrar a conexão, se necessário
        return "Conexão encerrada.";
    }
}
