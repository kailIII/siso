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
 * @author yarllysson
 */
@Embeddable
public class NecessidadesEspeciais implements Serializable {
    
    @PropertyDescriptor(displayName = "1. Está realizando Tratamento Médico?")
    private Boolean antecedenteNE01 = false;

    @PropertyDescriptor(displayName = "2. Está tomando algum Medicamento Atualmente?")
    private Boolean antecedenteNE02 = false;

    @PropertyDescriptor(displayName = "3. É alérgico a algum tipo de Medicamento?")
    private Boolean antecedenteNE03 = false;

    @PropertyDescriptor(displayName = "4. É alérgico a algum tipo de substância?")
    private Boolean antecedenteNE04 = false;

    @PropertyDescriptor(displayName = "5. Já fez algum tipo de cirurgia?")
    private Boolean antecedenteNE05 = false;

    @PropertyDescriptor(displayName = "6. Já fez algum tipo de cirurgia odontológica?")
    private Boolean antecedenteNE06 = false;

    @PropertyDescriptor(displayName = "7. Teve alguma Interco, Hemorrágica ou Alérgica?")
    private Boolean antecedenteNE07 = false;

    @PropertyDescriptor(displayName = "8. Sente-se cansado ou desmaia com frequência?")
    private Boolean antecedenteNE08 = false;

    @PropertyDescriptor(displayName = "9. Convulsionou ou Convulsiona atualmente?")
    private Boolean antecedenteNE09 = false;
    
    @PropertyDescriptor(displayName = "10. Tem sede com frequência?")
    private Boolean antecedenteNE10 = false;
    
    @PropertyDescriptor(displayName = "11. Perdeu ou ganhou peso recentemente?")
    private Boolean antecedenteNE11 = false;

    @PropertyDescriptor(displayName = "12. Quando se fere demora a cicatrizar?")
    private Boolean antecedenteNE12 = false;

    @PropertyDescriptor(displayName = "13. Tem ou teve Febre Reumática?")
    private Boolean antecedenteNE13 = false;

    @PropertyDescriptor(displayName = "14. Tem ou teve problema Cardíaco?")
    private Boolean antecedenteNE14 = false;

    @PropertyDescriptor(displayName = "15. Realizou algum tipo de tratamento Oncológico?")
    private Boolean antecedenteNE15 = false;

    @PropertyDescriptor(displayName = "16. Realizou transfusão saguínea")
    private Boolean antecedenteNE16 = false;

    @PropertyDescriptor(displayName = "17. fuma?")
    private Boolean antecedenteNE17 = false;

    @PropertyDescriptor(displayName = "18. Bebe?")
    private Boolean antecedenteNE18 = false;

    @PropertyDescriptor(displayName = "19. Usa Proteção Solar?")
    private Boolean antecedenteNE19 = false;
    
    @PropertyDescriptor(displayName = "20. Usa Preservativo nas relações Sexuais?")
    private Boolean antecedenteNE20 = false;
    
    @PropertyDescriptor(displayName = "21. Tem ou teve alguma doença importante que não tenha sido avaliada nesse momento?")
    private Boolean antecedenteNE21 = false;

    @Column(length = 30)
    @PropertyDescriptor(displayName = "Obs:")
    private String observacaoNE01;

    @Column(length = 30)
    @PropertyDescriptor(displayName = "Obs:")
    private String observacaoNE02;

    @Column(length = 30)
    @PropertyDescriptor(displayName = "Obs:")
    private String observacaoNE03;

    @Column(length = 30)
    @PropertyDescriptor(displayName = "Obs:")
    private String observacaoNE04;

    @Column(length = 30)
    @PropertyDescriptor(displayName = "Obs:")
    private String observacaoNE05;

    @Column(length = 30)
    @PropertyDescriptor(displayName = "Obs:")
    private String observacaoNE06;

    @Column(length = 30)
    @PropertyDescriptor(displayName = "Obs:")
    private String observacaoNE07;

    @Column(length = 30)
    @PropertyDescriptor(displayName = "Obs:")
    private String observacaoNE08;

    @Column(length = 30)
    @PropertyDescriptor(displayName = "Obs:")
    private String observacaoNE09;
    
    @Column(length = 30)
    @PropertyDescriptor(displayName = "Obs:")
    private String observacaoNE10;
    
    @Column(length = 30)
    @PropertyDescriptor(displayName = "Obs:")
    private String observacaoNE11;

    @Column(length = 30)
    @PropertyDescriptor(displayName = "Obs:")
    private String observacaoNE12;

    @Column(length = 30)
    @PropertyDescriptor(displayName = "Obs:")
    private String observacaoNE13;

    @Column(length = 30)
    @PropertyDescriptor(displayName = "Obs:")
    private String observacaoNE14;

    @Column(length = 30)
    @PropertyDescriptor(displayName = "Obs:")
    private String observacaoNE15;

    @Column(length = 30)
    @PropertyDescriptor(displayName = "Obs:")
    private String observacaoNE16;

    @Column(length = 30)
    @PropertyDescriptor(displayName = "Obs:")
    private String observacaoNE17;

    @Column(length = 30)
    @PropertyDescriptor(displayName = "Obs:")
    private String observacaoNE18;

    @Column(length = 30)
    @PropertyDescriptor(displayName = "Obs:")
    private String observacaoNE19;
    
    @Column(length = 30)
    @PropertyDescriptor(displayName = "Obs:")
    private String observacaoNE20;
    
    @Column(length = 30)
    @PropertyDescriptor(displayName = "Obs:")
    private String observacaoNE21;

    public Boolean getAntecedenteNE01() {
        return antecedenteNE01;
    }

    public void setAntecedenteNE01(Boolean antecedenteNE01) {
        this.antecedenteNE01 = antecedenteNE01;
    }

    public Boolean getAntecedenteNE02() {
        return antecedenteNE02;
    }

    public void setAntecedenteNE02(Boolean antecedenteNE02) {
        this.antecedenteNE02 = antecedenteNE02;
    }

    public Boolean getAntecedenteNE03() {
        return antecedenteNE03;
    }

    public void setAntecedenteNE03(Boolean antecedenteNE03) {
        this.antecedenteNE03 = antecedenteNE03;
    }

    public Boolean getAntecedenteNE04() {
        return antecedenteNE04;
    }

    public void setAntecedenteNE04(Boolean antecedenteNE04) {
        this.antecedenteNE04 = antecedenteNE04;
    }

    public Boolean getAntecedenteNE05() {
        return antecedenteNE05;
    }

    public void setAntecedenteNE05(Boolean antecedenteNE05) {
        this.antecedenteNE05 = antecedenteNE05;
    }

    public Boolean getAntecedenteNE06() {
        return antecedenteNE06;
    }

    public void setAntecedenteNE06(Boolean antecedenteNE06) {
        this.antecedenteNE06 = antecedenteNE06;
    }

    public Boolean getAntecedenteNE07() {
        return antecedenteNE07;
    }

    public void setAntecedenteNE07(Boolean antecedenteNE07) {
        this.antecedenteNE07 = antecedenteNE07;
    }

    public Boolean getAntecedenteNE08() {
        return antecedenteNE08;
    }

    public void setAntecedenteNE08(Boolean antecedenteNE08) {
        this.antecedenteNE08 = antecedenteNE08;
    }

    public Boolean getAntecedenteNE09() {
        return antecedenteNE09;
    }

    public void setAntecedenteNE09(Boolean antecedenteNE09) {
        this.antecedenteNE09 = antecedenteNE09;
    }

    public Boolean getAntecedenteNE10() {
        return antecedenteNE10;
    }

    public void setAntecedenteNE10(Boolean antecedenteNE10) {
        this.antecedenteNE10 = antecedenteNE10;
    }

    public Boolean getAntecedenteNE11() {
        return antecedenteNE11;
    }

    public void setAntecedenteNE11(Boolean antecedenteNE11) {
        this.antecedenteNE11 = antecedenteNE11;
    }

    public Boolean getAntecedenteNE12() {
        return antecedenteNE12;
    }

    public void setAntecedenteNE12(Boolean antecedenteNE12) {
        this.antecedenteNE12 = antecedenteNE12;
    }

    public Boolean getAntecedenteNE13() {
        return antecedenteNE13;
    }

    public void setAntecedenteNE13(Boolean antecedenteNE13) {
        this.antecedenteNE13 = antecedenteNE13;
    }

    public Boolean getAntecedenteNE14() {
        return antecedenteNE14;
    }

    public void setAntecedenteNE14(Boolean antecedenteNE14) {
        this.antecedenteNE14 = antecedenteNE14;
    }

    public Boolean getAntecedenteNE15() {
        return antecedenteNE15;
    }

    public void setAntecedenteNE15(Boolean antecedenteNE15) {
        this.antecedenteNE15 = antecedenteNE15;
    }

    public Boolean getAntecedenteNE16() {
        return antecedenteNE16;
    }

    public void setAntecedenteNE16(Boolean antecedenteNE16) {
        this.antecedenteNE16 = antecedenteNE16;
    }

    public Boolean getAntecedenteNE17() {
        return antecedenteNE17;
    }

    public void setAntecedenteNE17(Boolean antecedenteNE17) {
        this.antecedenteNE17 = antecedenteNE17;
    }

    public Boolean getAntecedenteNE18() {
        return antecedenteNE18;
    }

    public void setAntecedenteNE18(Boolean antecedenteNE18) {
        this.antecedenteNE18 = antecedenteNE18;
    }

    public Boolean getAntecedenteNE19() {
        return antecedenteNE19;
    }

    public void setAntecedenteNE19(Boolean antecedenteNE19) {
        this.antecedenteNE19 = antecedenteNE19;
    }

    public Boolean getAntecedenteNE20() {
        return antecedenteNE20;
    }

    public void setAntecedenteNE20(Boolean antecedenteNE20) {
        this.antecedenteNE20 = antecedenteNE20;
    }

    public Boolean getAntecedenteNE21() {
        return antecedenteNE21;
    }

    public void setAntecedenteNE21(Boolean antecedenteNE21) {
        this.antecedenteNE21 = antecedenteNE21;
    }

    public String getObservacaoNE01() {
        return observacaoNE01;
    }

    public void setObservacaoNE01(String observacaoNE01) {
        this.observacaoNE01 = observacaoNE01;
    }

    public String getObservacaoNE02() {
        return observacaoNE02;
    }

    public void setObservacaoNE02(String observacaoNE02) {
        this.observacaoNE02 = observacaoNE02;
    }

    public String getObservacaoNE03() {
        return observacaoNE03;
    }

    public void setObservacaoNE03(String observacaoNE03) {
        this.observacaoNE03 = observacaoNE03;
    }

    public String getObservacaoNE04() {
        return observacaoNE04;
    }

    public void setObservacaoNE04(String observacaoNE04) {
        this.observacaoNE04 = observacaoNE04;
    }

    public String getObservacaoNE05() {
        return observacaoNE05;
    }

    public void setObservacaoNE05(String observacaoNE05) {
        this.observacaoNE05 = observacaoNE05;
    }

    public String getObservacaoNE06() {
        return observacaoNE06;
    }

    public void setObservacaoNE06(String observacaoNE06) {
        this.observacaoNE06 = observacaoNE06;
    }

    public String getObservacaoNE07() {
        return observacaoNE07;
    }

    public void setObservacaoNE07(String observacaoNE07) {
        this.observacaoNE07 = observacaoNE07;
    }

    public String getObservacaoNE08() {
        return observacaoNE08;
    }

    public void setObservacaoNE08(String observacaoNE08) {
        this.observacaoNE08 = observacaoNE08;
    }

    public String getObservacaoNE09() {
        return observacaoNE09;
    }

    public void setObservacaoNE09(String observacaoNE09) {
        this.observacaoNE09 = observacaoNE09;
    }

    public String getObservacaoNE10() {
        return observacaoNE10;
    }

    public void setObservacaoNE10(String observacaoNE10) {
        this.observacaoNE10 = observacaoNE10;
    }

    public String getObservacaoNE11() {
        return observacaoNE11;
    }

    public void setObservacaoNE11(String observacaoNE11) {
        this.observacaoNE11 = observacaoNE11;
    }

    public String getObservacaoNE12() {
        return observacaoNE12;
    }

    public void setObservacaoNE12(String observacaoNE12) {
        this.observacaoNE12 = observacaoNE12;
    }

    public String getObservacaoNE13() {
        return observacaoNE13;
    }

    public void setObservacaoNE13(String observacaoNE13) {
        this.observacaoNE13 = observacaoNE13;
    }

    public String getObservacaoNE14() {
        return observacaoNE14;
    }

    public void setObservacaoNE14(String observacaoNE14) {
        this.observacaoNE14 = observacaoNE14;
    }

    public String getObservacaoNE15() {
        return observacaoNE15;
    }

    public void setObservacaoNE15(String observacaoNE15) {
        this.observacaoNE15 = observacaoNE15;
    }

    public String getObservacaoNE16() {
        return observacaoNE16;
    }

    public void setObservacaoNE16(String observacaoNE16) {
        this.observacaoNE16 = observacaoNE16;
    }

    public String getObservacaoNE17() {
        return observacaoNE17;
    }

    public void setObservacaoNE17(String observacaoNE17) {
        this.observacaoNE17 = observacaoNE17;
    }

    public String getObservacaoNE18() {
        return observacaoNE18;
    }

    public void setObservacaoNE18(String observacaoNE18) {
        this.observacaoNE18 = observacaoNE18;
    }

    public String getObservacaoNE19() {
        return observacaoNE19;
    }

    public void setObservacaoNE19(String observacaoNE19) {
        this.observacaoNE19 = observacaoNE19;
    }

    public String getObservacaoNE20() {
        return observacaoNE20;
    }

    public void setObservacaoNE20(String observacaoNE20) {
        this.observacaoNE20 = observacaoNE20;
    }

    public String getObservacaoNE21() {
        return observacaoNE21;
    }

    public void setObservacaoNE21(String observacaoNE21) {
        this.observacaoNE21 = observacaoNE21;
    }

    
    
}
