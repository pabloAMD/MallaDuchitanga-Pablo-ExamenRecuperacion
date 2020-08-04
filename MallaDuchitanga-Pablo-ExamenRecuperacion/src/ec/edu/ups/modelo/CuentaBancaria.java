package ec.edu.ups.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


import javax.persistence.*;

/**
 * Entity implementation class for Entity: CuentaBancaria
 *
 */
@NamedQuery(name = "getByCuentaBancaria", query = "SELECT c FROM CuentaBancaria c WHERE c.numero=:cedula")
@Entity

public class CuentaBancaria implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String numero;
	private String tipo;
	private double saldo;
	
	@ManyToOne
	@JoinColumn
	private Cliente cliente;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cuentaBancariaD")
	private Set<Deposito> citaMedicaListD= new HashSet<Deposito>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cuentaBancariaR")
	private Set<Retiro> citaMedicaListR= new HashSet<Retiro>();

	public CuentaBancaria() {
		super();
	}
	
	
	


	public CuentaBancaria(String numero, String tipo, Cliente cliente, double saldo) {
		super();
		this.numero = numero;
		this.tipo = tipo;
		this.cliente = cliente;
		this.saldo=saldo;
	}


	


	public double getSaldo() {
		return saldo;
	}





	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}





	public Set<Deposito> getCitaMedicaListD() {
		return citaMedicaListD;
	}





	public void setCitaMedicaListD(Set<Deposito> citaMedicaListD) {
		this.citaMedicaListD = citaMedicaListD;
	}





	public Set<Retiro> getCitaMedicaListR() {
		return citaMedicaListR;
	}





	public void setCitaMedicaListR(Set<Retiro> citaMedicaListR) {
		this.citaMedicaListR = citaMedicaListR;
	}





	public String getNumero() {
		return numero;
	}




	public void setNumero(String numero) {
		this.numero = numero;
	}




	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CuentaBancaria other = (CuentaBancaria) obj;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}

	
	
	
   
}
