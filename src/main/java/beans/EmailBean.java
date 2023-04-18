package beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import daos.EmailDao;
import entities.Email;
import utils.MessageUtil;

@ManagedBean
@ViewScoped
public class EmailBean implements Serializable{
	private static final long serialVersionUID = 1L;

	private Email email = new Email();
	
	private List<Email> list;
	
	private  String contarEmail;
					
	public String salvar() {
		
		try {			
			EmailDao.salvar(email);
			MessageUtil.sucesso("Sucesso: ", "Email salvo com sucesso!");
			email = new Email();
			
		} catch(Exception e) {
			MessageUtil.erro("Erro: ", "Erro ao salvar o Email!");
		}
		
		return null;
	}
	
	public String editar() {		
		EmailDao.editar(email);
		email = new Email();
		return null;
	}

	public void deletar() {		
		EmailDao.deletar(email);
		list = EmailDao.listarTodos();
	}
	
	public String listarPorId() {		
		EmailDao.listarPorId(email.getId());
		return null;
	}	
	
	public String listarTodos() {		
		EmailDao.listarTodos();
		return null;
	}	
		
	public Email getEmail() {
		return email;
	}


	public void setEmail(Email email) {
		this.email = email;
	}


	public List<Email> getList() {
		if (list == null) {
			list = EmailDao.listarTodos();
		}
		return list;
	}
		
	public void setList(List<Email> list) {
		this.list = list;
	}
	
	public String getContarEmail() {
		if (list == null) {
			list = EmailDao.listarTodos();
		}
		return Integer.toString(list.size());
	}

	public void setContarEmail(String contarEmail) {
		this.contarEmail = contarEmail;
	}
	
	public String contarEmail() {
		return contarEmail;	
	}
}











