package model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Valter on 7/30/2015.
 */

@Entity
@Table(name="ring_chart")
public class RingChart {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    private Date date;

    private String security;

    private Double weighting;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSecurity() {
        return security;
    }

    public void setSecurity(String security) {
        this.security = security;
    }

    public Double getWeighting() {
        return weighting;
    }

    public void setWeighting(Double weighting) {
        this.weighting = weighting;
    }

    @Override
    public String toString() {
        return "DrawRingChart{" +
                "id=" + id +
                ", date=" + date +
                ", security='" + security + '\'' +
                ", weighting=" + weighting +
                '}';
    }
}
