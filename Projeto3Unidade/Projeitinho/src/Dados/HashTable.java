package Dados;

import java.io.FileWriter;
import java.io.IOException;

import Comunicacao.Cliente;
import Entity.Condutor;
import Entity.Veiculo;

public class HashTable {
    private int size;
    private int q;
    private No tabela[];

    public HashTable(int tam) {
        size = tam;
        tabela = new No[size];
        q = 0;
    }

    private int hash(String placa) {
        int hash = 0;
        for (int i = 0; i < placa.length(); i++) {
            hash += placa.charAt(i);
        }
        return hash % size;
    }

    public boolean inserir(String compressed) {
    // Descompressão dos dados do veículo enviado para inserção
    String decompressed = Cliente.compressor.sempressao(compressed);
    System.out.println("Decompressed Data: " + decompressed);
    String[] datas = decompressed.split("@");
    if (datas.length != 6) {
        System.out.println("Dados descomprimidos não possuem o formato esperado." + datas.length);
        return false;
    }
        
        // Extraindo os dados do veículo da string descomprimida
        String placa = datas[0];
        String make = datas[1];
        String model = datas[2];
        String data = datas[3];
        String nome = datas[4];
        String cpf = datas[5];
        
        // Criando um objeto Veículo com os dados extraídos
        Veiculo vehicle = new Veiculo(placa, make, model, data, new Condutor(nome, cpf));
        
        // Calcule o índice de dispersão (hash) com base na placa do veículo
        int c = hash(placa);
        
        No currentNode = tabela[c];
        No previousNode = null;
        
        if (currentNode == null) {
            tabela[c] = new No(vehicle, null);
            q++;
            EscreverLog(c, (q/size));
            return true;
        } else {
            while (currentNode != null) {
                if (currentNode.veiculo.getPlaca().equals(placa)) {
                    break;
                }
                previousNode = currentNode;
                currentNode = currentNode.proximo;
            }
    
            if (currentNode == null) {
                No newNode = new No(vehicle, null);
                previousNode.proximo = newNode;
                q++;
    
                double tam = (double) q;
                double tamHash = (double) size;
                double fatorCarga = tam / tamHash;
                EscreverLog(c, fatorCarga);
                return true;
            }
        }
        return false;
    }
    

    public No buscar(String placa) {
        int h = hash(placa);
        No node = tabela[h];
        
        No atual;
        No anterior = null;
        int cont = 0;
        
        for(atual = node; atual != null; atual = atual.proximo){
            if (atual.veiculo.getPlaca().equals(placa)) {
                if (cont != 0) { // Realiza a transposição somente se cont for maior que 0
                    System.out.println("\nEndereço -> " + h);
                    // Cria uma cópia do veículo do nó atual
                    Veiculo tempVeiculo = new Veiculo(atual.veiculo.getRenavam(), atual.veiculo.getPlaca(), atual.veiculo.getModelo(), atual.veiculo.getDataFabricacao(), new Condutor(atual.veiculo.getCondutor().getNome(), atual.veiculo.getCondutor().getCpf()));
                    // Copia os dados do veículo anterior para o veículo atual
                    atual.veiculo.setPlaca(anterior.veiculo.getPlaca());
                    atual.veiculo.setModelo(anterior.veiculo.getModelo());
                    atual.veiculo.setRenavam(anterior.veiculo.getRenavam());
                    atual.veiculo.setDataFabricacao(anterior.veiculo.getDataFabricacao());
                    atual.veiculo.setCondutor(anterior.veiculo.getCondutor().getNome(), anterior.veiculo.getCondutor().getCpf());
                    // Copia os dados do veículo temporário (temp) para o veículo anterior
                    anterior.veiculo.setPlaca(anterior.veiculo.getPlaca());
                    anterior.veiculo.setModelo(anterior.veiculo.getModelo());
                    anterior.veiculo.setRenavam(anterior.veiculo.getRenavam());
                    anterior.veiculo.setDataFabricacao(anterior.veiculo.getDataFabricacao());
                    anterior.veiculo.setCondutor(anterior.veiculo.getCondutor().getNome(), anterior.veiculo.getCondutor().getCpf());
                }
                return atual;
            }
            anterior = atual;
            atual = atual.proximo;
            cont++;
        }
        
        return null;
    }
    
    
    public boolean remover(String placa) {
        // Descompressão do dado recebido
        placa = Cliente.compressor.sempressao(placa);
        int h = hash(placa);
        No currentNode = tabela[h];
        No previousNode = null;
        
        // Busca e remoção do veículo desejado
        while (currentNode != null) {
            if (currentNode.veiculo.getPlaca().equals(placa)) {
                if (previousNode == null) {
                    // O nó a ser removido é o primeiro da lista
                    tabela[h] = currentNode.proximo;
                } else {
                    // O nó a ser removido não é o primeiro da lista
                    previousNode.proximo = currentNode.proximo;
                }
                q--;
    
                double tam = (double) q;
                double tamHash = (double) size; 
                double fatorCarga = tam / tamHash;
                EscreverLog(h, fatorCarga);
                return true; // Remoção bem-sucedida
            }
            previousNode = currentNode;
            currentNode = currentNode.proximo;
        }
    
        return false; // O nó com a placa especificada não foi encontrado
    }
    
    public boolean atualizar(String compressed) {
        // Descompressão dos dados recebidos
        String decompressed = Cliente.compressor.sempressao(compressed);
        String[] datas = decompressed.split("@");
        Veiculo updatedVehicle = new Veiculo(datas[0], datas[1], datas[2], datas[3], new Condutor(datas[4], datas[5]));
    
        String placa = updatedVehicle.getPlaca();
        int h = hash(placa);
        No currentNode = tabela[h];
        
        // Busca pelo veículo desejado para atualizar
        while (currentNode != null) {
            if (currentNode.veiculo.getPlaca().equals(placa)) {
                currentNode.veiculo = updatedVehicle; // Atualiza o veículo no nó
                return true;
            }
            currentNode = currentNode.proximo;
        }
    
        return false; // O veículo com a placa especificada não foi encontrado
    }
    

    public void imprimir() {
        No node;

        for (int i = 0; i < size; i++) {
            node = tabela[i];

            System.out.print("Endereço -> " + i);

            while (node != null) {
                System.out.println(
                        "\n\t|\n\t|\n\t|\n\tv" +
                                "\n// --------------------------------------" +
                                "\nChave: " + node.veiculo.getPlaca() +
                                "\n// --------------------------------------\n"
                );

                node = node.proximo;
            }

            System.out.println();
        }
    }

    public int getSize() {
        return size;
    }

    public int getq() {
        return q;
    }

    public void EscreverLog(int c, double fatorCarga){
        try {
            FileWriter fileWriter = new FileWriter("log.txt", true);
            fileWriter.write("Veículo Inserido no Endereço: " + c + "\n");
            fileWriter.write("Fator de Carga Atual: " + (q / size) + "\n");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
