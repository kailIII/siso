/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Repository;
import entities.annotations.ActionDescriptor;
import entities.annotations.EntityDescriptor;
import entities.annotations.PropertyDescriptor;
import entities.annotations.View;
import entities.annotations.Views;
import entities.dao.DAOConstraintException;
import entities.dao.DAOException;
import entities.dao.DAOValidationException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author ufc
 */
@Entity
@NamedQueries(
        @NamedQuery(name= "odontologoNamedQuery",
        query = ""
        + "Select u"
        + " From Odontologo u"
        +" Order By u.nomeOdontologo" ))
@EntityDescriptor(displayName = "Odontologo", pluralDisplayName = "Odontólogos",
template = "@FORM_CRUD",
roles = "Administrador,SecretarioDeSaude,ChefeDaOdontologia")
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = {"croOdontologo"},
    name = "Odontologo")
})
@Views({
    @View(name = "Odontologos", title = "Odontólogos",
    filters = "Pesquisar Por:[croOdontologo, nomeOdontologo, Ctrl.DAO.filter()]",
    members = "["
    + "croOdontologo;"
    + "nomeOdontologo;"
    + "telefoneOdontologo;"
   + "adicionarEspecialidade(); "
   + "'Adicionar Especialidades':addEspecialidades<addEspecialidade,cboAddEspecialidade,removerEspecialidade()>;"
    //+ "registrarDentista();"
    + "]",
    namedQuery = "odontologoNamedQuery",
    template = "@CRUD+@PAGER",            
    roles = "Administrador,SecretarioDeSaude,ChefeDaOdontologia")
})
public class Odontologo implements Serializable {

    @Column(length=10)
    @NotEmpty(message = "informe o CRO do Odontólogo")
    @PropertyDescriptor(index = 1, displayName = "CRO", autoFilter = true)
    private String croOdontologo;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @PropertyDescriptor(hidden = true)
    private Integer idOdontologo;

    
    @NotEmpty(message = "Informe o nome do Odontólogo")
    @Column(length = 60)
    @PropertyDescriptor(index = 2, autoFilter = true)
    private String nomeOdontologo;
    //private Especialidade especialidade; //*: Representa a especialidade do OdontÃ³logo; 
    @NotEmpty(message = "Informe o telefone do Odontólogo")
    @PropertyDescriptor(index = 3, mask = "(99)9999-9999")
    private String telefoneOdontologo;//: Representa o numero de contado do OdontÃ³logo;
    // 5.Dias disponÃ­veis*: Dias que poderÃ£o ser marcadas as consultas para este odontÃ³logo; 
    
    /*@NotNull(message = "Informe a Especialidade do Odontólogo")
    @PropertyDescriptor(index = 4, autoFilter = true)
    @ManyToOne
    private Especialidade especialidadeOdontologo;*/
    
    @OneToMany(cascade = CascadeType.ALL,   mappedBy="odontologoAddEspecialidade")
    @PropertyDescriptor(displayName="Adicionar Especialidades")
    private List<ADDEspecialidades> addEspecialidades = new ArrayList<ADDEspecialidades>();
    
    @ActionDescriptor(methodDisabled= "#{not autoEntityBackBean.formInEditMode}")
    public void adicionarEspecialidade() {
        ADDEspecialidades addE = new ADDEspecialidades();
        addE.setOdontologoAddEspecialidade(this);
        addEspecialidades.add(addE);
       
    }

    
    
    

    /*
     * public String registrarDentista() throws DAOException,
     * DAOValidationException, DAOConstraintException {
     *
     * long count = Repository.queryCount("From model.Odontologo ",this.cro);
     *
     * if (count > 0) throw new IllegalStateException("CRO já foi registrado");
     *
     * Repository.save(this); return "Dentista cadastrado com sucesso";
}
     */
    
    public String registrarDentista() throws DAOException, DAOValidationException, DAOConstraintException {
        List<Odontologo> odontologos = Repository.query("OdontologoCro", croOdontologo);

        
        if (odontologos.size() == 1) {
            return "Odontologo já cadastrado";
        } else {

            Repository.save(this);

            return "Dentista cadastrado com sucesso";

        }


    }

    public List<ADDEspecialidades> getAddEspecialidades() {
        return addEspecialidades;
    }

    public void setAddEspecialidades(List<ADDEspecialidades> addEspecialidades) {
        this.addEspecialidades = addEspecialidades;
    }

    public String getCroOdontologo() {
        return croOdontologo;
    }

    public void setCroOdontologo(String croOdontologo) {
        this.croOdontologo = croOdontologo;
    }

    public Integer getIdOdontologo() {
        return idOdontologo;
    }

    public void setIdOdontologo(Integer idOdontologo) {
        this.idOdontologo = idOdontologo;
    }

    public String getNomeOdontologo() {
        return nomeOdontologo;
    }

    public void setNomeOdontologo(String nomeOdontologo) {
        this.nomeOdontologo = nomeOdontologo;
    }

    public String getTelefoneOdontologo() {
        return telefoneOdontologo;
    }

    public void setTelefoneOdontologo(String telefoneOdontologo) {
        this.telefoneOdontologo = telefoneOdontologo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Odontologo other = (Odontologo) obj;
        if ((this.croOdontologo == null) ? (other.croOdontologo != null) : !this.croOdontologo.equals(other.croOdontologo)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (this.croOdontologo != null ? this.croOdontologo.hashCode() : 0);
        return hash;
    }

   
    @Override
    public String toString() {
        return croOdontologo + "-" + nomeOdontologo;
    }

    
    
}
