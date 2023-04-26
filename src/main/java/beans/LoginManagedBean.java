package beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import daos.EmailDao;
import daos.UsuarioDao;

import entities.Usuario;
import utils.MessageUtil;

@ManagedBean(name = "LoginMB")
@ViewScoped
public class LoginManagedBean implements Serializable{
	private static final long serialVersionUID = 1L;

	
	private UsuarioDao usuarioDAO = new UsuarioDao();
	
	private Usuario usuario = new Usuario();
	
	private List<Usuario> list;
	
	private  String contarUsuario;
		
	public String salvar() {
			
		try {			
			UsuarioDao.salvar(usuario);
			MessageUtil.sucesso("Sucesso: ", "Usuário criado com sucesso!");
			usuario = new Usuario();
				
		} catch(Exception e) {
			MessageUtil.erro("Erro: ", "Erro ao criar usuário!");
		}
			
		return null;
		}
	
	public String editar() {		
		UsuarioDao.editar(usuario);
		usuario = new Usuario();
		return null;
	}

	public void deletar() {		
		UsuarioDao.deletar(usuario);
		list = UsuarioDao.listarTodos();
	}
	
	public String listarTodos() {		
		UsuarioDao.listarTodos();
		return null;
	}	
	
	public String envia() {

		usuario = usuarioDAO.getUsuario(usuario.getNomeUsuario(), usuario.getSenha());
		if (usuario == null) {
			usuario = new Usuario();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario ou senha inválido!", "Erro no Login!"));
			return null;
		} else {
			return "/itens_enviados";
		}

	}	
	

	public List<Usuario> getList() {
		if (list == null) {
			list = UsuarioDao.listarTodos();
		}
		return list;
	}

	public void setList(List<Usuario> list) {
		this.list = list;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getContarUsuario() {
		
		if (list == null) {
			list = UsuarioDao.listarTodos();
		}
		return Integer.toString(list.size());
	}

	public void setContarUsuario(String contarUsuario) {
		this.contarUsuario = contarUsuario;
	}	
	
	public String contarEmail() {
		return contarUsuario;	
	}	
}
