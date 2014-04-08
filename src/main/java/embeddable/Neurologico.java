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
public class Neurologico implements Serializable {
    
    @PropertyDescriptor(displayName = "1. Intercorrência na Gestação?")
    private Boolean antecedenteN01 = false;

    @PropertyDescriptor(displayName = "2. Convulsionou ou Convulsiona Atualmente?")
    private Boolean antecedenteN02 = false;

    @PropertyDescriptor(displayName = "3. Está tomando algum medicamento atualmente?")
    private Boolean antecedenteN03 = false;

    @PropertyDescriptor(displayName = "4. Teve algum tipo de Experiência Negativa?")
    private Boolean antecedenteN04 = false;

    @PropertyDescriptor(displayName = "5. Tem alguma dificuldade de Compreensão?")
    private Boolean antecedenteN05 = false;

    @PropertyDescriptor(displayName = "6. Principal forma de Comunicação?")
    private Boolean antecedenteN06 = false;

    @Column(length = 30)
    @PropertyDescriptor(displayName = "Obs:")
    private String observacaoN01;

    @Column(length = 30)
    @PropertyDescriptor(displayName = "Obs:")
    private String observacaoN02;

    @Column(length = 30)
    @PropertyDescriptor(displayName = "Obs:")
    private String observacaoN03;

    @Column(length = 30)
    @PropertyDescriptor(displayName = "Obs:")
    private String observacaoN04;

    @Column(length = 30)
    @PropertyDescriptor(displayName = "Obs:")
    private String observacaoN05;

    @Column(length = 30)
    @PropertyDescriptor(displayName = "Obs:")
    private String observacaoN06;

    public Boolean getAntecedenteN01() {
        return antecedenteN01;
    }

    public void setAntecedenteN01(Boolean antecedenteN01) {
        this.antecedenteN01 = antecedenteN01;
    }

    public Boolean getAntecedenteN02() {
        return antecedenteN02;
    }

    public void setAntecedenteN02(Boolean antecedenteN02) {
        this.antecedenteN02 = antecedenteN02;
    }

    public Boolean getAntecedenteN03() {
        return antecedenteN03;
    }

    public void setAntecedenteN03(Boolean antecedenteN03) {
        this.antecedenteN03 = antecedenteN03;
    }

    public Boolean getAntecedenteN04() {
        return antecedenteN04;
    }

    public void setAntecedenteN04(Boolean antecedenteN04) {
        this.antecedenteN04 = antecedenteN04;
    }

    public Boolean getAntecedenteN05() {
        return antecedenteN05;
    }

    public void setAntecedenteN05(Boolean antecedenteN05) {
        this.antecedenteN05 = antecedenteN05;
    }

    public Boolean getAntecedenteN06() {
        return antecedenteN06;
    }

    public void setAntecedenteN06(Boolean antecedenteN06) {
        this.antecedenteN06 = antecedenteN06;
    }

    public String getObservacaoN01() {
        return observacaoN01;
    }

    public void setObservacaoN01(String observacaoN01) {
        this.observacaoN01 = observacaoN01;
    }

    public String getObservacaoN02() {
        return observacaoN02;
    }

    public void setObservacaoN02(String observacaoN02) {
        this.observacaoN02 = observacaoN02;
    }

    public String getObservacaoN03() {
        return observacaoN03;
    }

    public void setObservacaoN03(String observacaoN03) {
        this.observacaoN03 = observacaoN03;
    }

    public String getObservacaoN04() {
        return observacaoN04;
    }

    public void setObservacaoN04(String observacaoN04) {
        this.observacaoN04 = observacaoN04;
    }

    public String getObservacaoN05() {
        return observacaoN05;
    }

    public void setObservacaoN05(String observacaoN05) {
        this.observacaoN05 = observacaoN05;
    }

    public String getObservacaoN06() {
        return observacaoN06;
    }

    public void setObservacaoN06(String observacaoN06) {
        this.observacaoN06 = observacaoN06;
    }

    
}
