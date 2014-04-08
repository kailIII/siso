/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import embeddable.AntecedentesAdulto;
import embeddable.AntecedentesCrianca;
import embeddable.NecessidadesEspeciais;
import embeddable.Neurologico;
import entities.annotations.ActionDescriptor;
import entities.annotations.PropertyDescriptor;
import entities.annotations.View;
import entities.annotations.Views;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Java
 */
@Entity
@Views({
    @View(name = "Primeiras Consultas",
    filters = "Pesquisar Por:[pacientePrimeiraConsulta, Ctrl.DAO.filter()]",
    title = "Primeiras Consultas",
    members = "["
    + "Paciente[pacientePrimeiraConsulta;"
    + "         *pacientePrimeiraConsulta.dataDeNascimentoPaciente;"
    //+ "         *paciente.sexo;"//todo bug
    + "         cicloDeVidaPrimeiraConsulta;"
    + "         responsavelPrimeiraConsulta;"
    + "         categoriaPrimeiraConsulta];"
    + "Gestação[gestantePrimeiraConsulta;periodoDeGestacaoPrimeiraConsulta];"
    + "Ações Coletivas[acaoColetivaPrimeiraConsulta;localAcaoColetivaPrimeiraConsulta];"
    + "anamnesePrimeiraConsulta;"
    + "Antecedentes Pessoais/Odontólogo[ "
    + "Criança/Adolescente[antecedentesCrianca.antecedente01,antecedentesCrianca.observacao01;"
    + "                    antecedentesCrianca.antecedente02,antecedentesCrianca.observacao02;"
    + "                    antecedentesCrianca.antecedente03,antecedentesCrianca.observacao03;"
    + "                    antecedentesCrianca.antecedente04,antecedentesCrianca.observacao04;"
    + "                    antecedentesCrianca.antecedente05,antecedentesCrianca.observacao05;"
    + "                    antecedentesCrianca.antecedente06,antecedentesCrianca.observacao06;"
    + "                    antecedentesCrianca.antecedente07,antecedentesCrianca.observacao07;"
    + "                    antecedentesCrianca.antecedente08,antecedentesCrianca.observacao08;"
    + "                    antecedentesCrianca.antecedente09,antecedentesCrianca.observacao09;"
    + "                    antecedentesCrianca.antecedente10,antecedentesCrianca.observacao10;"
    + "                    antecedentesCrianca.antecedente11,antecedentesCrianca.observacao11;"
    + "                    antecedentesCrianca.antecedente12,antecedentesCrianca.observacao12];"
    + "Adulto/Idoso[antecedentesAdulto.antecedenteA01,antecedentesAdulto.observacaoA01;"
    + "             antecedentesAdulto.antecedenteA02,antecedentesAdulto.observacaoA02;"
    + "             antecedentesAdulto.antecedenteA03,antecedentesAdulto.observacaoA03;"
    + "             antecedentesAdulto.antecedenteA04,antecedentesAdulto.observacaoA04;"
    + "             antecedentesAdulto.antecedenteA05,antecedentesAdulto.observacaoA05;"
    + "             antecedentesAdulto.antecedenteA06,antecedentesAdulto.observacaoA06;"
    + "             antecedentesAdulto.antecedenteA07,antecedentesAdulto.observacaoA07;"
    + "             antecedentesAdulto.antecedenteA08,antecedentesAdulto.observacaoA08;"
    + "             antecedentesAdulto.antecedenteA09,antecedentesAdulto.observacaoA09];"        
    + "NecessidadesEspeciais[necessidadesEspeciais.antecedenteNE01,necessidadesEspeciais.observacaoNE01;"
    + "             necessidadesEspeciais.antecedenteNE02,necessidadesEspeciais.observacaoNE02;"
    + "             necessidadesEspeciais.antecedenteNE03,necessidadesEspeciais.observacaoNE03;"
    + "             necessidadesEspeciais.antecedenteNE04,necessidadesEspeciais.observacaoNE04;"
    + "             necessidadesEspeciais.antecedenteNE05,necessidadesEspeciais.observacaoNE05;"
    + "             necessidadesEspeciais.antecedenteNE06,necessidadesEspeciais.observacaoNE06;"
    + "             necessidadesEspeciais.antecedenteNE07,necessidadesEspeciais.observacaoNE07;"
    + "             necessidadesEspeciais.antecedenteNE08,necessidadesEspeciais.observacaoNE08;"
    + "             necessidadesEspeciais.antecedenteNE09,necessidadesEspeciais.observacaoNE09;"
    + "             necessidadesEspeciais.antecedenteNE10,necessidadesEspeciais.observacaoNE10;" 
    + "             necessidadesEspeciais.antecedenteNE11,necessidadesEspeciais.observacaoNE11;"
    + "             necessidadesEspeciais.antecedenteNE12,necessidadesEspeciais.observacaoNE12;"
    + "             necessidadesEspeciais.antecedenteNE13,necessidadesEspeciais.observacaoNE13;"
    + "             necessidadesEspeciais.antecedenteNE14,necessidadesEspeciais.observacaoNE14;"
    + "             necessidadesEspeciais.antecedenteNE15,necessidadesEspeciais.observacaoNE15;"
    + "             necessidadesEspeciais.antecedenteNE16,necessidadesEspeciais.observacaoNE16;"
    + "             necessidadesEspeciais.antecedenteNE17,necessidadesEspeciais.observacaoNE17;"
    + "             necessidadesEspeciais.antecedenteNE18,necessidadesEspeciais.observacaoNE18;"
    + "             necessidadesEspeciais.antecedenteNE19,necessidadesEspeciais.observacaoNE19;" 
    + "             necessidadesEspeciais.antecedenteNE20,necessidadesEspeciais.observacaoNE20;" 
    + "             necessidadesEspeciais.antecedenteNE21,necessidadesEspeciais.observacaoNE21];"
    + "Neurologico[neurologico.antecedenteN01,neurologico.observacaoN01;"
    + "             neurologico.antecedenteN02,neurologico.observacaoN02;"
    + "             neurologico.antecedenteN03,neurologico.observacaoN03;"
    + "             neurologico.antecedenteN04,neurologico.observacaoN04;"
    + "             neurologico.antecedenteN05,neurologico.observacaoN05;"
    + "             neurologico.antecedenteN06,neurologico.observacaoN06];"    
     
    + "adicionarProcedimentos(); "
    + "'Adicionar Procedimentos':addProcedimentosPc<procedimentoAddProcedimentoPc,facesAddProcedimento,dentesAddProcedimento, relizado, removerProcedimento()>;"        
    
    + "]"   
    + "]",
    template = "@CRUD+@PAGER",
    roles="Administrador,Atendente,Odontologo",
    rows=1
        )})
public class PrimeiraConsulta implements Serializable {
    //todo

    public enum CicloDeVida {

        Crianca, Adolescente, Adulto, Idoso

    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idPrimeiraConsulta;

    @NotNull
    @OneToOne
    private Paciente pacientePrimeiraConsulta;

    @Column(length = 40)
    @PropertyDescriptor(displayName = "Resposável")
    private String responsavelPrimeiraConsulta;

    @Column(length = 10)
    @PropertyDescriptor(displayName = "Categoria do responsável do paciente")
    private String categoriaPrimeiraConsulta;

    @NotNull
    @Enumerated
    private CicloDeVida cicloDeVidaPrimeiraConsulta;

    //No caso do campo sexo possuir valor “M”, este campo deve ser desabilitado;    
    private Boolean gestantePrimeiraConsulta = false;
    //Se gestante informar o período da gestação em semanas    

    @PropertyDescriptor(displayName = "Período de gestação em semanas")
    private Integer periodoDeGestacaoPrimeiraConsulta;

    @PropertyDescriptor(displayName = "Participa de Ações Coletivas")
    private Boolean acaoColetivaPrimeiraConsulta;

    //obrigado quando acaoColetiva = sim
    @Column(length = 30)
    @PropertyDescriptor(displayName = "Local das Ações Coletivas")
    private String localAcaoColetivaPrimeiraConsulta;

    @Lob
    @PropertyDescriptor(shortDescription = "Informar o uso atual de medicamentos quando necessário")
    private String anamnesePrimeiraConsulta;

    @Embedded
    private AntecedentesCrianca antecedentesCrianca = new AntecedentesCrianca();

    @Embedded
    private AntecedentesAdulto antecedentesAdulto = new AntecedentesAdulto();
    
    
    @Embedded
    private NecessidadesEspeciais necessidadesEspeciais = new NecessidadesEspeciais();
    
    @Embedded
    private Neurologico neurologico = new Neurologico();

    @PropertyDescriptor(displayName="Planejamento de Procedimentos")
    @OneToMany(cascade = CascadeType.ALL,   mappedBy="primeiraConsultaAddProcedimentoPc")
    private List<ADDProcedimentosPc> addProcedimentosPc = new ArrayList<ADDProcedimentosPc>();

     
    @ManyToOne
    private Atendimento atendimento;

    public Atendimento getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(Atendimento atendimento) {
        this.atendimento = atendimento;
    }
    
    
    @ActionDescriptor(methodDisabled= "#{not autoEntityBackBean.formInEditMode}")
    public void adicionarProcedimentos() {
        ADDProcedimentosPc addPPc = new ADDProcedimentosPc();
        addPPc.setPrimeiraConsultaAddProcedimentoPc(this);
        addProcedimentosPc.add(addPPc);
       
    }

    
    
    public List<ADDProcedimentosPc> getAddProcedimentosPc() {
        return addProcedimentosPc;
    }

    public void setAddProcedimentosPc(List<ADDProcedimentosPc> addProcedimentosPc) {
        this.addProcedimentosPc = addProcedimentosPc;
    }
    
    
    
    public Boolean getAcaoColetivaPrimeiraConsulta() {
        return acaoColetivaPrimeiraConsulta;
    }

    public void setAcaoColetivaPrimeiraConsulta(Boolean acaoColetivaPrimeiraConsulta) {
        this.acaoColetivaPrimeiraConsulta = acaoColetivaPrimeiraConsulta;
    }

    public String getAnamnesePrimeiraConsulta() {
        return anamnesePrimeiraConsulta;
    }

    public void setAnamnesePrimeiraConsulta(String anamnesePrimeiraConsulta) {
        this.anamnesePrimeiraConsulta = anamnesePrimeiraConsulta;
    }

    public AntecedentesAdulto getAntecedentesAdulto() {
        return antecedentesAdulto;
    }

    public void setAntecedentesAdulto(AntecedentesAdulto antecedentesAdulto) {
        this.antecedentesAdulto = antecedentesAdulto;
    }

    public AntecedentesCrianca getAntecedentesCrianca() {
        return antecedentesCrianca;
    }

    public void setAntecedentesCrianca(AntecedentesCrianca antecedentesCrianca) {
        this.antecedentesCrianca = antecedentesCrianca;
    }

    public String getCategoriaPrimeiraConsulta() {
        return categoriaPrimeiraConsulta;
    }

    public void setCategoriaPrimeiraConsulta(String categoriaPrimeiraConsulta) {
        this.categoriaPrimeiraConsulta = categoriaPrimeiraConsulta;
    }

    public CicloDeVida getCicloDeVidaPrimeiraConsulta() {
        return cicloDeVidaPrimeiraConsulta;
    }

    public void setCicloDeVidaPrimeiraConsulta(CicloDeVida cicloDeVidaPrimeiraConsulta) {
        this.cicloDeVidaPrimeiraConsulta = cicloDeVidaPrimeiraConsulta;
    }

    public Boolean getGestantePrimeiraConsulta() {
        return gestantePrimeiraConsulta;
    }

    public void setGestantePrimeiraConsulta(Boolean gestantePrimeiraConsulta) {
        this.gestantePrimeiraConsulta = gestantePrimeiraConsulta;
    }

    public Integer getIdPrimeiraConsulta() {
        return idPrimeiraConsulta;
    }

    public void setIdPrimeiraConsulta(Integer idPrimeiraConsulta) {
        this.idPrimeiraConsulta = idPrimeiraConsulta;
    }

    public String getLocalAcaoColetivaPrimeiraConsulta() {
        return localAcaoColetivaPrimeiraConsulta;
    }

    public void setLocalAcaoColetivaPrimeiraConsulta(String localAcaoColetivaPrimeiraConsulta) {
        this.localAcaoColetivaPrimeiraConsulta = localAcaoColetivaPrimeiraConsulta;
    }

    public Paciente getPacientePrimeiraConsulta() {
        return pacientePrimeiraConsulta;
    }

    public void setPacientePrimeiraConsulta(Paciente pacientePrimeiraConsulta) {
        this.pacientePrimeiraConsulta = pacientePrimeiraConsulta;
    }

    public Integer getPeriodoDeGestacaoPrimeiraConsulta() {
        return periodoDeGestacaoPrimeiraConsulta;
    }

    public void setPeriodoDeGestacaoPrimeiraConsulta(Integer periodoDeGestacaoPrimeiraConsulta) {
        this.periodoDeGestacaoPrimeiraConsulta = periodoDeGestacaoPrimeiraConsulta;
    }

    public String getResponsavelPrimeiraConsulta() {
        return responsavelPrimeiraConsulta;
    }

    public void setResponsavelPrimeiraConsulta(String responsavelPrimeiraConsulta) {
        this.responsavelPrimeiraConsulta = responsavelPrimeiraConsulta;
    }

    public NecessidadesEspeciais getNecessidadesEspeciais() {
        return necessidadesEspeciais;
    }

    public void setNecessidadesEspeciais(NecessidadesEspeciais necessidadesEspeciais) {
        this.necessidadesEspeciais = necessidadesEspeciais;
    }

    public Neurologico getNeurologico() {
        return neurologico;
    }

    public void setNeurologico(Neurologico neurologico) {
        this.neurologico = neurologico;
    }

    
    
}