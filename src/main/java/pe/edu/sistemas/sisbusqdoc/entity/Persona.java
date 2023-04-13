package pe.edu.sistemas.sisbusqdoc.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;

@Entity
@Table(name="PERSONA")
public class Persona {
	
	@Id
	@Column(name = "ID_PERSONA")
	private int id;
	@Column(name="PERSONA_CODIGO")
	private String codigo;
	@Column(name="PERSONA_NOMBRE")
	private String nombre;
	@Column(name="PERSONA_APPATERNO")
	private String apellidoPaterno;
	@Column(name="PERSONA_APMATERNO")
	private String apellidoMaterno;
	@Formula(value = "CONCAT(PERSONA_NOMBRE,' ' ,PERSONA_APPATERNO,' ' ,PERSONA_APMATERNO)")
	private String fullName;
	
	@Column(name = "PERSONA_CODIGO_SISTEMA")
	private String username;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
	private Set<UserRole> userRoles = new HashSet<UserRole>();
	
	@Column(name = "PERSONA_PASSWORD_SISTEMA2")
	private String password;
	
	public Persona(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public Persona(String username, Set<UserRole> userRoles, String password) {
		super();
		this.username = username;
		this.userRoles = userRoles;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Set<UserRole> getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Persona(int id, String codigo, String nombre, String apellidoPaterno, String apellidoMaterno) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
	}
	public Persona() {
		super();
	}
	
	
}
