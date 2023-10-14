package Comunicacao;

import Entity.Condutor;
import Entity.Veiculo;
import Dados.Huffman;

import java.util.Scanner;

public class Cliente {

    Protocolo protocolo;
    public static Huffman compressor;

    private static Scanner scanner = new Scanner(System.in);
    
    public Cliente(){
    	protocolo = new Protocolo("Vasco!");
        compressor = new Huffman("SuaEntradaAqui");
    }

    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.cinquentaValores();
        cliente.executar();
        scanner.close();
    }

	private void executar() {
        boolean executando = true;
        while (executando) {
            exibirMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    buscar();
                    break;
                case 2:
                    cadastrar();
                    break;
                case 3:
                    listar();
                    break;
                case 4:
                    atualizar();
                    break;
                case 5:
                    remover();
                    break;
                case 6:
                    qntVeiculos();
                    break;
                case 7:
                    encerrar();
                    executando = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("\nOpções:");
        System.out.println("1. Consultar veículo");
        System.out.println("2. Cadastrar veículo");
        System.out.println("3. Listar veículos");
        System.out.println("4. Alterar veículo");
        System.out.println("5. Remover veículo");
        System.out.println("6. Obter quantidade de veículos");
        System.out.println("7. Encerrar conexão");
        System.out.print("Escolha uma opção: ");
    }
  
    public void cinquentaValores() {
this.inserir(new Veiculo("1234567891", "ABC1234", "Fiat Uno", "01/01/2023", new Condutor("Juninho Pernambucano", "123.456.789-01")));
this.inserir(new Veiculo("987654320", "XYZ5678", "Toyota Corolla", "05/15/2023", new Condutor("Romario de Souza Faria", "987.654.321-02")));
this.inserir(new Veiculo("456789023", "DEF6789", "Honda Civic", "07/22/2023", new Condutor("Roberto Dinamite", "456.789.012-03")));
this.inserir(new Veiculo("234567801", "GHI9012", "Chevrolet Cruze", "03/10/2023", new Condutor("Felipe Loureiro", "234.567.890-04")));
this.inserir(new Veiculo("789012346", "JKL3456", "Volkswagen Golf", "09/18/2023", new Condutor("Edmundo Alves de Souza Neto", "789.012.345-05")));
this.inserir(new Veiculo("567891234", "MNO7890", "Nissan Sentra", "11/05/2023", new Condutor("Carlos Germano Schwambach", "567.890.123-06")));
this.inserir(new Veiculo("890124567", "PQR2345", "Ford Focus", "04/30/2023", new Condutor("Mauro Galvao", "890.123.456-07")));
this.inserir(new Veiculo("678902345", "STU4567", "Mazda Mazda3", "06/20/2023", new Condutor("Ademir Menezes", "678.901.234-08")));
this.inserir(new Veiculo("345678012", "VWX6789", "Kia Optima", "02/14/2023", new Condutor("Bellini", "345.678.901-09")));
this.inserir(new Veiculo("1234567890", "YZA8901", "Subaru Impreza", "08/08/2023", new Condutor("Barbosa", "012.345.678-10")));
this.inserir(new Veiculo("234568901", "BCD1234", "Hyundai Elantra", "01/07/2023", new Condutor("Eurico Miranda", "234.567.890-11")));
this.inserir(new Veiculo("456780123", "EFG5678", "Mercedes-Benz C-Class", "05/25/2023", new Condutor("Garrincha", "456.789.012-12")));
this.inserir(new Veiculo("678912345", "HIJ7890", "Audi A3", "07/14/2023", new Condutor("Carlos Alberto Torres", "678.901.234-13")));
this.inserir(new Veiculo("890134567", "KLM2345", "BMW 3 Series", "03/02/2023", new Condutor("Valdir Pereira", "890.123.456-14")));
this.inserir(new Veiculo("234567901", "NOP4567", "Lexus ES", "09/29/2023", new Condutor("Dener Augusto de Souza", "012.345.678-15")));
this.inserir(new Veiculo("467890123", "QRS6789", "Tesla Model 3", "11/18/2023", new Condutor("Bebeto", "234.567.890-16")));
this.inserir(new Veiculo("678901245", "TUV8901", "Porsche 911", "04/13/2023", new Condutor("Paulinho de Almeida", "456.789.012-17")));
this.inserir(new Veiculo("890123467", "WXY1234", "Jaguar XF", "06/06/2023", new Condutor("Mazinho", "678.901.234-18")));
this.inserir(new Veiculo("1274567890", "ZAB5678", "Volvo S60", "02/28/2023", new Condutor("Roberto Antonio Dinamite", "890.123.456-19")));
this.inserir(new Veiculo("234567631", "CDE7890", "Mitsubishi Lancer", "08/22/2023", new Condutor("Carlos Tenorio", "012.345.678-20")));
this.inserir(new Veiculo("436790123", "FGH1234", "Renault Megane", "01/15/2023", new Condutor("Zico", "234.567.890-21")));
this.inserir(new Veiculo("679012345", "IJK5678", "Acura TLX", "05/10/2023", new Condutor("Falcao", "456.789.012-22")));
this.inserir(new Veiculo("892134567", "LMN7890", "Infiniti Q50", "07/25/2023", new Condutor("Cafu", "678.901.234-23")));
this.inserir(new Veiculo("123455890", "OPQ2345", "Cadillac CT4", "03/08/2023", new Condutor("Ronaldo Nazario", "890.123.456-24")));
this.inserir(new Veiculo("234567831", "RST4567", "Chrysler 300", "09/05/2023", new Condutor("Rivaldo", "012.345.678-25")));
this.inserir(new Veiculo("464890123", "TUV6789", "Dodge Charger", "11/22/2023", new Condutor("Ricardo Kaka", "234.567.890-26")));
this.inserir(new Veiculo("678902235", "WXY8901", "Ferrari 488", "04/18/2023", new Condutor("Ronaldinho Gaucho", "456.789.012-27")));
this.inserir(new Veiculo("811234567", "ZAB2345", "Lamborghini Huracan", "06/30/2023", new Condutor("Robinho", "678.901.234-28")));
this.inserir(new Veiculo("1234567870", "CDE4567", "Maserati Ghibli", "02/03/2023", new Condutor("Coutinho", "890.123.456-29")));
this.inserir(new Veiculo("234569901", "FGH6789", "Porsche Panamera", "08/17/2023", new Condutor("Casemiro", "012.345.678-30")));
this.inserir(new Veiculo("460890123", "IJK8901", "Alfa Romeo Giulia", "01/20/2023", new Condutor("Dida", "234.567.890-31")));
this.inserir(new Veiculo("678911235", "LMN9012", "Aston Martin Vantage", "05/03/2023", new Condutor("Taffarel", "456.789.012-32")));
this.inserir(new Veiculo("800234567", "OPQ1234", "Bentley Continental GT", "07/01/2023", new Condutor("Bebeto", "678.901.234-33")));
this.inserir(new Veiculo("1234568890", "RST5678", "Bugatti Chiron", "03/30/2023", new Condutor("Zico", "890.123.456-34")));
this.inserir(new Veiculo("234587901", "TUV9012", "Ferrari 812 Superfast", "09/10/2023", new Condutor("Falcao", "012.345.678-35")));
this.inserir(new Veiculo("467820123", "OPQ5678", "Jaguar F-Type", "11/29/2023", new Condutor("Cafu", "234.567.890-36")));
this.inserir(new Veiculo("678901235", "RST9012", "Lamborghini Aventador", "04/24/2023", new Condutor("Ronaldo Nazario", "456.789.012-37")));
this.inserir(new Veiculo("801234567", "OPQ9012", "Maserati GranTurismo", "06/15/2023", new Condutor("Rivaldo", "678.901.234-38")));
this.inserir(new Veiculo("1234567820", "ABC5678", "McLaren 720S", "02/10/2023", new Condutor("Ricardo Kaka", "890.123.456-39")));
this.inserir(new Veiculo("234567805", "XYZ9012", "Pagani Huayra", "08/05/2023", new Condutor("Ronaldinho Gaucho", "012.345.678-40")));
this.inserir(new Veiculo("456790123", "FGH9012", "Porsche 911 GT3", "10/12/2023", new Condutor("Robinho", "234.567.890-41")));
this.inserir(new Veiculo("672912345", "LMN5678", "Rolls-Royce Phantom", "04/07/2023", new Condutor("Coutinho", "456.789.012-42")));
this.inserir(new Veiculo("890934567", "OPQ2345", "Tesla Model S", "06/28/2023", new Condutor("Casemiro", "678.901.234-43")));
this.inserir(new Veiculo("111111111", "AAA1111", "Marca 1", "01/01/2023", new Condutor("Condutor 1", "111.111.111-01")));
this.inserir(new Veiculo("222222222", "BBB2222", "Marca 2", "02/02/2023", new Condutor("Condutor 2", "222.222.222-02")));
this.inserir(new Veiculo("333333333", "CCC3333", "Marca 3", "03/03/2023", new Condutor("Condutor 3", "333.333.333-03")));
this.inserir(new Veiculo("444444444", "DDD4444", "Marca 4", "04/04/2023", new Condutor("Condutor 4", "444.444.444-04")));
this.inserir(new Veiculo("555555555", "EEE5555", "Marca 5", "05/05/2023", new Condutor("Condutor 5", "555.555.555-05")));
this.inserir(new Veiculo("666666666", "FFF6666", "Marca 6", "06/06/2023", new Condutor("Condutor 6", "666.666.666-06")));
this.inserir(new Veiculo("777777777", "GGG7777", "Marca 7", "07/07/2023", new Condutor("Condutor 7", "777.777.777-07")));

}

	private void inserir(Veiculo veiculo) {
        if (veiculo == null){
            System.out.println("Veiculo nulo");
        }
        else{
        String comprimidinha = compressor.compressao(veiculo.toStringFormatted());
        if  (comprimidinha == null){
            System.out.println("Veiculo nulo");
        }
		protocolo.cadastrarVeiculo(comprimidinha);
        }
	}
	
	private void buscar() {
	System.out.print("Digite a placa do veículo: ");
    String placa = scanner.nextLine();
    Veiculo veiculo = protocolo.buscarVeiculos(placa);
    if (veiculo != null) {
        System.out.println("Veículo encontrado:");
        System.out.println(veiculo);
    } else {
        System.out.println("Veículo não encontrado.");
    	}
    }
	
	private void cadastrar() {
		System.out.println("Digite os dados do veículo:");
        System.out.print("Placa: ");
        String Placa = scanner.nextLine();
        System.out.print("Renavam: ");
        String novoRenavam = scanner.nextLine();
        scanner.nextLine();
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Cpf do condutor: ");
        String CpfCondutor = scanner.nextLine();
        System.out.print("Nome do condutor: ");
        String Nomecondutor = scanner.nextLine();
        Veiculo novoVeiculo = new Veiculo(novoRenavam,Placa, marca, modelo, new Condutor(Nomecondutor,CpfCondutor));
        String comprimidinha= compressor.compressao(novoVeiculo.toStringFormatted());
        
        if (protocolo.cadastrarVeiculo(comprimidinha)) {
            System.out.println("Veículo cadastrado com sucesso.");
        } else {
            System.out.println("Falha ao cadastrar veículo.");
        }
	}
	
	private void atualizar() {
		System.out.print("Digite o renavam do veículo a ser alterado: ");
        String renavamAlteracao = scanner.nextLine();
        scanner.nextLine();
        Veiculo veiculoAlteracao = protocolo.buscarVeiculos(renavamAlteracao);
        if (veiculoAlteracao != null) {
            System.out.println("Digite os novos dados do veículo:");
            System.out.print("Placa: ");
            String novaPlava = scanner.nextLine();
            System.out.print("Modelo: ");
            String novoModelo = scanner.nextLine();
            System.out.print("Cpf do condutor: ");
            String novoCPF = scanner.nextLine();
            System.out.print("Nome do condutor: ");
            String novoNome = scanner.nextLine();
            System.out.print("Data de fabricação: ");
            String novaData = scanner.nextLine();
            veiculoAlteracao.setPlaca(novaPlava);
            veiculoAlteracao.setDataFabricacao(novaData);
            veiculoAlteracao.setModelo(novoModelo);
            veiculoAlteracao.setCondutor(novoNome, novoCPF);
            System.out.println("Veículo alterado com sucesso.");
        } else {
            System.out.println("Veículo não encontrado.");
        }
	}
	
	private void listar() {
		System.out.println("Lista de veículos:");
        protocolo.listarVeiculos();
    }
	
	private void remover() {
		System.out.print("Digite o renavam do veículo a ser removido: ");
        String renavamRemocao = scanner.nextLine();
        Veiculo veiculoRemocao = protocolo.buscarVeiculos(renavamRemocao);
        if (veiculoRemocao != null) {
            protocolo.removerVeiculo(veiculoRemocao);
            System.out.println("Veículo removido com sucesso.");
        } else {
            System.out.println("Veículo não encontrado.");
        }
	}
	
	private void qntVeiculos() {
        int quantidade = protocolo.qntVeiculos();
        System.out.println("Quantidade de veículos cadastrados: " + quantidade);
    }

    private void encerrar() {
        String mensagemEncerramento = protocolo.encerrarConexao();
        System.out.println(mensagemEncerramento);
    }
}