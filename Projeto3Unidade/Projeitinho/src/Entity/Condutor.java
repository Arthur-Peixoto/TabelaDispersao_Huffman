package Entity;

public class Condutor {
    private String nome;
    public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	private String cpf;

    public Condutor(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }
    
    @Override
    public String toString() {
        return "Condutor: [nome=" + nome + ", cpf=" + cpf + "]";
    }
}
