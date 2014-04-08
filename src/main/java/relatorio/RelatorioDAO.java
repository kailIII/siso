/*
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package relatorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import model.Odontologo;
import model.UnidadeDeSaude;

/**
 *
 * @author junior
 */
public class RelatorioDAO {

    public List<Relatorio> getRelatorios(Date dataInicio, Date dataFim, UnidadeDeSaude unidadeDeSaude, Odontologo odontologo) {

       
        Format d = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal=Calendar.getInstance();  

        String data_fim = d.format(dataFim);                            
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));  
        String data_ini = d.format(dataInicio);
        String consulta;
        if(unidadeDeSaude==null && odontologo==null)
        consulta = "select P.NOMEPROCEDIMENTO, P.CODIGOPROCEDIMENTO, PAC.DATADENASCIMENTOPACIENTE, US.NOMEUNIDADEDESAUDE, AES.CBOADDESPECIALIDADE  FROM ESPECIALIDADE as ESP, ADDESPECIALIDADES as AES, UNIDADEDESAUDE as US, ODONTOLOGO as O,PROCEDIMENTOS as P, ADDPROCEDIMENTOS as ADDP, ATENDIMENTO as ATE, PACIENTE as PAC "
                +"where  DATAATENDIMENTO BETWEEN  DATE('"+data_ini+"') AND  DATE('"+data_fim+"') and "
                +"P.IDPROCEDIMENTO = ADDP.PROCEDIMENTOADDPROCEDIMENTO_IDPROCEDIMENTO and "
                + "ATE.IDATENDIMENTO = ADDP.ATENDIMENTOADDPROCEDIMENTO_IDATENDIMENTO and "
                + "P.IDPROCEDIMENTO in (select IDPROCEDIMENTO from ADDPROCEDIMENTOS where IDPROCEDIMENTO= P.IDPROCEDIMENTO) and "
                + "PACIENTEATENDIMENTO_IDPACIENTE=IDPACIENTE and "
                + "ODONTOLOGOATENDIMENTO_IDODONTOLOGO=IDODONTOLOGO and "
                + "UNIDADEDESAUDEATENDIMENTO_IDUNIDADEDESAUDE=IDUNIDADEDESAUDE and "
                + "IDODONTOLOGO=AES.ODONTOLOGOADDESPECIALIDADE_IDODONTOLOGO and IDESPECIALIDADE = AES.ADDESPECIALIDADE_IDESPECIALIDADE and "
                + "AES.IDADDESPECIALIDADES in (select  IDADDESPECIALIDADES from ADDESPECIALIDADES where IDADDESPECIALIDADES=ATE.CBO_IDADDESPECIALIDADES)";

        else if(unidadeDeSaude!=null && odontologo==null){

            consulta = "select P.NOMEPROCEDIMENTO, P.CODIGOPROCEDIMENTO, PAC.DATADENASCIMENTOPACIENTE, US.NOMEUNIDADEDESAUDE, AES.CBOADDESPECIALIDADE  FROM ESPECIALIDADE as ESP, ADDESPECIALIDADES as AES, UNIDADEDESAUDE as US, ODONTOLOGO as O,PROCEDIMENTOS as P, ADDPROCEDIMENTOS as ADDP, ATENDIMENTO as ATE, PACIENTE as PAC "
                +"where  DATAATENDIMENTO BETWEEN  DATE('"+data_ini+"') AND  DATE('"+data_fim+"') and "
                +"P.IDPROCEDIMENTO = ADDP.PROCEDIMENTOADDPROCEDIMENTO_IDPROCEDIMENTO and "
                + "ATE.IDATENDIMENTO = ADDP.ATENDIMENTOADDPROCEDIMENTO_IDATENDIMENTO and "
                + "P.IDPROCEDIMENTO in (select IDPROCEDIMENTO from ADDPROCEDIMENTOS where IDPROCEDIMENTO= P.IDPROCEDIMENTO) and "
                + "PACIENTEATENDIMENTO_IDPACIENTE=IDPACIENTE and "
                + "ODONTOLOGOATENDIMENTO_IDODONTOLOGO=IDODONTOLOGO and "
                + "UNIDADEDESAUDEATENDIMENTO_IDUNIDADEDESAUDE=IDUNIDADEDESAUDE and "
                + "IDODONTOLOGO=AES.ODONTOLOGOADDESPECIALIDADE_IDODONTOLOGO and IDESPECIALIDADE = AES.ADDESPECIALIDADE_IDESPECIALIDADE and "
                + "AES.IDADDESPECIALIDADES in (select  IDADDESPECIALIDADES from ADDESPECIALIDADES where IDADDESPECIALIDADES=ATE.CBO_IDADDESPECIALIDADES) and NOMEUNIDADEDESAUDE='"+unidadeDeSaude.getNomeUnidadeDeSaude()+"'";
        }
        else if(unidadeDeSaude==null && odontologo!=null){
             consulta = "select P.NOMEPROCEDIMENTO, P.CODIGOPROCEDIMENTO, PAC.DATADENASCIMENTOPACIENTE, US.NOMEUNIDADEDESAUDE, AES.CBOADDESPECIALIDADE  FROM ESPECIALIDADE as ESP, ADDESPECIALIDADES as AES, UNIDADEDESAUDE as US, ODONTOLOGO as O,PROCEDIMENTOS as P, ADDPROCEDIMENTOS as ADDP, ATENDIMENTO as ATE, PACIENTE as PAC "
                +"where  DATAATENDIMENTO BETWEEN  DATE('"+data_ini+"') AND  DATE('"+data_fim+"') and "
                +"P.IDPROCEDIMENTO = ADDP.PROCEDIMENTOADDPROCEDIMENTO_IDPROCEDIMENTO and "
                + "ATE.IDATENDIMENTO = ADDP.ATENDIMENTOADDPROCEDIMENTO_IDATENDIMENTO and "
                + "P.IDPROCEDIMENTO in (select IDPROCEDIMENTO from ADDPROCEDIMENTOS where IDPROCEDIMENTO= P.IDPROCEDIMENTO) and "
                + "PACIENTEATENDIMENTO_IDPACIENTE=IDPACIENTE and "
                + "ODONTOLOGOATENDIMENTO_IDODONTOLOGO=IDODONTOLOGO and "
                + "UNIDADEDESAUDEATENDIMENTO_IDUNIDADEDESAUDE=IDUNIDADEDESAUDE and "
                + "IDODONTOLOGO=AES.ODONTOLOGOADDESPECIALIDADE_IDODONTOLOGO and IDESPECIALIDADE = AES.ADDESPECIALIDADE_IDESPECIALIDADE and "
                + "AES.IDADDESPECIALIDADES in (select  IDADDESPECIALIDADES from ADDESPECIALIDADES where IDADDESPECIALIDADES=ATE.CBO_IDADDESPECIALIDADES) and AES.ODONTOLOGOADDESPECIALIDADE_IDODONTOLOGO="+odontologo.getIdOdontologo();
        }
        else{
            consulta = "select P.NOMEPROCEDIMENTO, P.CODIGOPROCEDIMENTO, PAC.DATADENASCIMENTOPACIENTE, US.NOMEUNIDADEDESAUDE, AES.CBOADDESPECIALIDADE  FROM ESPECIALIDADE as ESP, ADDESPECIALIDADES as AES, UNIDADEDESAUDE as US, ODONTOLOGO as O,PROCEDIMENTOS as P, ADDPROCEDIMENTOS as ADDP, ATENDIMENTO as ATE, PACIENTE as PAC "
                +"where  DATAATENDIMENTO BETWEEN  DATE('"+data_ini+"') AND  DATE('"+data_fim+"') and "
                +"P.IDPROCEDIMENTO = ADDP.PROCEDIMENTOADDPROCEDIMENTO_IDPROCEDIMENTO and "
                + "ATE.IDATENDIMENTO = ADDP.ATENDIMENTOADDPROCEDIMENTO_IDATENDIMENTO and "
                + "P.IDPROCEDIMENTO in (select IDPROCEDIMENTO from ADDPROCEDIMENTOS where IDPROCEDIMENTO= P.IDPROCEDIMENTO) and "
                + "PACIENTEATENDIMENTO_IDPACIENTE=IDPACIENTE and "
                + "ODONTOLOGOATENDIMENTO_IDODONTOLOGO=IDODONTOLOGO and "
                + "UNIDADEDESAUDEATENDIMENTO_IDUNIDADEDESAUDE=IDUNIDADEDESAUDE and "
                + "IDODONTOLOGO=AES.ODONTOLOGOADDESPECIALIDADE_IDODONTOLOGO and IDESPECIALIDADE = AES.ADDESPECIALIDADE_IDESPECIALIDADE and "
                + "AES.IDADDESPECIALIDADES in (select  IDADDESPECIALIDADES from ADDESPECIALIDADES where IDADDESPECIALIDADES=ATE.CBO_IDADDESPECIALIDADES) and NOMEUNIDADEDESAUDE='"+unidadeDeSaude.getNomeUnidadeDeSaude()+"' and AES.ODONTOLOGOADDESPECIALIDADE_IDODONTOLOGO="+odontologo.getIdOdontologo();
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
                
                relatorio.setUnidadeDeSaude(rset.getString("NOMEUNIDADEDESAUDE"));

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
         
         
         for(Relatorio  r : relatorios){              
             r.setQuantidade(getQuantidade(r, relatorios));
         }
//         System.out.println("Gerando Relatorio");
        return removeRepedidos(relatorios);
    }
    
   
    
    private static boolean podeInserirRelatorio(Relatorio r, List<Relatorio> relatorios){
   
    for(Relatorio rela : relatorios){
        if(rela.getCodigo().equals(r.getCodigo())&&(rela.getUnidadeDeSaude().equals(r.getUnidadeDeSaude()))){
        return false;
        }                
    }
    return true;
    }
    
    
    
    private static List<Relatorio> removeRepedidos(List<Relatorio> relatorios){
    
    List<Relatorio> relas = new ArrayList<Relatorio>();
    
    
    for(Relatorio r: relatorios){ 
        if(podeInserirRelatorio(r, relas)){
        relas.add(r);
        }                
    }        
    return relas;    
        
        
    }
    
    private static int getQuantidade(Relatorio r, List<Relatorio> relatorios){
    
    int quantidade =0;
        
    for(Relatorio rela : relatorios){
        if(rela.getCodigo().equals(r.getCodigo())&&(rela.getUnidadeDeSaude().equals(r.getUnidadeDeSaude()))){
        quantidade++;
        }        
    }
        
        return quantidade;
    }
    
    
    
    

}