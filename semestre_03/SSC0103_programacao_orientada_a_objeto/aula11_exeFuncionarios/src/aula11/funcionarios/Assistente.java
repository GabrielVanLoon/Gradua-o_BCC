package aula11.funcionarios;

/**
 * Classe que representa um Assistente e implementa os m�todos abstratos definidos na classe Funcion�rio.
 * @author Gabriel Van Loon 10391607
 *
 */
public class Assistente extends Funcionario {
	
	/**
	 * Construtor do Assistente.
	 * @param nome
	 * @param cpf
	 * @param salarioBase
	 * @throws IllegalAccessException
	 */
	public Assistente(String nome, String cpf, double salarioBase) throws IllegalAccessException {
		super(nome, cpf, salarioBase);
	}
	
	
	/**
	 * O sal�rio de um gerente � uma vez seu sal�rio base.
	 * @return salario
	 */
	@Override
	public double calculaSalario() {
		return (1.0 * getSalarioBase());
	}
	
	@Override
	public String toString() {
		String str = "";
		
		str += "\tNome:" + this.getNome() + "\n";
		str += "\tCargo: Assistente\n";
		str += "\tCPF:" + this.getCpf() + "\n";
		str += "\tSal�rio Base: R$" + String.format("%.2f",  this.getSalarioBase()) + "\n";
		
		return str;
	}
}
