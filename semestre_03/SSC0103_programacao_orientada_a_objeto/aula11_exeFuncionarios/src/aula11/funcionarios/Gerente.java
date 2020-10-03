package aula11.funcionarios;

/**
 * Classe que representa um Gerente e implementa os m�todos abstratos definidos na classe Funcion�rio.
 * @author Gabriel Van Loon 10391607
 *
 */
public class Gerente extends Funcionario{
	
	/**
	 * Construtor do gerente.
	 * @param nome
	 * @param cpf
	 * @param salarioBase
	 * @throws IllegalAccessException
	 */
	public Gerente(String nome, String cpf, double salarioBase) throws IllegalAccessException {
		super(nome, cpf, salarioBase);
	}
	
	/**
	 * O sal�rio de um gerente � duas vezes seu sal�rio base.
	 * @return salario
	 */
	@Override
	public double calculaSalario() {
		return (2.0 * getSalarioBase());
	}
	
	@Override
	public String toString() {
		String str = "";
		
		str += "\tNome:" + this.getNome() + "\n";
		str += "\tCargo: Gerente\n";
		str += "\tCPF:" + this.getCpf() + "\n";
		str += "\tSal�rio Base: R$" + String.format("%.2f",  this.getSalarioBase()) + "\n";
		
		return str;
	}

}
