package pe.edu.sistemas.sisbusqdoc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIO")
public class UserRole {
	
	@Id
	@Column(name = "ID_USUARIO")
	private int userRoleId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "TIPO_USUARIO_IDTIPO_USUARIO", referencedColumnName="IDTIPO_USUARIO")
	private TipoUsuario tipoUsuario;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PERSONA_ID_PERSONA",referencedColumnName="ID_PERSONA")
	private Persona user;

	public int getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public Persona getUser() {
		return user;
	}

	public void setUser(Persona user) {
		this.user = user;
	}

	public UserRole(TipoUsuario tipoUsuario, Persona user) {
		super();
		this.tipoUsuario = tipoUsuario;
		this.user = user;
	}

	public UserRole() {
	}
}
