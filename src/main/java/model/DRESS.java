package model;

public class DRESS {

    protected String NAME;
    protected String BRAND;

    public DRESS(){
    }

    public DRESS(String NAME){
        this.NAME = NAME;
    }
    public DRESS(String NAME, String BRAND) {
        this.NAME = NAME;
        this.BRAND = BRAND;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getBRAND() {
        return BRAND;
    }

    public void setBRAND(String BRAND) {
        this.BRAND = BRAND;
    }
}
