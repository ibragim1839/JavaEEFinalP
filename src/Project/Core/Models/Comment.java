package Project.Core.Models;

import java.sql.Timestamp;

public class Comment {

    private Long id;
    private Deal deal;
    private Client client;
    private String comment;
    private Timestamp date;

    public Comment(Long id, Deal deal, Client client, String comment, Timestamp date) {
        this.id = id;
        this.deal = deal;
        this.client = client;
        this.comment = comment;
        this.date = date;
    }

    public Comment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Deal getDeal() {
        return deal;
    }

    public void setDeal(Deal deal) {
        this.deal = deal;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}
