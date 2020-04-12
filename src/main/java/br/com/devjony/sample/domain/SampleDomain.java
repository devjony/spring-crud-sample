package br.com.devjony.sample.domain;

import javax.persistence.*;

@Entity
@Table(name = "sample_domain")
public class SampleDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "attribute_name")
    private String attributeName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    @Override
    public String toString() {
        return "SampleDomain{" +
                "id=" + id +
                ", attributeName='" + attributeName + '\'' +
                '}';
    }
}
