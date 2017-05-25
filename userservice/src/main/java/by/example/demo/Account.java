package by.example.demo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.Objects;

@Entity
public class Account {

    @Id
    @GeneratedValue
    @Column(name = "id_account")
    private Integer id;
    private int amount;
    private String currency;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_client")
    private Client client;

    public Account(int amount, String currency, Client client) {
        this.amount = amount;
        this.currency = currency;
        this.client = client;
    }

    public Account() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return amount == account.amount &&
                Objects.equals(id, account.id) &&
                Objects.equals(currency, account.currency) &&
                Objects.equals(client, account.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, currency, client);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Account{");
        sb.append("id=").append(id);
        sb.append(", amount=").append(amount);
        sb.append(", currency='").append(currency).append('\'');
        sb.append(", client=").append(client);
        sb.append('}');
        return sb.toString();
    }
}
