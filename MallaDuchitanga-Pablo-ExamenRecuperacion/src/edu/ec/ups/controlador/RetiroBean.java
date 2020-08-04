package edu.ec.ups.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.CuentaBancariaFacade;
import ec.edu.ups.ejb.RetiroFacade;
import ec.edu.ups.modelo.CuentaBancaria;
import ec.edu.ups.modelo.Deposito;
import ec.edu.ups.modelo.Retiro;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@RequestScoped
public class RetiroBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String cedula;
	@EJB
	private RetiroFacade ejbRetiro;
	private List<Retiro> list;
	
	private String fecha;
	private String hora;
	
	private String descripcion;
	private double montoTotal;
	
	@EJB
	private CuentaBancariaFacade ejbCuentaBancaria;
	private List<CuentaBancaria> cuentaBancariaList;

	public RetiroBean() {
		// TODO Auto-generated constructor stub
	}
	

	@PostConstruct
	public void init() {
		list= ejbRetiro.findAll();
		cuentaBancariaList= ejbCuentaBancaria.findAll();
	}


	public RetiroFacade getEjbRetiro() {
		return ejbRetiro;
	}


	public void setEjbRetiro(RetiroFacade ejbRetiro) {
		this.ejbRetiro = ejbRetiro;
	}


	public Retiro[] getList() {
		return list.toArray(new Retiro[0]);
	}


	public void setList(List<Retiro> list) {
		this.list = list;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public String getHora() {
		return hora;
	}


	public void setHora(String hora) {
		this.hora = hora;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public double getMontoTotal() {
		return montoTotal;
	}


	public void setMontoTotal(double montoTotal) {
		this.montoTotal = montoTotal;
	}


	public CuentaBancariaFacade getEjbCuentaBancaria() {
		return ejbCuentaBancaria;
	}


	public void setEjbCuentaBancaria(CuentaBancariaFacade ejbCuentaBancaria) {
		this.ejbCuentaBancaria = ejbCuentaBancaria;
	}


	public List<CuentaBancaria> getCuentaBancariaList() {
		return cuentaBancariaList;
	}


	public void setCuentaBancariaList(List<CuentaBancaria> cuentaBancariaList) {
		this.cuentaBancariaList = cuentaBancariaList;
	}


	public String getCedula() {
		return cedula;
	}


	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	
	public String add() {
		CuentaBancaria c= ejbCuentaBancaria.readCuentaBancaria(this.cedula);
		ejbRetiro.create(new Retiro(this.fecha, this.hora, this.descripcion, this.montoTotal, c));	
		list = ejbRetiro.findAll();
		return null;
	}

}
