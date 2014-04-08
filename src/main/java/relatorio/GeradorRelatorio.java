package relatorio;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import config.Configuracao;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class GeradorRelatorio {
    String caminho = getClass().getResource("/").getPath();

    public void gerarRelatorioMensal(ArrayList<Relatorio> relatorio, Date dataInicio, Date dataFim) {
        Document doc = null;
        OutputStream os = null;

        try {
            Format d = new SimpleDateFormat("dd-MM-yyyy");
            String data_Inicio = d.format(dataInicio);
            String data_Fim = d.format(dataFim);
            
            
            File f = new File(Configuracao.CLASSPATH + "relatorios/Relatorio_Mensal(" + data_Inicio + "-" + data_Fim + ").pdf");
            
            System.out.println(Configuracao.CLASSPATH);
            os = new FileOutputStream(f);

            doc = new Document();
            PdfWriter.getInstance(doc, os);
            doc.open();
            PdfPTable cabecalho = new PdfPTable(2);
//	    Font fonteCabecalho = new Font(12, Font.BOLD); /* Será usada no cabeçalho. */
            Font fonteCabecalho = new Font(FontFamily.HELVETICA, 14, Font.BOLD);
            Font fonteDesc = new Font(); /*
             * Será usada na descrição.
             */
            float[] widths = {0.15f, 0.85f};
            cabecalho.setWidthPercentage(90); /*
             * Seta a largura da tabela com relação a página.
             */
            cabecalho.setWidths(widths);
            cabecalho.getDefaultCell().setBorder(PdfPCell.NO_BORDER);

            //Image img = Image.getInstance(getClass().getResource(caminho + "relatorios/LogoTop.png")); 
            Image img = Image.getInstance(Configuracao.CLASSPATH + "relatorios/LogoTop.png");

            img.setAlignment(Element.ALIGN_CENTER);
            doc.add(img);



            Paragraph p = new Paragraph("Prefeitura Municipal de Quixadá\n" + "Sistema Odontologico\n"
                    + "Relatório Mensal de Procedimentos - Período de: " + data_Inicio + " Até: " + data_Fim, fonteCabecalho);
            p.setAlignment(Element.ALIGN_CENTER);
            doc.add(p);

            doc.add(cabecalho);

            try {
                doc.add(getCabecalhoProcedimento(relatorio, fonteDesc));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            System.out.println("Gerando Relatorio");
            doc.close();
            os.close();



            System.out.println("Relatorio Gerado");

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }





    }

    public void gerarBPA(ArrayList<Relatorio> relatorio, Date dataInicio, Date dataFim) {
        Document doc = null;
        OutputStream os = null;


        try {
            Format d = new SimpleDateFormat("dd-MM-yyyy");
            String data_Inicio = d.format(dataInicio);
            String data_Fim = d.format(dataFim);
            File f = new File(Configuracao.CLASSPATH + "relatorios/BPA(" + data_Inicio + "-" + data_Fim + ").pdf");
            os = new FileOutputStream(f);

            doc = new Document();

            PdfWriter.getInstance(doc, os);
            doc.open();
            PdfPTable cabecalho = new PdfPTable(2);
//			Font fonteCabecalho = new Font(12, Font.BOLD); /* Será usada no cabeçalho. */
            Font fonteCabecalho = new Font(FontFamily.HELVETICA, 14, Font.BOLD);
            Font fonteDesc = new Font(); /*
             * Será usada na descrição.
             */
            float[] widths = {0.15f, 0.85f};
            cabecalho.setWidthPercentage(90); /*
             * Seta a largura da tabela com relação a página.
             */
            cabecalho.setWidths(widths);
            cabecalho.getDefaultCell().setBorder(PdfPCell.NO_BORDER);

            Image img = Image.getInstance(Configuracao.CLASSPATH + "relatorios/LogoTop.png");


            img.setAlignment(Element.ALIGN_CENTER);
            doc.add(img);


            Paragraph p = new Paragraph("Prefeitura Municipal de Quixadá\n" + "Sistema Odontologico\n"
                    + "Relatório BPA - Período de: " + data_Inicio + " Até: " + data_Fim, fonteCabecalho);
            p.setAlignment(Element.ALIGN_CENTER);
            doc.add(p);

            doc.add(cabecalho);

            try {
                doc.add(getCabecalhoBPA(relatorio, fonteDesc));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            System.out.println("Gerando Relatorio");
            doc.close();
            os.close();

            System.out.println("Relatorio Gerado");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }

    public PdfPTable getCabecalhoProcedimento(ArrayList<Relatorio> a, Font fonteRodaPe) {
        PdfPTable desc = new PdfPTable(4);
        float[] widths = new float[]{0.20f, 0.20f, 0.60f};
        desc.setSpacingBefore(10f);
        desc.setWidthPercentage(90); /*
         * Seta a largura da tabela com relação a página.
         */

        try {
            desc.setWidths(widths);
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Font fonteCabecalho = new Font(FontFamily.HELVETICA, 12, Font.BOLD);
        desc.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
        desc.getDefaultCell().setHorizontalAlignment(PdfPCell.ALIGN_JUSTIFIED);
        desc.addCell(new Phrase("Cod.: ", fonteCabecalho));//pega o id da atividade
        desc.addCell(new Phrase("Procedimento: ", fonteCabecalho)); //pega o local da atividade
        desc.addCell(new Phrase("Unidade de Saúde: ", fonteCabecalho)); //pega o local da atividade
        desc.addCell(new Phrase("Quantidade: ", fonteCabecalho)); //pega o local da atividade
        for (Relatorio relatorio : a) {

            desc.addCell(new Phrase("Cod.: " + relatorio.getCodigo()));
            desc.addCell(new Phrase(relatorio.getNome()));
            desc.addCell(new Phrase("" + relatorio.getUnidadeDeSaude()));
            desc.addCell(new Phrase("" + relatorio.getQuantidade()));


        }

        return desc;
    }

    public PdfPTable getCabecalhoBPA(ArrayList<Relatorio> a, Font fonteRodaPe) {
        PdfPTable desc = new PdfPTable(5);
        float[] widths = new float[]{0.20f, 0.20f, 0.60f};
        desc.setSpacingBefore(10f);
        desc.setWidthPercentage(90); /*
         * Seta a largura da tabela com relação a página.
         */

        try {
            desc.setWidths(widths);
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Font fonteCabecalho = new Font(FontFamily.HELVETICA, 12, Font.BOLD);
        desc.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
        desc.getDefaultCell().setHorizontalAlignment(PdfPCell.ALIGN_JUSTIFIED);
        desc.addCell(new Phrase("Cod.: ", fonteCabecalho));//pega o id da atividade
        desc.addCell(new Phrase("Procedimento: ", fonteCabecalho)); //pega o local da atividade
        desc.addCell(new Phrase("CBO: ", fonteCabecalho)); //pega o local da atividade
        desc.addCell(new Phrase("Idade: ", fonteCabecalho));
        desc.addCell(new Phrase("Quantidade: ", fonteCabecalho)); //pega o local da atividade
        for (Relatorio relatorio : a) {


            desc.addCell(new Phrase("Cod.: " + relatorio.getCodigo()));
            desc.addCell(new Phrase(relatorio.getNome()));

            desc.addCell(new Phrase("" + relatorio.getCbo()));
            desc.addCell(new Phrase("" + relatorio.getIdade()));
            desc.addCell(new Phrase("" + relatorio.getQuantidade()));


        }

        return desc;
    }
}