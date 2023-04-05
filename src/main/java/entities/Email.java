package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
	private String dataEnvio;
	
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
	public String getDataEnvio() {
		return dataEnvio;
	}
	public void setDataEnvio(String dataEnvio) {
		this.dataEnvio = dataEnvio;
	}
	public Boolean getConfirmaLeituraBoolean() {
		return confirmaLeitura;
	}
	public void setConfirmaLeituraBoolean(Boolean confirmaLeituraBoolean) {
		this.confirmaLeitura = confirmaLeituraBoolean;
	}
}
