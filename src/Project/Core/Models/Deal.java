package Project.Core.Models;

public class Deal {

    private Long id;
    private String main;
    private String shortDescription;
    private String description;
    private int price;
    private String picture1;
    private String picture2;
    private String picture3;
    private Client client;


    public Deal(Long id, String main, String shortDescription,String description, int price, String picture1, String picture2, String picture3, Client client) {
        this.id = id;
        this.main = main;
        this.shortDescription = shortDescription;
        this.description = description;
        this.price = price;
        this.picture1 = picture1;
        this.picture2 = picture2;
        this.picture3 = picture3;
        this.client = client;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getPicture1() {
        return picture1;
    }

    public void setPicture1(String picture1) {
        this.picture1 = picture1;
    }

    public String getPicture2() {
        return picture2;
    }

    public void setPicture2(String picture2) {
        this.picture2 = picture2;
    }

    public String getPicture3() {
        return picture3;
    }

    public void setPicture3(String picture3) {
        this.picture3 = picture3;
    }


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Deal() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}


