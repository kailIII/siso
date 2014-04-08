/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.annotations.PropertyDescriptor;
import entities.annotations.View;
import entities.annotations.Views;
import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 *
 * @author yarllysson
 */
@Entity
@NamedQueries(
        @NamedQuery(name= "procedimentoNamedQuery",
        query = ""
        + "Select u"
        + " From Procedimentos u"
        +" Order By u.nomeProcedimento" ))
@Views({

@View(name = "Procedimentos", title =
"Procedimentos",

filters = "Pesquisar Por:[codigoProcedimento, nomeProcedimento, Ctrl.DAO.filter()]",

members = "["
+ "codigoProcedimento;"
+ "nomeProcedimento"



+ "]",
namedQuery = "procedimentoNamedQuery",
template = "@CRUD+@PAGER",
roles = "Administrador")})
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = {"codigoProcedimento"},
    name = "Odontologo")
})

public class Procedimentos implements Serializable {
    
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @PropertyDescriptor(hidden=true)
    private Integer idProcedimento;
    
    @Column(length=25)
    @NotNull(message="Informe o codigo do Procedimento")
    @PropertyDescriptor(displayName="Código do Procedimento")
    private Long codigoProcedimento;
    
    @Column(length=100)
    @PropertyDescriptor(displayName="Nome do Procedimento")
    private String nomeProcedimento;

    public Long getCodigoProcedimento() {
        return codigoProcedimento;
    }

    public void setCodigoProcedimento(Long codigoProcedimento) {
        this.codigoProcedimento = codigoProcedimento;
    }

    public Integer getIdProcedimento() {
        return idProcedimento;
    }

    public void setIdProcedimento(Integer idProcedimento) {
        this.idProcedimento = idProcedimento;
    }

    public String getNomeProcedimento() {
        return nomeProcedimento;
    }

    public void setNomeProcedimento(String nomeProcedimento) {
        this.nomeProcedimento = nomeProcedimento;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Procedimentos other = (Procedimentos) obj;
        if (this.codigoProcedimento != other.codigoProcedimento && (this.codigoProcedimento == null || !this.codigoProcedimento.equals(other.codigoProcedimento))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + (this.codigoProcedimento != null ? this.codigoProcedimento.hashCode() : 0);
        return hash;
    }

   
    @Override
    public String toString() {
        return codigoProcedimento + "-" + nomeProcedimento ;
    }

   
    
    
}
