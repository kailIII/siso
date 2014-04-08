/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package relatorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.*;
import model.UnidadeDeSaude;

/**
 *
 * @author junior
 */
public class RelatorioBPA {

    public List<Relatorio> getRelatorios(Date dataInicio, Date dataFim, UnidadeDeSaude unidadeDeSaude) {


        Format d = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();

        String data_fim = d.format(dataFim);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        String data_ini = d.format(dataInicio);

        String consulta;
        if (unidadeDeSaude == null) {
            consulta = "select P.NOMEPROCEDIMENTO, P.CODIGOPROCEDIMENTO, PAC.DATADENASCIMENTOPACIENTE, US.NOMEUNIDADEDESAUDE, AES.CBOADDESPECIALIDADE  FROM ESPECIALIDADE as ESP, ADDESPECIALIDADES as AES, UNIDADEDESAUDE as US, ODONTOLOGO as O,PROCEDIMENTOS as P, ADDPROCEDIMENTOS as ADDP, ATENDIMENTO as ATE, PACIENTE as PAC "
                    + "where  DATAATENDIMENTO BETWEEN  DATE('" + data_ini + "') AND  DATE('" + data_fim + "') and "
                    + "P.IDPROCEDIMENTO = ADDP.PROCEDIMENTOADDPROCEDIMENTO_IDPROCEDIMENTO and "
                    + "ATE.IDATENDIMENTO = ADDP.ATENDIMENTOADDPROCEDIMENTO_IDATENDIMENTO and "
                    + "P.IDPROCEDIMENTO in (select IDPROCEDIMENTO from ADDPROCEDIMENTOS where IDPROCEDIMENTO= P.IDPROCEDIMENTO) and "
                    + "PACIENTEATENDIMENTO_IDPACIENTE=IDPACIENTE and "
                    + "ODONTOLOGOATENDIMENTO_IDODONTOLOGO=IDODONTOLOGO and "
                    + "UNIDADEDESAUDEATENDIMENTO_IDUNIDADEDESAUDE=IDUNIDADEDESAUDE and "
                    + "IDODONTOLOGO=AES.ODONTOLOGOADDESPECIALIDADE_IDODONTOLOGO and IDESPECIALIDADE = AES.ADDESPECIALIDADE_IDESPECIALIDADE and "
                    + "AES.IDADDESPECIALIDADES in (select  IDADDESPECIALIDADES from ADDESPECIALIDADES where IDADDESPECIALIDADES=ATE.CBO_IDADDESPECIALIDADES)";
        } else {
//            
            consulta = "select P.NOMEPROCEDIMENTO, P.CODIGOPROCEDIMENTO, PAC.DATADENASCIMENTOPACIENTE, US.NOMEUNIDADEDESAUDE, AES.CBOADDESPECIALIDADE  FROM ESPECIALIDADE as ESP, ADDESPECIALIDADES as AES, UNIDADEDESAUDE as US, ODONTOLOGO as O,PROCEDIMENTOS as P, ADDPROCEDIMENTOS as ADDP, ATENDIMENTO as ATE, PACIENTE as PAC "
                    + "where  DATAATENDIMENTO BETWEEN  DATE('" + data_ini + "') AND  DATE('" + data_fim + "') and "
                    + "P.IDPROCEDIMENTO = ADDP.PROCEDIMENTOADDPROCEDIMENTO_IDPROCEDIMENTO and "
                    + "ATE.IDATENDIMENTO = ADDP.ATENDIMENTOADDPROCEDIMENTO_IDATENDIMENTO and "
                    + "P.IDPROCEDIMENTO in (select IDPROCEDIMENTO from ADDPROCEDIMENTOS where IDPROCEDIMENTO= P.IDPROCEDIMENTO) and "
                    + "PACIENTEATENDIMENTO_IDPACIENTE=IDPACIENTE and "
                    + "ODONTOLOGOATENDIMENTO_IDODONTOLOGO=IDODONTOLOGO and "
                    + "UNIDADEDESAUDEATENDIMENTO_IDUNIDADEDESAUDE=IDUNIDADEDESAUDE and "
                    + "IDODONTOLOGO=AES.ODONTOLOGOADDESPECIALIDADE_IDODONTOLOGO and IDESPECIALIDADE = AES.ADDESPECIALIDADE_IDESPECIALIDADE and "
                    + "AES.IDADDESPECIALIDADES in (select  IDADDESPECIALIDADES from ADDESPECIALIDADES where IDADDESPECIALIDADES=ATE.CBO_IDADDESPECIALIDADES) and NOMEUNIDADEDESAUDE='" + unidadeDeSaude.getNomeUnidadeDeSaude() + "'";
        }


        List<Relatorio> relatorios = new ArrayList<Relatorio>();
        Connection conn = null;
        PreparedStatement pstm = null;
        // Classe que vai recuperar os dados do banco de dados
        ResultSet rset = null;


        try {
            conn = ConnectionFactory.getConnection();

            pstm = conn.prepareStatement(consulta);

            rset = pstm.executeQuery();

            // Enquanto existir dados no banco de dados, faça
            while (rset.next()) {

                Relatorio relatorio = new Relatorio();

                // Recupera o id do banco e atribui ele ao objeto
                relatorio.setNome(rset.getString("NOMEPROCEDIMENTO"));

                // Recupera o nome do banco e atribui ele ao objeto
                relatorio.setCodigo(rset.getLong("CODIGOPROCEDIMENTO"));

                relatorio.setDataNascimento(rset.getDate("DATADENASCIMENTOPACIENTE"));

                relatorio.setCbo(rset.getString("CBOADDESPECIALIDADE"));


                // Recupera a idade do banco e atribui ele ao objeto

                // Adiciono o contato recuperado, a lista de contatos
                relatorios.add(relatorio);
            }
        } catch (Exception e) {

            e.printStackTrace();
        } finally {

            try {

                if (rset != null) {

                    rset.close();
                }

                if (pstm != null) {

                    pstm.close();
                }

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {

                e.printStackTrace();
            }
        }


        for (Relatorio r : relatorios) {
//             r.setIdade(getIdadeDoPaciente(r));
            r.setIdade(getIdadeDoPaciente(r));
//             r.setQuantidade(getQuantidade(r, relatorios));

        }
        for (Relatorio r : relatorios) {
//             r.setIdade(getIdadeDoPaciente(r));
//             r.setIdade(getIdadeDoPaciente(r));
            r.setQuantidade(getQuantidade(r, relatorios));

        }
//         System.out.println("Gerando Relatorio");
//           System.out.println(relatorios.size());
        return removeRepedidos(relatorios);
    }

    private static boolean podeInserirRelatorio(Relatorio r, List<Relatorio> relatorios) {

        for (Relatorio rela : relatorios) {
            if ((rela.getCodigo().equals(r.getCodigo())) && (rela.getIdade() == r.getIdade()) && (r.getCbo().equals(rela.getCbo()))) {
//            rela.setIdade(getIdadeDoPaciente(rela));
                return false;
            }
        }
        return true;
    }

    private static List<Relatorio> removeRepedidos(List<Relatorio> relatorios) {

        List<Relatorio> relas = new ArrayList<Relatorio>();


        for (Relatorio r : relatorios) {
            if (podeInserirRelatorio(r, relas)) {
//            r.setIdade(getIdadeDoPaciente(r));
                relas.add(r);
            }
        }
        return relas;


    }

    private static int getQuantidade(Relatorio r, List<Relatorio> relatorios) {

        int quantidade = 0;

        for (Relatorio rela : relatorios) {
            if ((rela.getCodigo().equals(r.getCodigo())) && (rela.getIdade() == r.getIdade()) && (r.getCbo().equals(rela.getCbo()))) {
                quantidade++;
            }
        }

        return quantidade;
    }

    public static Integer getIdadeDoPaciente(Relatorio relatorio) {
        GregorianCalendar hj = new GregorianCalendar();
        GregorianCalendar nascimento = new GregorianCalendar();
        if (relatorio.getDataNascimento() != null) {
            nascimento.setTime(relatorio.getDataNascimento());
        }
        int anohj = hj.get(Calendar.YEAR);
        int anoNascimento = nascimento.get(Calendar.YEAR);
        int meshj = hj.get(Calendar.MONTH) + 1;
        int mesNascimento = nascimento.get(Calendar.MONTH) + 1;
        int diahj = hj.get(Calendar.DAY_OF_MONTH);
        int diaNascimento = nascimento.get(Calendar.DAY_OF_MONTH);
        int idade = idade = new Integer(anohj - anoNascimento);

        if (meshj < mesNascimento) {
            idade--;
        } else {
            if (diahj < diaNascimento) {
                idade--;
            }
        }
        if (idade < 0) {
            idade = 0;
        }
        return idade;
    }
}
