package beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import daos.UsuarioDao;
import entities.Usuario;

@ManagedBean(name = "LoginMB")
@ViewScoped
public class LoginManagedBean implements Serializable{
	private static final long serialVersionUID = 1L;

	private UsuarioDao usuarioDAO = new UsuarioDao();
	private Usuario usuario = new Usuario();

	public String envia() {

		usuario = usuarioDAO.getUsuario(usuario.getNomeUsuario(), usuario.getSenha());
		if (usuario == null) {
			usuario = new Usuario();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado!", "Erro no Login!"));
			return null;
		} else {
			return "/main";
		}

	}	
	

	public UsuarioDao getUsuarioDAO() {
		return usuarioDAO;
	}


	public void setUsuarioDAO(UsuarioDao usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}


	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
