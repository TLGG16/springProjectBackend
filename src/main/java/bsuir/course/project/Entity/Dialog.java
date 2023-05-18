package bsuir.course.project.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "dialog")
@Data
public class Dialog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer dialog_id;

    @ManyToOne
    @JoinColumn(name = "advert_id")
    private Advert advert;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(mappedBy = "dialog")
    private Set<DialogMes> dialog_mes_list;

    public Integer getDialog_id() {
        return dialog_id;
    }

    public void setDialog_id(Integer dialog_id) {
        this.dialog_id = dialog_id;
    }

    public Advert getAdvert() {
        return advert;
    }

    public void setAdvert(Advert advert) {
        this.advert = advert;
    }

    public Set<DialogMes> getDialog_mes_list() {
        return dialog_mes_list;
    }

    public void setDialog_mes_list(Set<DialogMes> dialog_mes_list) {
        this.dialog_mes_list = dialog_mes_list;
    }
}
