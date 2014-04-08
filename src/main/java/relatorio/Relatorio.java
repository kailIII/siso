/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package relatorio;

import java.util.Date;

/**
 *
 * @author yarllysson
 */

/*
 * @NamedQueries({ @NamedQuery(name = "teste", query = "" + "Select
 * p.nomeProcedimento, p.codigoProcedimento, count(*)" + " From Atendimento a,
 * Procedimentos p" + " Where extract(month from(select a.dataAtendimento)= '06'
 * group by p.codigoProcedimento ")
})
 */

public class Relatorio {

    private Long codigo;
    private String nome;
    private int quantidade;
    private Date dataNascimento;
    private String unidadeDeSaude;
    private String cbo;

    public String getCbo() {
        return cbo;
    }

    public void setCbo(String cbo) {
        this.cbo = cbo;
    }

    public String getUnidadeDeSaude() {
        return unidadeDeSaude;
    }

    public void setUnidadeDeSaude(String unidadeDeSaude) {
        this.unidadeDeSaude = unidadeDeSaude;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    private int idade;
    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    /*
     * public String gerarRelatorio() throws DAOException,
     * DAOValidationException, DAOConstraintException { List<Relatorio>
     * relatorio = Repository.query("teste"); ArrayList<Relatorio> r =
     * (ArrayList<Relatorio>) relatorio; GeradorRelatorio gerador = new
     * GeradorRelatorio(); gerador.gerarRelatorioMensal(r); return null;
     *
     *
     *
     * }
     */
  
}