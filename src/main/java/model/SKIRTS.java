package model;

public class SKIRTS {
    protected String NAME;
    protected String BRAND;

    public SKIRTS(){
    }

    public SKIRTS(String NAME){
        this.NAME = NAME;
    }

    public SKIRTS(String NAME, String BRAND) {
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
