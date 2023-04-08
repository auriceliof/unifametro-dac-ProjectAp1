package beans;

import java.util.List;

import javax.faces.bean.ManagedBean;

import daos.EmailDao;
import entities.Email;
import utils.MessageUtil;

@ManagedBean
public class EmailBean {
	
	private Email Email = new Email();
	
	private List<Email> list;
	
	public String salvar() {
		
		try {			
			EmailDao.salvar(Email);
			MessageUtil.sucesso("Sucesso: ", "Email salvo com sucesso!");
			Email = new Email();
			
		} catch(Exception e) {
			MessageUtil.erro("Erro: ", "Erro ao salvar o Email!");
		}
		
		return null;
	}
	
	public String editar() {
		EmailDao.editar(Email);
		return null;
	}

	public String deletar() {		
		EmailDao.editar(Email);
		return null;
	}
	
	public String listarPorId() {
		EmailDao.listarPorId(Email.getId());
		return null;
	}

	
	public Email getEmail() {
		return Email;
	}


	public void setEmail(Email Email) {
		this.Email = Email;
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
}











