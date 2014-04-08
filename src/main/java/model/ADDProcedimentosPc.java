/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.annotations.ActionDescriptor;
import entities.annotations.EntityDescriptor;
import entities.annotations.PropertyDescriptor;
import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 *
 * @author yarllysson
 */
@Entity
//@Table(uniqueConstraints = {
//  @UniqueConstraint(columnNames = {"procedimentoAddProcedimento_id,facesAddProcedimento,dentesAddProcedimento  "},
// name = "ADDProcedimentos")
//})
@EntityDescriptor(hidden = true, displayName="Adicionar Procedimento")

public class ADDProcedimentosPc implements Serializable {
    
    
    public enum Faces{
        Mesial, Distal, Lingual, Incisal, Vestibular, Oclusal
    }
    
    public enum Dentes{
        Dente18, Dente17, Dente16, Dente15, Dente14, Dente13, Dente12, Dente11,
        Dente21, Dente22, Dente23, Dente24, Dente25, Dente26, Dente27, Dente28,
        Dente38, Dente37, Dente36, Dente35, Dente34, Dente33, Dente32, Dente31,
        Dente41, Dente42, Dente43, Dente44, Dente45, Dente46, Dente47, Dente48,        
        
        Dente55, Dente54, Dente53, Dente52, Dente51,
        Dente61, Dente62, Dente63, Dente64, Dente65,
        Dente75, Dente74, Dente73, Dente72, Dente71,
        Dente81, Dente82, Dente83, Dente84, Dente85,
        
    }
    
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    
    @NotNull(message="Informe o Procedimento")
    @PropertyDescriptor(displayName="Procedimento")
    @ManyToOne
    private Procedimentos procedimentoAddProcedimentoPc;
    
    @NotNull(message="Informe a face do Procedimento")
    @PropertyDescriptor(displayName="Face")
    private ADDProcedimentos.Faces facesAddProcedimento;
    
    @NotNull(message="Informe o Dente ao ser Realizado o Procedimento")
    @PropertyDescriptor(displayName="Dente")
    private ADDProcedimentos.Dentes dentesAddProcedimento;
    
    @ManyToOne
    private PrimeiraConsulta primeiraConsultaAddProcedimentoPc;
    
        
    @ManyToOne
    private Atendimento atendimentoAddProcedimentoPc;
    
        
    @PropertyDescriptor(displayName="Procedimento Realizado")
    private boolean relizado;
    
    
    
  
    @ActionDescriptor(methodDisabled= "#{not autoEntityBackBean.formInEditMode}")
    public void removerProcedimento(){
        primeiraConsultaAddProcedimentoPc.getAddProcedimentosPc().remove(this);
       
    }

    public Atendimento getAtendimentoAddProcedimentoPc() {
        return atendimentoAddProcedimentoPc;
    }

    public void setAtendimentoAddProcedimentoPc(Atendimento atendimentoAddProcedimentoPc) {
        this.atendimentoAddProcedimentoPc = atendimentoAddProcedimentoPc;
    }


    
    
    public boolean isRelizado() {
        return relizado;
    }

    public void setRelizado(boolean relizado) {
        this.relizado = relizado;
    }
    
    
   
    public ADDProcedimentos.Dentes getDentesAddProcedimento() {
        return dentesAddProcedimento;
    }

    public void setDentesAddProcedimento(ADDProcedimentos.Dentes dentesAddProcedimento) {
        this.dentesAddProcedimento = dentesAddProcedimento;
    }

    public ADDProcedimentos.Faces getFacesAddProcedimento() {
        return facesAddProcedimento;
    }

    public void setFacesAddProcedimento(ADDProcedimentos.Faces facesAddProcedimento) {
        this.facesAddProcedimento = facesAddProcedimento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PrimeiraConsulta getPrimeiraConsultaAddProcedimentoPc() {
        return primeiraConsultaAddProcedimentoPc;
    }

    public void setPrimeiraConsultaAddProcedimentoPc(PrimeiraConsulta primeiraConsultaAddProcedimentoPc) {
        this.primeiraConsultaAddProcedimentoPc = primeiraConsultaAddProcedimentoPc;
    }

    

    public Procedimentos getProcedimentoAddProcedimentoPc() {
        return procedimentoAddProcedimentoPc;
    }

    public void setProcedimentoAddProcedimentoPc(Procedimentos procedimentoAddProcedimentoPc) {
        this.procedimentoAddProcedimentoPc = procedimentoAddProcedimentoPc;
    }

    
    
}
