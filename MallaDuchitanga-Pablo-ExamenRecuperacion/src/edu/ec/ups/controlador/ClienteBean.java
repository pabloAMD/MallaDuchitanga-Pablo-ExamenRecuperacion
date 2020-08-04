package edu.ec.ups.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.ClienteFacade;
import ec.edu.ups.modelo.Cliente;


@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@RequestScoped
public class ClienteBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String cedula1;
	@EJB
	private ClienteFacade ejbCliente;
	private List<Cliente> list;
	
	private String cedula;
	private String nombre;
	private String apellido;
	private String telefono;
	private String direccion;
	private String correo;
	
	
	public ClienteBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void init() {
		list= ejbCliente.findAll();
	}

	public ClienteFacade getEjbCliente() {
		return ejbCliente;
	}

	public void setEjbCliente(ClienteFacade ejbCliente) {
		this.ejbCliente = ejbCliente;
	}

	public Cliente[] getList() {
		return list.toArray(new Cliente[0]);
	}

	public void setList(List<Cliente> list) {
		this.list = list;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public Cliente encontrar() {
		Cliente c = ejbCliente.readCliente(this.cedula1);
		return c;
	}

	public String getCedula1() {
		return cedula1;
	}

	public void setCedula1(String cedula1) {
		this.cedula1 = cedula1;
	}
	
	
	
}
