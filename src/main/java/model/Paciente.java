/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.annotations.Editor;
import entities.annotations.PropertyDescriptor;
import entities.annotations.View;
import entities.annotations.Views;
import entities.descriptor.PropertyType;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Java
 */
@Entity
@NamedQueries(
        @NamedQuery(name= "pacienteNamedQuery",
        query = ""
        + "Select u"
        + " From Paciente u"
        +" Order By u.nomeCompletoPaciente" ))
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = {"nomeCompletoPaciente", "nomeDaMaePaciente"},
    name = "Paciente")
})

@Views({
            @View(name = "Pacientes", title = "Pacientes",
            filters = "Pesquisar Por:[nomeCompletoPaciente, nomeDaMaePaciente, Ctrl.DAO.filter()]",
            members = "["
            + "foto;"
            + "nomeCompletoPaciente; "
            + "sexoPaciente;"
            + "dataDeNascimentoPaciente;"
            + "nomeDaMaePaciente;"
            + "enderecoPaciente; "
            + "numeroPaciente;"
            + "bairroPaciente;"
            + "telefonePaciente;"
            + "]",
            namedQuery = "pacienteNamedQuery",
            template = "@CRUD+@PAGER",
            roles = "Administrador,Odontologo,Atendente")})

public class Paciente implements Serializable {

    public enum Sexo {

             MASCULINO, FEMININO

    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @PropertyDescriptor(index = 1, hidden = true)
    private Long idPaciente;
    
    
    @Lob
    @Column(length=10240) // 10kb
    @Editor(propertyType=PropertyType.IMAGE)
    private byte[] foto;

    
    @Column(length = 60)
    @PropertyDescriptor(index = 2, displayName="Nome Completo", autoFilter = true)
    @NotEmpty(message = "Informe o nome completo do paciente")
    private String nomeCompletoPaciente;

   
    @PropertyDescriptor(index = 3,displayName="Sexo")
    //@NotNull(message = "Informe o sexo do paciente")
    private Sexo sexoPaciente;
    
    @Past
    @PropertyDescriptor(index = 4, displayName="Data de Nascimento")
    @NotNull(message = "Informe a data de nascimento do paciente")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataDeNascimentoPaciente;

    
    @Column(length = 60)
    @PropertyDescriptor(index = 5, displayName = "Nome da Mãe",autoFilter = true)
    @NotEmpty(message = "Informe o nome completo da Mãe")
    private String nomeDaMaePaciente;

    
    @Column(length = 60)
    @PropertyDescriptor(index = 6, displayName = "Endereço",autoFilter = true)
    @NotEmpty(message = "Informe o endereço do paciente")
    private String enderecoPaciente;

    @Column(length = 10)
    @PropertyDescriptor(index = 7, displayName = "Número")
    private Integer numeroPaciente;

    @Column(length = 30)
    @PropertyDescriptor(index = 8, displayName="Bairro")
    private String bairroPaciente;

    @Column(length = 15)
    @PropertyDescriptor(index = 9, mask="(99)9999-9999", displayName="Telefone")
    private String telefonePaciente;

    public String getBairroPaciente() {
        return bairroPaciente;
    }

    public void setBairroPaciente(String bairroPaciente) {
        this.bairroPaciente = bairroPaciente;
    }

    public Date getDataDeNascimentoPaciente() {
        return dataDeNascimentoPaciente;
    }

    public void setDataDeNascimentoPaciente(Date dataDeNascimentoPaciente) {
        this.dataDeNascimentoPaciente = dataDeNascimentoPaciente;
    }

    public String getEnderecoPaciente() {
        return enderecoPaciente;
    }

    public void setEnderecoPaciente(String enderecoPaciente) {
        this.enderecoPaciente = enderecoPaciente;
    }

    public Long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNomeCompletoPaciente() {
        return nomeCompletoPaciente;
    }

    public void setNomeCompletoPaciente(String nomeCompletoPaciente) {
        this.nomeCompletoPaciente = nomeCompletoPaciente;
    }

    public String getNomeDaMaePaciente() {
        return nomeDaMaePaciente;
    }

    public void setNomeDaMaePaciente(String nomeDaMaePaciente) {
        this.nomeDaMaePaciente = nomeDaMaePaciente;
    }

    public Integer getNumeroPaciente() {
        return numeroPaciente;
    }

    public void setNumeroPaciente(Integer numeroPaciente) {
        this.numeroPaciente = numeroPaciente;
    }

    public Sexo getSexoPaciente() {
        return sexoPaciente;
    }

    public void setSexoPaciente(Sexo sexoPaciente) {
        this.sexoPaciente = sexoPaciente;
    }

    public String getTelefonePaciente() {
        return telefonePaciente;
    }

    public void setTelefonePaciente(String telefonePaciente) {
        this.telefonePaciente = telefonePaciente;
    }

    public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	@Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Paciente other = (Paciente) obj;
        if ((this.nomeCompletoPaciente == null) ? (other.nomeCompletoPaciente != null) : !this.nomeCompletoPaciente.equals(other.nomeCompletoPaciente)) {
            return false;
        }
        if ((this.nomeDaMaePaciente == null) ? (other.nomeDaMaePaciente != null) : !this.nomeDaMaePaciente.equals(other.nomeDaMaePaciente)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + (this.nomeCompletoPaciente != null ? this.nomeCompletoPaciente.hashCode() : 0);
        hash = 31 * hash + (this.nomeDaMaePaciente != null ? this.nomeDaMaePaciente.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return nomeCompletoPaciente + "-" + nomeDaMaePaciente ;
    }

    
    
}
