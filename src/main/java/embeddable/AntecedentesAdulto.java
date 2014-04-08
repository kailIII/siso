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
public class AntecedentesAdulto implements Serializable {

    @PropertyDescriptor(displayName = "1. Abscessos dentários?")
    private Boolean antecedenteA01 = false;

    @PropertyDescriptor(displayName = "2. Abscessos gengivais?")
    private Boolean antecedenteA02 = false;

    @PropertyDescriptor(displayName = "3. Respiração bucal?")
    private Boolean antecedenteA03 = false;

    @PropertyDescriptor(displayName = "4. Sangramento gengival?")
    private Boolean antecedenteA04 = false;

    @PropertyDescriptor(displayName = "5. Mal Hálito?")
    private Boolean antecedenteA05 = false;

    @PropertyDescriptor(displayName = "6. Dores no rosto pela manha?")
    private Boolean antecedenteA06 = false;

    @PropertyDescriptor(displayName = "7. Frequência dores de cabeça?")
    private Boolean antecedenteA07 = false;

    @PropertyDescriptor(displayName = "8. Usa prótese?")
    private Boolean antecedenteA08 = false;

    @PropertyDescriptor(displayName = "9. Bruxismo?")
    private Boolean antecedenteA09 = false;

    @Column(length = 30)
    @PropertyDescriptor(displayName = "Obs:")
    private String observacaoA01;

    @Column(length = 30)
    @PropertyDescriptor(displayName = "Obs:")
    private String observacaoA02;

    @Column(length = 30)
    @PropertyDescriptor(displayName = "Obs:")
    private String observacaoA03;

    @Column(length = 30)
    @PropertyDescriptor(displayName = "Obs:")
    private String observacaoA04;

    @Column(length = 30)
    @PropertyDescriptor(displayName = "Obs:")
    private String observacaoA05;

    @Column(length = 30)
    @PropertyDescriptor(displayName = "Obs:")
    private String observacaoA06;

    @Column(length = 30)
    @PropertyDescriptor(displayName = "Obs:")
    private String observacaoA07;

    @Column(length = 30)
    @PropertyDescriptor(displayName = "Obs:")
    private String observacaoA08;

    @Column(length = 30)
    @PropertyDescriptor(displayName = "Obs:")
    private String observacaoA09;

    public Boolean getAntecedenteA01() {
        return antecedenteA01;
    }

    public void setAntecedenteA01(Boolean antecedenteA01) {
        this.antecedenteA01 = antecedenteA01;
    }

    public Boolean getAntecedenteA02() {
        return antecedenteA02;
    }

    public void setAntecedenteA02(Boolean antecedenteA02) {
        this.antecedenteA02 = antecedenteA02;
    }

    public Boolean getAntecedenteA03() {
        return antecedenteA03;
    }

    public void setAntecedenteA03(Boolean antecedenteA03) {
        this.antecedenteA03 = antecedenteA03;
    }

    public Boolean getAntecedenteA04() {
        return antecedenteA04;
    }

    public void setAntecedenteA04(Boolean antecedenteA04) {
        this.antecedenteA04 = antecedenteA04;
    }

    public Boolean getAntecedenteA05() {
        return antecedenteA05;
    }

    public void setAntecedenteA05(Boolean antecedenteA05) {
        this.antecedenteA05 = antecedenteA05;
    }

    public Boolean getAntecedenteA06() {
        return antecedenteA06;
    }

    public void setAntecedenteA06(Boolean antecedenteA06) {
        this.antecedenteA06 = antecedenteA06;
    }

    public Boolean getAntecedenteA07() {
        return antecedenteA07;
    }

    public void setAntecedenteA07(Boolean antecedenteA07) {
        this.antecedenteA07 = antecedenteA07;
    }

    public Boolean getAntecedenteA08() {
        return antecedenteA08;
    }

    public void setAntecedenteA08(Boolean antecedenteA08) {
        this.antecedenteA08 = antecedenteA08;
    }

    public Boolean getAntecedenteA09() {
        return antecedenteA09;
    }

    public void setAntecedenteA09(Boolean antecedenteA09) {
        this.antecedenteA09 = antecedenteA09;
    }

    public String getObservacaoA01() {
        return observacaoA01;
    }

    public void setObservacaoA01(String observacaoA01) {
        this.observacaoA01 = observacaoA01;
    }

    public String getObservacaoA02() {
        return observacaoA02;
    }

    public void setObservacaoA02(String observacaoA02) {
        this.observacaoA02 = observacaoA02;
    }

    public String getObservacaoA03() {
        return observacaoA03;
    }

    public void setObservacaoA03(String observacaoA03) {
        this.observacaoA03 = observacaoA03;
    }

    public String getObservacaoA04() {
        return observacaoA04;
    }

    public void setObservacaoA04(String observacaoA04) {
        this.observacaoA04 = observacaoA04;
    }

    public String getObservacaoA05() {
        return observacaoA05;
    }

    public void setObservacaoA05(String observacaoA05) {
        this.observacaoA05 = observacaoA05;
    }

    public String getObservacaoA06() {
        return observacaoA06;
    }

    public void setObservacaoA06(String observacaoA06) {
        this.observacaoA06 = observacaoA06;
    }

    public String getObservacaoA07() {
        return observacaoA07;
    }

    public void setObservacaoA07(String observacaoA07) {
        this.observacaoA07 = observacaoA07;
    }

    public String getObservacaoA08() {
        return observacaoA08;
    }

    public void setObservacaoA08(String observacaoA08) {
        this.observacaoA08 = observacaoA08;
    }

    public String getObservacaoA09() {
        return observacaoA09;
    }

    public void setObservacaoA09(String observacaoA09) {
        this.observacaoA09 = observacaoA09;
    }
}
