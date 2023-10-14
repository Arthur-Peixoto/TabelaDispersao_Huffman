package Dados;

import java.util.Arrays;

import Dados.Heap.Node;

public class Huffman {
    private Node raiz; // Árvore de Huffman
    private String[] codes = new String[128]; // Vetor de códigos para caracteres

    // Construtor da classe Huffman
    public Huffman(String data) {
        buildTreeFromdata(data); // Constrói a árvore a partir da entrada
    }

    // Constrói a árvore de Huffman com base na entrada
    private void buildTreeFromdata(String data) {
        char[] charArray = getCharacters(data); // Obtém os caracteres únicos da entrada
        Arrays.sort(charArray); // Ordena os caracteres em ordem lexicográfica
        int[] caracterFC = getFrequencies(data); // Calcula as frequências de cada caractere
        buildTree(charArray.length, charArray, caracterFC); // Constrói a árvore
    }

    // Constrói a árvore de Huffman a partir dos caracteres e frequências
    public void buildTree(int n, char[] charArray, int[] fcArray) {
        Heap heapMinimo = new Heap(); // Cria uma fila de prioridade mínima para a construção da árvore
        Node node;

        // Insere os caracteres e suas frequências na fila de prioridade mínima
        for (int i = 0; i < n; i++) {
            node = heapMinimo.new Node();
            node.caracter = charArray[i];
            node.fc = fcArray[i];
            node.prev = null;
            node.next = null;
            heapMinimo.insert(node);
        }

        raiz = null; // Inicializa a raiz da árvore

        // Constrói a árvore combinando os nós com as menores frequências
        while (heapMinimo.size() > 1) {
            Node x = heapMinimo.remove();
            Node y = heapMinimo.remove();
            Node z = heapMinimo.new Node();
            z.fc = x.fc + y.fc;
            z.caracter = '-';
            z.prev = x;
            z.next = y;
            raiz = z;
            heapMinimo.insert(z);
        }
        buildCodeArray(raiz, "");
    }

    // Comprime uma sequência de caracteres usando a árvore de Huffman
    public String compressao(String data) {
        if (raiz == null) {
            buildTreeFromdata(data); // Constrói a árvore se ainda não foi construída
        }
        char[] charArray = getCharacters(data); // Obtém os caracteres únicos da entrada
        Arrays.sort(charArray); // Ordena os caracteres em ordem lexicográfica
        int[] caracterFC = getFrequencies(data); // Calcula as frequências de cada caractere
        buildTree(charArray.length, charArray, caracterFC); // Constrói a árvore
        String compressed = "";
        for (int i = 0; i < data.length(); i++) {
            char character = data.charAt(i);
            compressed += codes[character]; // Adiciona o código do caractere à saída comprimida
        }
        return compressed;
    }

    // Descomprime uma sequência de bits usando a árvore de Huffman
    public String sempressao(String compressed) {
        if (raiz == null) {
            buildTreeFromdata(compressed); // Constrói a árvore se ainda não foi construída
        }
        String decompressed = "";
        Node current = raiz;
        int currentIndex = 0;

        // Percorre a sequência de bits e navega na árvore para encontrar os caracteres
        while (currentIndex < compressed.length()) {
            char bit = compressed.charAt(currentIndex);

            if (bit == '0') {
                current = current.prev;
            } else if (bit == '1') {
                current = current.next;
            }

            if (current.prev == null && current.next == null) {
                decompressed += current.caracter; // Adiciona o caractere descomprimido à saída
                current = raiz; // Reinicia a navegação na árvore a partir da raiz
            }

            currentIndex++;
        }

        return decompressed;
    }

    // Constrói o vetor de códigos para caracteres recursivamente na árvore
    private void buildCodeArray(Node node, String currentCode) {
        if (node == null) {
            return;
        }

        if (node.prev == null && node.next == null) {
            codes[node.caracter] = currentCode;
        }

        buildCodeArray(node.prev, currentCode + "0");
        buildCodeArray(node.next, currentCode + "1");
    }

    // Obtém os caracteres únicos da entrada
    private char[] getCharacters(String data) {
        boolean[] jaExistem = new boolean[128];
        StringBuilder BuilderUnicos = new StringBuilder();

        for (int i = 0; i < data.length(); i++) {
            char currentChar = data.charAt(i);
            if (!jaExistem[currentChar]) {
                jaExistem[currentChar] = true;
                BuilderUnicos.append(currentChar);
            }
        }

        char[] uniqueChars = new char[BuilderUnicos.length()];
        BuilderUnicos.getChars(0, BuilderUnicos.length(), uniqueChars, 0);

        return uniqueChars;
    }

    // Calcula as frequências de cada caractere na entrada
    private int[] getFrequencies(String data) {
        int[] caracterFC = new int[128];

        for (int i = 0; i < data.length(); i++) {
            char currentChar = data.charAt(i);
            if (currentChar >= 0 && currentChar <= 127) {
                caracterFC[currentChar]++;
            }
        }

        caracterFC = removeZeros(caracterFC);
        return caracterFC;
    }

    // Remove elementos zero de um vetor de frequências
    private int[] removeZeros(int[] array) {
        int nonZeroCount = 0;
        for (int value : array) {
            if (value != 0) {
                nonZeroCount++;
            }
        }

        int[] nonZeroArray = new int[nonZeroCount];
        int index = 0;
        for (int value : array) {
            if (value != 0) {
                nonZeroArray[index++] = value;
            }
        }

        return nonZeroArray;
    }
}
