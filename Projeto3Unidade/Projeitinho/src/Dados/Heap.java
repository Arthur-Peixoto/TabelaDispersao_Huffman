package Dados;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Heap {

    // Lista de nós da heap
    List<Node> listNos;

    // Gerador de números aleatórios para uso em operações na heap
    private Random random = new Random();

    public Heap() {
        this.listNos = new ArrayList<Node>();
    }


    // Método para subir elementos na heap após inserção
    public void rise(int i) {
        int indexFather; // Índice do pai do elemento em i
        Node temp;

        indexFather = (int)((i - 1) / 2);// Método auxiliar para arredondar um número decimal para o inteiro mais próximo

        // Se o pai existe e o valor do elemento atual for menor do que o valor do pai, troque-os
        if (indexFather >= 0 && this.listNos.get(i).getFc() < this.listNos.get(indexFather).getFc()) {
            // Troca de posição
            temp = this.listNos.get(i);
            this.listNos.set(i, this.listNos.get(indexFather));
            this.listNos.set(indexFather, temp);

            // Verifica se o valor do pai também precisa subir recursivamente
            rise(indexFather);
        } else if (indexFather >= 0 && this.listNos.get(i).getFc() == this.listNos.get(indexFather).getFc()) {
            // Em caso de empate, use um valor aleatório para decidir a troca
            int test = random.nextInt(2);

            if (test == 0) {
                temp = this.listNos.get(i);
                this.listNos.set(i, this.listNos.get(indexFather));
                this.listNos.set(indexFather, temp);

                // Verifica se o valor do pai também precisa subir recursivamente
                rise(indexFather);
            }
        }
    }

    // Método para descer elementos na heap após remoção ou construção da heap
    public void descend(int i, int tamHeap) {
        int indexSon; // Índice do filho de i
        Node temp;

        // Gera um número aleatório 0 ou 1
        int test = random.nextInt(2);

        indexSon = (2 * i + 1);

        if (indexSon < tamHeap) {
            if (indexSon < tamHeap - 1) {
                // Se houver dois filhos, selecione o menor
                if (this.listNos.get(indexSon).getFc() > this.listNos.get(indexSon + 1).getFc()) {
                    indexSon++;
                } else if (this.listNos.get(indexSon).getFc() == this.listNos.get(indexSon + 1).getFc()) {
                    // Em caso de empate, escolha aleatoriamente
                    if (test == 0) {
                        indexSon++;
                    }
                }
            }

            // Se o filho for menor que o pai, troque de posição
            if (this.listNos.get(indexSon).getFc() < this.listNos.get(i).getFc()) {
                temp = this.listNos.get(i);
                this.listNos.set(i, this.listNos.get(indexSon));
                this.listNos.set(indexSon, temp);

                // Verifica se o valor do filho também precisa descer recursivamente
                descend(indexSon, tamHeap);
            } else if (this.listNos.get(indexSon).getFc() == this.listNos.get(i).getFc()) {
                // Em caso de empate, escolha aleatoriamente
                if (test == 0) {
                    temp = this.listNos.get(i);
                    this.listNos.set(i, this.listNos.get(indexSon));
                    this.listNos.set(indexSon, temp);
                }
            }
        }
    }

    // Método para inserir um nó na heap
    public void insert(Node element) {
        int tamHeap = this.listNos.size();

        if (tamHeap == 0) {
            this.listNos.add(element);
        } else {
            listNos.add(element);
            rise(tamHeap - 1);
        }
    }

    // Método para remover e retornar o nó com o menor valor na heap
    public Node remove() {
        Node deleted = listNos.get(0);
        int tamHeap = this.listNos.size();

        if (listNos.size() != 0) {
            this.listNos.set(0, this.listNos.get(tamHeap - 1));
            this.listNos.remove(tamHeap - 1);
            descend(0, --tamHeap);
            return deleted;
        }

        return null;
    }

    // Método para construir a heap
    public void build() {
        int tamHeap = this.listNos.size();

        for (int i = ((tamHeap - 1) / 2); i >= 0; i--) {
            descend(i, tamHeap);
        }
    }

    // Método para ordenar a heap (HeapSort)
    public void heapsort() {
        int tamHeap = listNos.size();
        int tamCurrente = tamHeap;

        build();

        Node temp;
        for (int i = tamHeap - 1; i >= 0; i--) {
            temp = listNos.get(i);
            listNos.set(i, listNos.get(0));
            listNos.set(0, temp);

            tamCurrente--;
            descend(0, tamCurrente);
        }
    }

    // Método para mostrar os nós da heap
    public void showProcess() {
        for (int i = 0; i < listNos.size(); i++) {
            System.out.println(listNos.get(i));
        }
    }

    // Getter para obter a lista de nós
    public List<Node> getList() {
        return listNos;
    }

    // Getter para obter o tamanho da heap
    public int size() {
        return listNos.size();
    }

    // Getter para obter o primeiro nó da heap
    public Node getFirst() {
        return listNos.get(0);
    }

    // Setter para definir a lista de nós
    public void setListProcess(List<Node> listNos) {
        this.listNos = listNos;
    }

    // Classe interna representando um nó na heap
    class Node {
        int fc;
        char caracter;
        Node next;
        Node prev;

        public char getCharacter() {
            return caracter;
        }

        public void setCharacter(char character) {
            this.caracter = character;
        }

        public int getFc() {
            return fc;
        }

        public void setFc(int fc) {
            this.fc = fc;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }


        @Override
        public String toString() {
            return "Node [character=" + caracter + ", fc=" + fc + "]";
        }
    }
}
