package org.com.entity;

import com.fasterxml.jackson.annotation.JsonGetter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "brands")
@AttributeOverride(name = "id", column = @Column(name = "id"))
public class Brand extends AbstractEntity {
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "status", nullable = false, length = 50)
    private String status;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "brand")
    private List<Phone> phones;

    public Brand() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    @JsonGetter("phones")
    public int getPhonesSize() {
        return phones.size();
    }
}
