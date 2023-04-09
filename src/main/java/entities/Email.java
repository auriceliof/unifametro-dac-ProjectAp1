package entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Email {

	@Id
	@GeneratedValue
	private Integer id;
	private String destinatario;
	private String corpo;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "data_envio")	
	private Date dataEnvio;
	
	@Column(name = "confirma_leitura")
	private Boolean confirmaLeitura;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDestinatario() {
		return destinatario;
	}
	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}
	public String getCorpo() {
		return corpo;
	}
	public void setCorpo(String corpo) {
		this.corpo = corpo;
	}
	public Date getDataEnvio() {
		return dataEnvio;
	}
	public void setDataEnvio(Date dataEnvio) {
		this.dataEnvio = dataEnvio;
	}
	public Boolean getConfirmaLeitura() {
		return confirmaLeitura;
	}
	public void setConfirmaLeitura(Boolean confirmaLeitura) {
		this.confirmaLeitura = confirmaLeitura;
	}
}
