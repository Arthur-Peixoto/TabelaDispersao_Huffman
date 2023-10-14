package Comunicacao;

import Entity.Veiculo;

public class Protocolo {
	
	public static Object compressor;
	Server servidor;
	
	public Protocolo(String mensagem) {
		System.out.println(mensagem);
		servidor = new Server();
	}
	
	public Veiculo buscarVeiculos(String renavam) {
		return servidor.consultarVeiculo(renavam);
	}
	
	public boolean cadastrarVeiculo(String veiculo) {
		return servidor.cadastrarVeiculo(veiculo);
	}
	
	public void removerVeiculo(Veiculo veiculo) {
		String renavam = veiculo.getRenavam();
		servidor.removerVeiculo(renavam);
	}
	
	public void listarVeiculos() {
		servidor.listarVeiculos();
	}
	
	public String encerrarConexao() {
		System.out.println("Protocolo encerrado");
		return servidor.encerrarConexao();
	}

	public int qntVeiculos() {
		// TODO Auto-generated method stub
		return 0;
	}
}
