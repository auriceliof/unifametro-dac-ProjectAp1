package beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.security.auth.callback.ConfirmationCallback;

import daos.EmailDao;
import entities.Email;
import utils.MessageUtil;

@ManagedBean
public class EmailBean {
	
	private Email Email = new Email();
	
	private List<Email> list;
	
	public String save() {
		
		try {			
			EmailDao.salvar(Email);
			MessageUtil.sucesso("Sucesso", "Email salvao com sucesso!");
			Email = new Email();
			
		} catch(Exception e) {
			MessageUtil.erro("Erro", "Erro ao salvar o Email!");
		}
		
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











