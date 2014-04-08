/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import embeddable.DiasDaSemana;
import entities.annotations.EntityDescriptor;
import entities.annotations.PropertyDescriptor;
import entities.annotations.View;
import entities.annotations.Views;
import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Yarllysson
 */
@Entity
@Views({
    
    @View(name = "Vincular Odontologo Unidade Saude",
    title = "Vincular Odontologo a Unidade Saude",
    members = "["
    + "VincularOdontologoUnidadeSaude[odontologoVincularOdontologoUnidadeDeSaude;"
    + "         unidadeDeSaudeVincularOdontologoUnidadeDeSaude];"

    + "DiasDaSemana[diasDaSemanaVincularOdontologoUnidadeDeSaude.segunda;"
    + "                    diasDaSemanaVincularOdontologoUnidadeDeSaude.terca;"
    + "                    diasDaSemanaVincularOdontologoUnidadeDeSaude.quarta;"
    + "                    diasDaSemanaVincularOdontologoUnidadeDeSaude.quinta;"
    + "                    diasDaSemanaVincularOdontologoUnidadeDeSaude.sexta;"
    + "                    diasDaSemanaVincularOdontologoUnidadeDeSaude.sabado;"
    + "                    diasDaSemanaVincularOdontologoUnidadeDeSaude.domingo];"
    + "]",
    filters="Pesquisar por[odontologoVincularOdontologoUnidadeDeSaude, unidadeDeSaudeVincularOdontologoUnidadeDeSaude, Ctrl.DAO.filter()]",
    template = "@CRUD_PAGE",
    roles="Administrador,SecretarioDeSaude,ChefeDaOdontologia"
)})
@EntityDescriptor(displayName = "Vincular Odontologo a Unidade de Saúde", 
        pluralDisplayName = "Vincular Odontólogos a Unidade de Saúde",
        template = "@FORM_CRUD",
        roles="Administrador,SecretarioDeSaude,ChefeDaOdontologia"
        
        )
/*@Table(uniqueConstraints = {
@UniqueConstraint(columnNames = {"odontologoVincularOdontologoUnidadeDeSaude", "unidadeDeSaudeVincularOdontologoUnidadeDeSaude"},
name = "VincularOdontologoUnidadeSaude")
})*/
public class VincularOdontologoUnidadeSaude implements Serializable {
    
     
  
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @PropertyDescriptor(hidden=true)
    private Integer idVincularOdontologoUnidadeDeSaude;
    
    @NotNull(message = "Informe o Odontologo")
    @ManyToOne
    @PropertyDescriptor(index = 1, displayName = "Odontologo", autoFilter= true)
    private Odontologo odontologoVincularOdontologoUnidadeDeSaude;
         
    
    @NotNull(message = "Informe a unidade de saúde")
    @ManyToOne
    @PropertyDescriptor(index = 2, displayName = "Unidade de Saúde", autoFilter= true)
    private UnidadeDeSaude unidadeDeSaudeVincularOdontologoUnidadeDeSaude;

    @Embedded
    private DiasDaSemana diasDaSemanaVincularOdontologoUnidadeDeSaude = new DiasDaSemana();

    public DiasDaSemana getDiasDaSemanaVincularOdontologoUnidadeDeSaude() {
        return diasDaSemanaVincularOdontologoUnidadeDeSaude;
    }

    public void setDiasDaSemanaVincularOdontologoUnidadeDeSaude(DiasDaSemana diasDaSemanaVincularOdontologoUnidadeDeSaude) {
        this.diasDaSemanaVincularOdontologoUnidadeDeSaude = diasDaSemanaVincularOdontologoUnidadeDeSaude;
    }

    public Integer getIdVincularOdontologoUnidadeDeSaude() {
        return idVincularOdontologoUnidadeDeSaude;
    }

    public void setIdVincularOdontologoUnidadeDeSaude(Integer idVincularOdontologoUnidadeDeSaude) {
        this.idVincularOdontologoUnidadeDeSaude = idVincularOdontologoUnidadeDeSaude;
    }

    public Odontologo getOdontologoVincularOdontologoUnidadeDeSaude() {
        return odontologoVincularOdontologoUnidadeDeSaude;
    }

    public void setOdontologoVincularOdontologoUnidadeDeSaude(Odontologo odontologoVincularOdontologoUnidadeDeSaude) {
        this.odontologoVincularOdontologoUnidadeDeSaude = odontologoVincularOdontologoUnidadeDeSaude;
    }

    public UnidadeDeSaude getUnidadeDeSaudeVincularOdontologoUnidadeDeSaude() {
        return unidadeDeSaudeVincularOdontologoUnidadeDeSaude;
    }

    public void setUnidadeDeSaudeVincularOdontologoUnidadeDeSaude(UnidadeDeSaude unidadeDeSaudeVincularOdontologoUnidadeDeSaude) {
        this.unidadeDeSaudeVincularOdontologoUnidadeDeSaude = unidadeDeSaudeVincularOdontologoUnidadeDeSaude;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final VincularOdontologoUnidadeSaude other = (VincularOdontologoUnidadeSaude) obj;
        if (this.odontologoVincularOdontologoUnidadeDeSaude != other.odontologoVincularOdontologoUnidadeDeSaude && (this.odontologoVincularOdontologoUnidadeDeSaude == null || !this.odontologoVincularOdontologoUnidadeDeSaude.equals(other.odontologoVincularOdontologoUnidadeDeSaude))) {
            return false;
        }
        if (this.unidadeDeSaudeVincularOdontologoUnidadeDeSaude != other.unidadeDeSaudeVincularOdontologoUnidadeDeSaude && (this.unidadeDeSaudeVincularOdontologoUnidadeDeSaude == null || !this.unidadeDeSaudeVincularOdontologoUnidadeDeSaude.equals(other.unidadeDeSaudeVincularOdontologoUnidadeDeSaude))) {
            return false;
        }
        if (this.diasDaSemanaVincularOdontologoUnidadeDeSaude != other.diasDaSemanaVincularOdontologoUnidadeDeSaude && (this.diasDaSemanaVincularOdontologoUnidadeDeSaude == null || !this.diasDaSemanaVincularOdontologoUnidadeDeSaude.equals(other.diasDaSemanaVincularOdontologoUnidadeDeSaude))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (this.odontologoVincularOdontologoUnidadeDeSaude != null ? this.odontologoVincularOdontologoUnidadeDeSaude.hashCode() : 0);
        hash = 89 * hash + (this.unidadeDeSaudeVincularOdontologoUnidadeDeSaude != null ? this.unidadeDeSaudeVincularOdontologoUnidadeDeSaude.hashCode() : 0);
        hash = 89 * hash + (this.diasDaSemanaVincularOdontologoUnidadeDeSaude != null ? this.diasDaSemanaVincularOdontologoUnidadeDeSaude.hashCode() : 0);
        return hash;
    }

    
}
