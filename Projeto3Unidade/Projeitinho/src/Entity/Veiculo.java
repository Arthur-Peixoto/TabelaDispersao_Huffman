package Entity;

public class Veiculo {
    private String placa;
    public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getRenavam() {
		return renavam;
	}

	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(String dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	private String renavam;
	
    public Condutor getCondutor() {
		return condutor;
	}

	public void setCondutor(String nome, String cpf) {
		this.condutor = new Condutor(nome, cpf);
	}

	private Condutor condutor;
    private String modelo;
    private String dataFabricacao;

    public Veiculo(String renavam, String placa, String modelo, String dataFabricacao, Condutor condutor) {
        this.placa = placa;
        this.renavam = renavam;
        this.condutor = condutor;
        this.modelo = modelo;
        this.dataFabricacao = dataFabricacao;
    }

    public String toString() {
        return "Veiculo{" +
                "placa='" + placa + '\'' +
                ", renavam='" + renavam + '\'' +
                 condutor +
                ", modelo='" + modelo + '\'' +
                ", Data de fabricação=" + dataFabricacao +
                '}';
    }
    
	public String toStringFormatted() {
		return this.getRenavam() + "@" + this.getPlaca()  + "@" + this.getModelo() + "@" + this.getDataFabricacao() + "@" + condutor.getNome() + "@" + condutor.getCpf();
	}

}