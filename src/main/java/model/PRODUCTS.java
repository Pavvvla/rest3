package model;

public class PRODUCTS {
    protected int ARTICLE;
    protected String PRODUCTS;

    public PRODUCTS(){
    }

    public PRODUCTS(int ARTICLE){
        this.ARTICLE = ARTICLE;
    }
    public PRODUCTS(int ARTICLE, String PRODUCTS) {
        this.ARTICLE = ARTICLE;
        this.PRODUCTS = PRODUCTS;
    }

    public String getPRODUCTS() {
        return PRODUCTS;
    }

    public void setPRODUCTS(String PRODUCTS) {
        this.PRODUCTS = PRODUCTS;
    }

    public int getARTICLE() {
        return ARTICLE;
    }

    public void setARTICLE(int ARTICLE) {
        this.ARTICLE = ARTICLE;
    }
}
