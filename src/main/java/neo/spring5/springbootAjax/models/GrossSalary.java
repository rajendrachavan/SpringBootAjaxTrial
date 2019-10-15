package neo.spring5.springbootAjax.models;

import javax.persistence.Embeddable;

@Embeddable
public class GrossSalary {

    private int basicSalary;
    private int HRA;
    private int TrA;

    public GrossSalary() {
    }

    public GrossSalary(int basicSalary, int HRA, int trA) {
        this.basicSalary = basicSalary;
        this.HRA = HRA;
        TrA = trA;
    }

    public int getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(int basicSalary) {
        this.basicSalary = basicSalary;
    }

    public int getHRA() {
        return HRA;
    }

    public void setHRA(int HRA) {
        this.HRA = HRA;
    }

    public int getTrA() {
        return TrA;
    }

    public void setTrA(int trA) {
        TrA = trA;
    }
}