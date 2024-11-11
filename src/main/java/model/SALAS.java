package model;

public class SALAS {
    protected String NAME;
    protected Integer MANY;

    public SALAS(){
    }

    public SALAS(String NAME){
        this.NAME = NAME;
    }
    public SALAS(String NAME, Integer MANY) {
        this.NAME = NAME;
        this.MANY = MANY;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public int getMANY() {
        return MANY;
    }

    public void setMANY(Integer MANY) {
        this.MANY = MANY;
    }
}
