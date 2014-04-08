/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package embeddable;
import entities.annotations.PropertyDescriptor;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Java
 */
@Embeddable
public class AntecedentesCrianca implements Serializable {

    @PropertyDescriptor(displayName = "1. Problemas da aprendizagem/comportamento?")
    private Boolean antecedente01 = false;

    @PropertyDescriptor(displayName = "2. Problema sensorial (visão, audição, olfato)?")
    private Boolean antecedente02 = false;

    @PropertyDescriptor(displayName = "3. Resistencia ao atendimento odontológico?")
    private Boolean antecedente03 = false;

    @PropertyDescriptor(displayName = "4. Uso noturno de mamadeira?")
    private Boolean antecedente04 = false;

    @PropertyDescriptor(displayName = "5. Trauma nos dentes decíduos?")
    private Boolean antecedente05 = false;

    @PropertyDescriptor(displayName = "6. Faz uso de chupeta ou chupa o dedo?")
    private Boolean antecedente06 = false;

    @PropertyDescriptor(displayName = "7. Perda precoce dos dentes decíduos?")
    private Boolean antecedente07 = false;

    @PropertyDescriptor(displayName = "8. Problema na erupção dos dentes?")
    private Boolean antecedente08 = false;

    @PropertyDescriptor(displayName = "9. Reação anestésico local?")
    private Boolean antecedente09 = false;

    @PropertyDescriptor(displayName = "10. Respiração bucal?")
    private Boolean antecedente10 = false;

    @PropertyDescriptor(displayName = "11. Problema de posicionamento dos dentes?")
    private Boolean antecedente11 = false;

    @PropertyDescriptor(displayName = "12. Usa alimentos como doces, refrigerantes com muita frequência?")
    private Boolean antecedente12 = false;

    @Column(length = 30)
    @PropertyDescriptor(displayName = "Obs:")
    private String observacao01;

    @Column(length = 30)
    @PropertyDescriptor(displayName = "Obs:")
    private String observacao02;

    @Column(length = 30)
    @PropertyDescriptor(displayName = "Obs:")
    private String observacao03;

    @Column(length = 30)
    @PropertyDescriptor(displayName = "Obs:")
    private String observacao04;

    @Column(length = 30)
    @PropertyDescriptor(displayName = "Obs:")
    private String observacao05;

    @Column(length = 30)
    @PropertyDescriptor(displayName = "Obs:")
    private String observacao06;

    @Column(length = 30)
    @PropertyDescriptor(displayName = "Obs:")
    private String observacao07;

    @Column(length = 30)
    @PropertyDescriptor(displayName = "Obs:")
    private String observacao08;

    @Column(length = 30)
    @PropertyDescriptor(displayName = "Obs:")
    private String observacao09;

    @Column(length = 30)
    @PropertyDescriptor(displayName = "Obs:")
    private String observacao10;

    @Column(length = 30)
    @PropertyDescriptor(displayName = "Obs:")
    private String observacao11;

    @Column(length = 30)
    @PropertyDescriptor(displayName = "Obs:")
    private String observacao12;

    public Boolean getAntecedente01() {
        return antecedente01;
    }

    public void setAntecedente01(Boolean antecedente01) {
        this.antecedente01 = antecedente01;
    }

    public Boolean getAntecedente02() {
        return antecedente02;
    }

    public void setAntecedente02(Boolean antecedente02) {
        this.antecedente02 = antecedente02;
    }

    public Boolean getAntecedente03() {
        return antecedente03;
    }

    public void setAntecedente03(Boolean antecedente03) {
        this.antecedente03 = antecedente03;
    }

    public Boolean getAntecedente04() {
        return antecedente04;
    }

    public void setAntecedente04(Boolean antecedente04) {
        this.antecedente04 = antecedente04;
    }

    public Boolean getAntecedente05() {
        return antecedente05;
    }

    public void setAntecedente05(Boolean antecedente05) {
        this.antecedente05 = antecedente05;
    }

    public Boolean getAntecedente06() {
        return antecedente06;
    }

    public void setAntecedente06(Boolean antecedente06) {
        this.antecedente06 = antecedente06;
    }

    public Boolean getAntecedente07() {
        return antecedente07;
    }

    public void setAntecedente07(Boolean antecedente07) {
        this.antecedente07 = antecedente07;
    }

    public Boolean getAntecedente08() {
        return antecedente08;
    }

    public void setAntecedente08(Boolean antecedente08) {
        this.antecedente08 = antecedente08;
    }

    public Boolean getAntecedente09() {
        return antecedente09;
    }

    public void setAntecedente09(Boolean antecedente09) {
        this.antecedente09 = antecedente09;
    }

    public Boolean getAntecedente10() {
        return antecedente10;
    }

    public void setAntecedente10(Boolean antecedente10) {
        this.antecedente10 = antecedente10;
    }

    public Boolean getAntecedente11() {
        return antecedente11;
    }

    public void setAntecedente11(Boolean antecedente11) {
        this.antecedente11 = antecedente11;
    }

    public Boolean getAntecedente12() {
        return antecedente12;
    }

    public void setAntecedente12(Boolean antecedente12) {
        this.antecedente12 = antecedente12;
    }

    public String getObservacao01() {
        return observacao01;
    }

    public void setObservacao01(String observacao01) {
        this.observacao01 = observacao01;
    }

    public String getObservacao02() {
        return observacao02;
    }

    public void setObservacao02(String observacao02) {
        this.observacao02 = observacao02;
    }

    public String getObservacao03() {
        return observacao03;
    }

    public void setObservacao03(String observacao03) {
        this.observacao03 = observacao03;
    }

    public String getObservacao04() {
        return observacao04;
    }

    public void setObservacao04(String observacao04) {
        this.observacao04 = observacao04;
    }

    public String getObservacao05() {
        return observacao05;
    }

    public void setObservacao05(String observacao05) {
        this.observacao05 = observacao05;
    }

    public String getObservacao06() {
        return observacao06;
    }

    public void setObservacao06(String observacao06) {
        this.observacao06 = observacao06;
    }

    public String getObservacao07() {
        return observacao07;
    }

    public void setObservacao07(String observacao07) {
        this.observacao07 = observacao07;
    }

    public String getObservacao08() {
        return observacao08;
    }

    public void setObservacao08(String observacao08) {
        this.observacao08 = observacao08;
    }

    public String getObservacao09() {
        return observacao09;
    }

    public void setObservacao09(String observacao09) {
        this.observacao09 = observacao09;
    }

    public String getObservacao10() {
        return observacao10;
    }

    public void setObservacao10(String observacao10) {
        this.observacao10 = observacao10;
    }

    public String getObservacao11() {
        return observacao11;
    }

    public void setObservacao11(String observacao11) {
        this.observacao11 = observacao11;
    }

    public String getObservacao12() {
        return observacao12;
    }

    public void setObservacao12(String observacao12) {
        this.observacao12 = observacao12;
    }
}