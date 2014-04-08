/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.annotations.*;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
/*
 * @Table(uniqueConstraints = { @UniqueConstraint(columnNames = {"unidadeSaude",
 * "paciente", "dataEncaminhamento", "encaminhado"}, name = "Encaminhamento")
})
 */
@Views({
    //        @View(name = "View1", title = "busca",
    //            filters = "Pesquisar Por:[paciente, Ctrl.DAO.filter()]",
    //            members = "[ paciente.nomeCompleto, paciente.dataDeNascimento, paciente.endereco]",
    //            template = "@FORM",
    //            roles = "",
    //            namedQuery="Select p from CasosUso.Paciente p"),
    //            //params = @Param(name = "teste", value = "encaminhamento.paciente")),
    //            

    @View(name = "Encaminhamentos", title = "Encaminhamentos",
    filters = "Pesquisar Por:[unidadeSaudeEncaminhamento,  dataEncaminhamento, nomeOdontologoEncaminhamento, Ctrl.DAO.filter()]",
    members = "["
    + "unidadeSaudeEncaminhamento;"
    + "encaminhadoEncaminhamento;"
    + "dataEncaminhamento;"
    + "pacienteEncaminhamento;"
    + "*pacienteEncaminhamento.enderecoPaciente;"
    + "*pacienteEncaminhamento.telefonePaciente;"
    + "*pacienteEncaminhamento.nomeDaMaePaciente;"
    + "motivoEncaminhamento;"
    + "nomeOdontologoEncaminhamento;"
    + "]", 
    roles = "Administrador,Odontologo,Atendente",
    template = "@CRUD_PAGE")})
public class Encaminhamento implements Serializable {

    public enum Sexo {

        MASCULINO, FEMININO
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @PropertyDescriptor(hidden = true)
    private Integer idEncaminhamento;
    //@NotEmpty(message="Informe o nome da Unidade BÃ¡sica de SaÃºde")
    @PropertyDescriptor(index = 2, displayName = "Unidade de Saúde de Origem")
    @ManyToOne
    private UnidadeDeSaude unidadeSaudeEncaminhamento;    //Unidade de SaÃºde de Origem*: Campo de seleÃ§Ã£o simples que representa a unidade de saÃºde do paciente;
//--------------------------------------------------------------------------------------------------------
//Seria a data que foi solicitado o encaminhamento para outra unidade ou seria o agendamento??????
    @Temporal(javax.persistence.TemporalType.DATE)
    @NotNull(message = "Informe a data de realizaaÃ§Ã£o do encaminhamento")
    @PropertyDescriptor(index = 3, displayName = "Data da realizaçãoo do encaminhamento")
    //@Future  //nÃ£o coloca a data do dia
    private Date dataEncaminhamento;    //Data do Encaminhamento*: Representa a data em que foi realizado o Encaminhamentos;
//-------------------------------------------------------------------------------------------------------
    @NotNull
    @ManyToOne
    @Editor(inputComponentProperties =
    @Param(name = "reRender", value = "enderecoEncaminhamento,telefoneEncaminhamento,nomeDaMaeEncaminhamento"))
    @PropertyDescriptor(index = 4, displayName = "Nome do Paciente")
    private Paciente pacienteEncaminhamento;
////---------------------------------------------------------------------------------------------------------------
//        @Temporal(javax.persistence.TemporalType.DATE)
//        @NotNull(message="Informe a data de nascimento do paciente")
//        @PropertyDescriptor(index = 5, displayName="Data de nascimento do Paciente")
//        @Past
//        private Date dataPaciente;  //Representa a data de nascimento do Paciente. Campo editÃ¡vel preenchido atravÃ©s da seleÃ§Ã£o de paciente de acordo com a busca do UC 03 - Manter Pacientes ou digitaÃ§Ã£o;
////---------------------------------------------------------------------------------------------------
//        //@NotNull(message="Informe o sexo do paciente")
//        @PropertyDescriptor(index = 6)
//        private String sexo ;            //Representa o sexo do Paciente. Campo editÃ¡vel preenchido atravÃ©s da seleÃ§Ã£o de paciente de acordo com a busca do UC 03 - Manter Pacientes ou digitaÃ§Ã£o;
////-----------------------------------------------------------------------------------------------------
//        @NotEmpty(message="Informe o endereÃ§o do paciente")
//        @Column(length=30)
//        @PropertyDescriptor(index = 7, displayName="EndereÃ§o do Paciente")
//        private String endereco;        //Corresponde ao endereÃ§o do paciente. Campo editÃ¡vel preenchido atravÃ©s da seleÃ§Ã£o de paciente de acordo com a busca do UC 03 - Manter Pacientes ou digitaÃ§Ã£o;
////--------------------------------------------------------------------------------------------
//        @NotEmpty(message="Por favor informe o seu numero do telefone" )           
//        @PropertyDescriptor(index=8, mask="(99)9999-9999")
//        @Column(length=15)
//        private String telefone ;        //Corresponde ao nÃºmero de telefone do Paciente. Campo editÃ¡vel preenchido atravÃ©s da seleÃ§Ã£o de paciente de acordo com a busca do UC 03 - Manter Pacientes ou digitaÃ§Ã£o;
//----------------------------------------------------------------------------------------------------
    //@NotEmpty(message="Informe a Unidade de SaÃºde que o paciente serÃ¡ encaminhado")
    @PropertyDescriptor(index = 9, displayName = "Unidade de Saúde a ser Encaminhado")
    @ManyToOne
    private UnidadeDeSaude encaminhadoEncaminhamento;     //Corresponde a unidade de saÃºde que o paciente deve ser encaminhado (Hospital EudÃ¡sio Barroso, CEO ou Outros).
//-----------------------------------------------------------------------------------------------
    @Lob
    @NotEmpty(message = "Informe o motivo pelo qual o paciente precisa ser atendido em outra unidade de saúde")
    @PropertyDescriptor(index = 10, displayName = "Motivo do encaminhamento")
    private String motivoEncaminhamento;          //Representa o motivo pelo qual o paciente precisa ser atendido em outra unidade de saÃºde.
//--------------------------------------------------------------------------------------------------
    //@NotNull(message="")
    @PropertyDescriptor(index = 11, displayName = "Odontólogo responsável pelo encaminhamento")
    @ManyToOne
    private Odontologo nomeOdontologoEncaminhamento;   //Corresponde ao nome do cirurgiÃ£o dentista responsÃ¡vel pelo encaminhamento do paciente. Campo editÃ¡vel preenchido atravÃ©s da seleÃ§Ã£o de odontÃ³logo de acordo com a busca do UC 02 - Manter OdontÃ³logo ou digitaÃ§Ã£o;
//------------------------------------------------------------------------------------------------------
    //@NotNull(message="Informe o CRO do Ortodontista responsÃ¡vel pela encaminhamento do paciente")
    //@PropertyDescriptor(index = 12)
    //private Integer cro;            //Corresponde ao nÃºmero do cirurgiÃ£o dentista responsÃ¡vel pelo encaminhamento do paciente. Campo editÃ¡vel preenchido atravÃ©s da seleÃ§Ã£o de odontÃ³logo de acordo com a busca do UC 02 - Manter OdontÃ³logo ou digitaÃ§Ã£o;

    public Date getDataEncaminhamento() {
        return dataEncaminhamento;
    }

    public void setDataEncaminhamento(Date dataEncaminhamento) {
        this.dataEncaminhamento = dataEncaminhamento;
    }

    public UnidadeDeSaude getEncaminhadoEncaminhamento() {
        return encaminhadoEncaminhamento;
    }

    public void setEncaminhadoEncaminhamento(UnidadeDeSaude encaminhadoEncaminhamento) {
        this.encaminhadoEncaminhamento = encaminhadoEncaminhamento;
    }

    public Integer getIdEncaminhamento() {
        return idEncaminhamento;
    }

    public void setIdEncaminhamento(Integer idEncaminhamento) {
        this.idEncaminhamento = idEncaminhamento;
    }

    public String getMotivoEncaminhamento() {
        return motivoEncaminhamento;
    }

    public void setMotivoEncaminhamento(String motivoEncaminhamento) {
        this.motivoEncaminhamento = motivoEncaminhamento;
    }

    public Odontologo getNomeOdontologoEncaminhamento() {
        return nomeOdontologoEncaminhamento;
    }

    public void setNomeOdontologoEncaminhamento(Odontologo nomeOdontologoEncaminhamento) {
        this.nomeOdontologoEncaminhamento = nomeOdontologoEncaminhamento;
    }

    public Paciente getPacienteEncaminhamento() {
        return pacienteEncaminhamento;
    }

    public void setPacienteEncaminhamento(Paciente pacienteEncaminhamento) {
        this.pacienteEncaminhamento = pacienteEncaminhamento;
    }

    public UnidadeDeSaude getUnidadeSaudeEncaminhamento() {
        return unidadeSaudeEncaminhamento;
    }

    public void setUnidadeSaudeEncaminhamento(UnidadeDeSaude unidadeSaudeEncaminhamento) {
        this.unidadeSaudeEncaminhamento = unidadeSaudeEncaminhamento;
    }
}