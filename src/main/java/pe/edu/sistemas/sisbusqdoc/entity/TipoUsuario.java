package pe.edu.sistemas.sisbusqdoc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TIPO_USUARIO")
public class TipoUsuario {
	@Id
	@Column(name = "IDTIPO_USUARIO")
	private int id;

	@Column(name = "NOMBRE_TIPO_USUARIO")
	private String role;
	
	public TipoUsuario(int id, String role) {
		super();
		this.id = id;
		this.role = role;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TipoUsuario() {}
}
