package bsuir.course.project.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "dialog_mes")
@Data
public class DialogMes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer dialog_mes_id;
    private String message;
    @ManyToOne
    @JoinColumn(name = "dialog_id")
    private Dialog dialog;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Integer getDialog_mes_id() {
        return dialog_mes_id;
    }

    public void setDialog_mes_id(Integer dialog_mes_id) {
        this.dialog_mes_id = dialog_mes_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Dialog getDialog() {
        return dialog;
    }

    public void setDialog(Dialog dialog) {
        this.dialog = dialog;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
