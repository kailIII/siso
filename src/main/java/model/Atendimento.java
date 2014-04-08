/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.annotations.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;

/**
 *
 * @author RamonReis
 */
@Entity

/*@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = {"nomePaciente", "nomeResponsavel", "dataAtendimento"},
    name = "Adendimento")
})*/

@Views({
            @View(name = "Atendimentos", title = "Atendimentos",
            //filters = "Pesquisar Por:[ Ctrl.DAO.filter()]",
            members = "["
            +"unidadeDeSaudeAtendimento;"        
            + "dataAtendimento; "
            //+ "horaAtendimento;"
            + "turnoAtendimento;"
            + "odontologoAtendimento;"
            + "cbo;"
            + "pacienteAtendimento; "
            + "adicionarProcedimento(); "
            + "addProcedimentos<procedimentoAddProcedimento,facesAddProcedimento,dentesAddProcedimento, removerProcedimento()>;"        
           // + "addProcedimentosPc<procedimentoAddProcedimentoPc>; "
                
            + "]",
            template = "@CRUD+@PAGER",
            params = {@Param(name = "odontologoAtendimento", value = "#{dataItem.odontologoAtendimento}")},
            roles = "Administrador,Atendente, Odontologo")})

public class Atendimento implements Serializable {
    
    public enum Turno {

             MANHA, TARDE, NOITE
          }
    
    @ManyToOne
    @NotNull(message="Informe a Unidade de Saúde")
    private UnidadeDeSaude unidadeDeSaudeAtendimento;
    
    @ManyToOne
    @Editor(inputComponentProperties=@Param(name="reRender",value="cbo"))
    private Odontologo odontologoAtendimento;
    
    @Editor(namedQuery="From ADDEspecialidades where odontologoAddEspecialidade = :odontologoAtendimento")
    @ManyToOne
    private ADDEspecialidades cbo;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @PropertyDescriptor(index = 1, hidden = true)
    private Long idAtendimento;
    
    
    
    @PropertyDescriptor(index = 2)
    @NotNull(message = "Informe a data do atendimento")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataAtendimento;
   
   
    @PropertyDescriptor(index = 3, mask="99:99")
    private String horaAtendimento;
    
    @PropertyDescriptor(index = 4)
    private Turno turnoAtendimento;
    
    @ManyToOne
    @PropertyDescriptor(displayName="Paciente")
//    @NotNull(message="Informe o Paciente a ser atendido")
    @Editor(inputComponentProperties=@Param(name="reRender",value="addProcedimentosPc"))
    private Paciente pacienteAtendimento;
    
    @PropertyDescriptor(displayName="Procedimentos Realizados")
    @OneToMany(cascade = CascadeType.ALL,   mappedBy="atendimentoAddProcedimento")
    private List<ADDProcedimentos> addProcedimentos = new ArrayList<ADDProcedimentos>();
    
                       
    @PropertyDescriptor(displayName="Planejamento de Procedimentos")
   
//    @Editor(namedQuery="From ADDEspecialidades where odontologoAddEspecialidade = :odontologoAtendimento")
    @Editor(namedQuery="From ADDProcedimentosPc where model.Paciente.pacientePrimeiraConsulta = :pacienteAtendimento ")
    @OneToMany(cascade = CascadeType.ALL,   mappedBy="atendimentoAddProcedimentoPc")    
    private List<ADDProcedimentosPc> addProcedimentosPc;

    public List<ADDProcedimentosPc> getAddProcedimentosPc() {
        return addProcedimentosPc;
    }

    public void setAddProcedimentosPc(List<ADDProcedimentosPc> addProcedimentosPc) {
        this.addProcedimentosPc = addProcedimentosPc;
    }

     
    @ActionDescriptor(methodDisabled= "#{not autoEntityBackBean.formInEditMode}")
    public void adicionarProcedimento() {
        ADDProcedimentos addP = new ADDProcedimentos();
        addP.setAtendimentoAddProcedimento(this);
        addProcedimentos.add(addP);
       
    }

    
    
    public List<ADDProcedimentos> getAddProcedimentos() {
        return addProcedimentos;
    }

    public void setAddProcedimentos(List<ADDProcedimentos> addProcedimentos) {
        this.addProcedimentos = addProcedimentos;
    }

    public ADDEspecialidades getCbo() {
        return cbo;
    }

    public void setCbo(ADDEspecialidades cbo) {
        this.cbo = cbo;
    }

    public Date getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(Date dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    public String getHoraAtendimento() {
        return horaAtendimento;
    }

    public void setHoraAtendimento(String horaAtendimento) {
        this.horaAtendimento = horaAtendimento;
    }

    public Long getIdAtendimento() {
        return idAtendimento;
    }

    public void setIdAtendimento(Long idAtendimento) {
        this.idAtendimento = idAtendimento;
    }

    public Odontologo getOdontologoAtendimento() {
        return odontologoAtendimento;
    }

    public void setOdontologoAtendimento(Odontologo odontologoAtendimento) {
        this.odontologoAtendimento = odontologoAtendimento;
    }

    public Paciente getPacienteAtendimento() {
        return pacienteAtendimento;
    }

    public void setPacienteAtendimento(Paciente pacienteAtendimento) {
        this.pacienteAtendimento = pacienteAtendimento;
    }

    public Turno getTurnoAtendimento() {
        return turnoAtendimento;
    }

    public void setTurnoAtendimento(Turno turnoAtendimento) {
        this.turnoAtendimento = turnoAtendimento;
    }

    public UnidadeDeSaude getUnidadeDeSaudeAtendimento() {
        return unidadeDeSaudeAtendimento;
    }

    public void setUnidadeDeSaudeAtendimento(UnidadeDeSaude unidadeDeSaudeAtendimento) {
        this.unidadeDeSaudeAtendimento = unidadeDeSaudeAtendimento;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Atendimento other = (Atendimento) obj;
        if (this.odontologoAtendimento != other.odontologoAtendimento && (this.odontologoAtendimento == null || !this.odontologoAtendimento.equals(other.odontologoAtendimento))) {
            return false;
        }
        if (this.cbo != other.cbo && (this.cbo == null || !this.cbo.equals(other.cbo))) {
            return false;
        }
        if (this.dataAtendimento != other.dataAtendimento && (this.dataAtendimento == null || !this.dataAtendimento.equals(other.dataAtendimento))) {
            return false;
        }
        if ((this.horaAtendimento == null) ? (other.horaAtendimento != null) : !this.horaAtendimento.equals(other.horaAtendimento)) {
            return false;
        }
        if (this.turnoAtendimento != other.turnoAtendimento) {
            return false;
        }
        if (this.pacienteAtendimento != other.pacienteAtendimento && (this.pacienteAtendimento == null || !this.pacienteAtendimento.equals(other.pacienteAtendimento))) {
            return false;
        }
        if (this.addProcedimentos != other.addProcedimentos && (this.addProcedimentos == null || !this.addProcedimentos.equals(other.addProcedimentos))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + (this.odontologoAtendimento != null ? this.odontologoAtendimento.hashCode() : 0);
        hash = 61 * hash + (this.cbo != null ? this.cbo.hashCode() : 0);
        hash = 61 * hash + (this.dataAtendimento != null ? this.dataAtendimento.hashCode() : 0);
        hash = 61 * hash + (this.horaAtendimento != null ? this.horaAtendimento.hashCode() : 0);
        hash = 61 * hash + (this.turnoAtendimento != null ? this.turnoAtendimento.hashCode() : 0);
        hash = 61 * hash + (this.pacienteAtendimento != null ? this.pacienteAtendimento.hashCode() : 0);
        return hash;
    }

     
}
