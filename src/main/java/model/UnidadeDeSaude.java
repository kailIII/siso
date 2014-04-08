/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.annotations.EntityDescriptor;
import entities.annotations.PropertyDescriptor;
import entities.annotations.View;
import entities.annotations.Views;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;





@Entity

@EntityDescriptor(displayName="Manter Unidade de Saúde", pluralDisplayName= "Manter Unidade de Saúde",
        template = "@FORM_CRUD",
        roles = "Administrador"
        )
 @Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = {"scnesUnidadeDeSaude"}, name = "UnidadeDeSaude")
}) 
@Views({
            @View(name = "UnidadeDeSaude", title = "Unidade de Saúde",
            filters = "Pesquisar Por:[scnesUnidadeDeSaude, nomeUnidadeDeSaude, Ctrl.DAO.filter()]",
            members = "["
            + "scnesUnidadeDeSaude;"
            + "nomeUnidadeDeSaude;"
            + "cidadeUnidadeDeSaude;"
            + "ufUnidadeDeSaude;"
            + "bairroUnidadeDeSaude;"
            
            
            + "]",
            template = "@CRUD+@PAGER",
            roles = "Administrador, SecretarioDeSaude, ChefeDaOdontologia")})

public class UnidadeDeSaude implements Serializable {
    
    public enum UF{ CE, AC, AL, AM, BA,  DF, ES, GO, MA, MT, MS, MG, PA, PB, PR, PE, PI, RJ, RN, RS, RO, RR, SC, SP, SE, TO}
    
    @Id 
    @GeneratedValue(strategy= GenerationType.AUTO)
    @PropertyDescriptor(index=1, hidden=true)
    private int idUnidadeDeSaude;
        
    @PropertyDescriptor(index=2, displayName="SCNES", autoFilter=true)  
    @NotNull(message="Informe o SCNES da Unidade Básica de Saúde")
    private Integer scnesUnidadeDeSaude;        //codigo da unidade basica de saude
    
    @PropertyDescriptor(index=3, displayName="Nome da Unidade de Saúde", autoFilter=true )
    @NotEmpty(message="Informe o nome da Unidade Básica de Saúde")
//    @Column(length=20)
    private String nomeUnidadeDeSaude;
    
    @PropertyDescriptor(index=4, displayName="Cidade")
    @NotEmpty(message="Informe a Cidade da Unidade Básica de Saúde")
    private String cidadeUnidadeDeSaude;              //cidade da unidade basica de saude
    
    
    @PropertyDescriptor(index=5, displayName="UF")
    @NotNull(message="Informe a Unidade Federativa do Estado da cidade da Unidade Básica de Saúde")
    private UF ufUnidadeDeSaude;                  //unidade federativa do estado 
    
    @Column(length=20)
    @PropertyDescriptor(index=6, autoFilter=true, displayName="Bairro")
    @NotEmpty(message="Informe o Bairro da Unidade Básica de Saúde")
    private String bairroUnidadeDeSaude;              //bairro da unidade de saude

    public String getBairroUnidadeDeSaude() {
        return bairroUnidadeDeSaude;
    }

    public void setBairroUnidadeDeSaude(String bairroUnidadeDeSaude) {
        this.bairroUnidadeDeSaude = bairroUnidadeDeSaude;
    }

    public String getCidadeUnidadeDeSaude() {
        return cidadeUnidadeDeSaude;
    }

    public void setCidadeUnidadeDeSaude(String cidadeUnidadeDeSaude) {
        this.cidadeUnidadeDeSaude = cidadeUnidadeDeSaude;
    }

    public int getIdUnidadeDeSaude() {
        return idUnidadeDeSaude;
    }

    public void setIdUnidadeDeSaude(int idUnidadeDeSaude) {
        this.idUnidadeDeSaude = idUnidadeDeSaude;
    }

    public String getNomeUnidadeDeSaude() {
        return nomeUnidadeDeSaude;
    }

    public void setNomeUnidadeDeSaude(String nomeUnidadeDeSaude) {
        this.nomeUnidadeDeSaude = nomeUnidadeDeSaude;
    }

    public Integer getScnesUnidadeDeSaude() {
        return scnesUnidadeDeSaude;
    }

    public void setScnesUnidadeDeSaude(Integer scnesUnidadeDeSaude) {
        this.scnesUnidadeDeSaude = scnesUnidadeDeSaude;
    }

    public UF getUfUnidadeDeSaude() {
        return ufUnidadeDeSaude;
    }

    public void setUfUnidadeDeSaude(UF ufUnidadeDeSaude) {
        this.ufUnidadeDeSaude = ufUnidadeDeSaude;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UnidadeDeSaude other = (UnidadeDeSaude) obj;
        if (this.scnesUnidadeDeSaude != other.scnesUnidadeDeSaude && (this.scnesUnidadeDeSaude == null || !this.scnesUnidadeDeSaude.equals(other.scnesUnidadeDeSaude))) {
            return false;
        }
        if ((this.nomeUnidadeDeSaude == null) ? (other.nomeUnidadeDeSaude != null) : !this.nomeUnidadeDeSaude.equals(other.nomeUnidadeDeSaude)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + (this.scnesUnidadeDeSaude != null ? this.scnesUnidadeDeSaude.hashCode() : 0);
        hash = 41 * hash + (this.nomeUnidadeDeSaude != null ? this.nomeUnidadeDeSaude.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return  scnesUnidadeDeSaude + "-" + nomeUnidadeDeSaude ;
    }

    
   
}