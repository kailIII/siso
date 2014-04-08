/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.annotations.ActionDescriptor;
import entities.annotations.EntityDescriptor;
import entities.annotations.PropertyDescriptor;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author yarllysson
 */
@Entity
@EntityDescriptor(hidden = true, displayName="Adicionar Especialidade")
public class ADDEspecialidades implements Serializable {
   
    @Id
    @PropertyDescriptor(hidden=true)
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long idAddEspecialidades;
    
    @NotNull(message="Informe a Especialidade")
    @ManyToOne
    @PropertyDescriptor(displayName="Especialidade")
    private Especialidade addEspecialidade;
    
    @NotEmpty(message="Informe o CBO do Odontólogo")
    @PropertyDescriptor(displayName="CBO")
    private String cboAddEspecialidade;
    
    @ManyToOne
    private Odontologo odontologoAddEspecialidade;
    
    @ActionDescriptor(methodDisabled= "#{not autoEntityBackBean.formInEditMode}")
    public void removerEspecialidade(){
        odontologoAddEspecialidade.getAddEspecialidades().remove(this);
       
    }

    public Odontologo getOdontologoAddEspecialidade() {
        return odontologoAddEspecialidade;
    }

    public void setOdontologoAddEspecialidade(Odontologo odontologoAddEspecialidade) {
        this.odontologoAddEspecialidade = odontologoAddEspecialidade;
    }

    public Especialidade getAddEspecialidade() {
        return addEspecialidade;
    }

    public void setAddEspecialidade(Especialidade addEspecialidade) {
        this.addEspecialidade = addEspecialidade;
    }
    
    
    

    

    public String getCboAddEspecialidade() {
        return cboAddEspecialidade;
    }

    public void setCboAddEspecialidade(String cboAddEspecialidade) {
        this.cboAddEspecialidade = cboAddEspecialidade;
    }

    public Long getIdAddEspecialidades() {
        return idAddEspecialidades;
    }

    public void setIdAddEspecialidades(Long idAddEspecialidades) {
        this.idAddEspecialidades = idAddEspecialidades;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ADDEspecialidades other = (ADDEspecialidades) obj;
        if (this.idAddEspecialidades != other.idAddEspecialidades && (this.idAddEspecialidades == null || !this.idAddEspecialidades.equals(other.idAddEspecialidades))) {
            return false;
        }
        if (this.addEspecialidade != other.addEspecialidade && (this.addEspecialidade == null || !this.addEspecialidade.equals(other.addEspecialidade))) {
            return false;
        }
        if ((this.cboAddEspecialidade == null) ? (other.cboAddEspecialidade != null) : !this.cboAddEspecialidade.equals(other.cboAddEspecialidade)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + (this.idAddEspecialidades != null ? this.idAddEspecialidades.hashCode() : 0);
        hash = 53 * hash + (this.addEspecialidade != null ? this.addEspecialidade.hashCode() : 0);
        hash = 53 * hash + (this.cboAddEspecialidade != null ? this.cboAddEspecialidade.hashCode() : 0);
        return hash;
    }

    
    @Override
    public String toString() {
        return cboAddEspecialidade;
    }
    
    
    
}
