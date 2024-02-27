package com.example.springbootquiz.sale;

import com.example.springbootquiz.client.Client;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Sale {
    @Id
    @SequenceGenerator(name = "sale_sequence", sequenceName = "sale_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sale_sequence")
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @ManyToOne
    private Client client;

    private String seller;

    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL)
    private List<Transaction> transactions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", creationDate=" + creationDate +
                ", client=" + client +
                ", seller=" + seller +
                '}';
    }
}