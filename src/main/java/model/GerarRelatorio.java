/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import config.Configuracao;
import entities.annotations.PropertyDescriptor;
import entities.annotations.View;
import entities.annotations.Views;
import java.io.File;
import java.io.Serializable;
import java.net.URISyntaxException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import relatorio.GeradorRelatorio;
import relatorio.Relatorio;
import relatorio.RelatorioBPA;
import relatorio.RelatorioDAO;

/**
 *
 * @author junior
 */
@Entity
@Views({
    @View(name = "GerarRelatorio", title = "Gerar Relatórios",
    members = "["
    + "#dataInicio, #dataFim, #unidadeDeSaude, #odontologo; "
    + "gerarRelatorio();"
    + "gerarBPA();"
    + "]",
    template = "@PAGER",namedQuery="select new model.GerarRelatorio()",
    roles = "Administrador")
})
public class GerarRelatorio implements Serializable {
    @Id
    private Long id;
    String caminho = getClass().getResource("/").getPath();

    @NotNull(message="Informe a data de início")
    @PropertyDescriptor(displayName = "Desta Data")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataInicio;
    @PropertyDescriptor(displayName = "Até esta Data")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataFim;
    @ManyToOne
    private UnidadeDeSaude unidadeDeSaude;
    @ManyToOne
    private Odontologo odontologo;

    public File gerarRelatorio() throws URISyntaxException{
        RelatorioDAO dao = new RelatorioDAO();

        List<Relatorio> results = dao.getRelatorios(dataInicio, dataFim, unidadeDeSaude, odontologo);
        GeradorRelatorio gerador = new GeradorRelatorio();
        gerador.gerarRelatorioMensal((ArrayList<Relatorio>) results, dataInicio, dataFim);
        Format d = new SimpleDateFormat("dd-MM-yyyy");
        String data_Inicio = d.format(dataInicio);
        String data_Fim = d.format(dataFim);
        
        File file = new File(Configuracao.CLASSPATH + "relatorios/Relatorio_Mensal(" + data_Inicio + "-" + data_Fim + ").pdf");
        
        //File file = new File("C:/Users/IsmaelRS/NPI/Odontologia/relatorios/Relatorio_Mensal(" + data_Inicio + "-" + data_Fim + ").pdf");
        return file;
    }

    public File gerarBPA() throws URISyntaxException{
       
  
        RelatorioBPA dao = new RelatorioBPA();
        List<Relatorio> results = dao.getRelatorios(dataInicio, dataFim, unidadeDeSaude);
        GeradorRelatorio gerador = new GeradorRelatorio();
        gerador.gerarBPA((ArrayList<Relatorio>) results, dataInicio, dataFim);
        Format d = new SimpleDateFormat("dd-MM-yyyy");
        String data_Inicio = d.format(dataInicio);
        String data_Fim = d.format(dataFim);
        
        File file = new File(Configuracao.CLASSPATH + "relatorios/BPA(" + data_Inicio + "-" + data_Fim + ").pdf");
        return file;
        
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    

    public UnidadeDeSaude getUnidadeDeSaude() {
        return unidadeDeSaude;
    }

    public void setUnidadeDeSaude(UnidadeDeSaude unidadeDeSaude) {
        this.unidadeDeSaude = unidadeDeSaude;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}