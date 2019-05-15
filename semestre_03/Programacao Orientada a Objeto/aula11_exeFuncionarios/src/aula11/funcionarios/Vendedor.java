package aula11.funcionarios;


/**
 * Classe que representa um Vendedor e implementa os m�todos abstratos definidos na classe Funcion�rio.
 * @author Gabriel Van Loon 10391607
 *
 */
public class Vendedor extends Funcionario {
	
	private double comissao;
	
	/**
	 * O Vendedor possui os mesmos atributos que um Funcion�rio comum + comissao.
	 * @param nome
	 * @param cpf
	 * @param salarioBase
	 * @param comissao
	 * @throws IllegalAccessException
	 */
	public Vendedor(String nome, String cpf, double salarioBase, double comissao) throws IllegalAccessException {
		super(nome, cpf, salarioBase);
		
		if(comissao <= 0)
			throw new IllegalArgumentException("Erro, valor de comiss�o inv�lido!");
		
		this.setComissao(comissao);
	}
	
	
	/**
	 * O sal�rio de um gerente � uma vez seu sal�rio base + sua comiss�o.
	 * @return salario
	 */
	@Override
	public double calculaSalario() {
		return getSalarioBase() + getComissao();
	}

	public double getComissao() {
		return comissao;
	}

	public void setComissao(double comissao) {
		this.comissao = comissao;
	}
	
	@Override
	public String toString() {
		String str = "";
		
		str += "\tNome:" + this.getNome() + "\n";
		str += "\tCargo: Vendedor\n";
		str += "\tCPF:" + this.getCpf() + "\n";
		str += "\tSal�rio Base: R$" + String.format("%.2f",  this.getSalarioBase()) + "\n";
		str += "\tComiss�o: R$" + String.format("%.2f", this.getComissao()) + "\n";
		
		return str;
	}
	
}
