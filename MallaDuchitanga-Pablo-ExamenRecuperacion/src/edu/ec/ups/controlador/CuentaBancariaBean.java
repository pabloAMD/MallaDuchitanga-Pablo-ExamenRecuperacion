package edu.ec.ups.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.ClienteFacade;
import ec.edu.ups.ejb.CuentaBancariaFacade;
import ec.edu.ups.modelo.Cliente;
import ec.edu.ups.modelo.CuentaBancaria;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@RequestScoped
public class CuentaBancariaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nombreC;
	@EJB
	private CuentaBancariaFacade ejbCuentaBancaria;
	private List<CuentaBancaria> list;
	
	
	private String numero;
	private String tipo;
	
	@EJB
	private ClienteFacade ejbCliente;
	private List<Cliente> clienteList;

	public CuentaBancariaBean() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void init() {
		list= ejbCuentaBancaria.findAll();
		clienteList= ejbCliente.findAll();
	}

	public CuentaBancariaFacade getEjbCuentaBancaria() {
		return ejbCuentaBancaria;
	}

	public void setEjbCuentaBancaria(CuentaBancariaFacade ejbCuentaBancaria) {
		this.ejbCuentaBancaria = ejbCuentaBancaria;
	}

	public CuentaBancaria[] getList() {
		return list.toArray(new CuentaBancaria[0]);
	}

	public void setList(List<CuentaBancaria> list) {
		this.list = list;
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

	public ClienteFacade getEjbCliente() {
		return ejbCliente;
	}

	public void setEjbCliente(ClienteFacade ejbCliente) {
		this.ejbCliente = ejbCliente;
	}

	public List<Cliente> getClienteList() {
		return clienteList;
	}

	public void setClienteList(List<Cliente> clienteList) {
		this.clienteList = clienteList;
	}
	
	public CuentaBancaria buscar() {
		CuentaBancaria cu= ejbCuentaBancaria.readCuentaBancaria(this.nombreC);
		return cu;
	}

	public String getNombreC() {
		return nombreC;
	}

	public void setNombreC(String nombreC) {
		this.nombreC = nombreC;
	}

	
	

}
