package bsuir.course.project.Interfaces;

import bsuir.course.project.Entity.Dialog;
import bsuir.course.project.Entity.DialogMes;

import java.util.List;
import java.util.Optional;

public interface DialogMesService {
    List<DialogMes> getDialogMesByDialogId(Integer id);

    void createDialogMes(DialogMes dialogMes);
    void deleteDialogMes(DialogMes dialogMes);
    void deleteDialogMesById(Integer id);
    void updateDialogMes(DialogMes dialogMes);
    List<DialogMes> getAllDialogMes();
    Optional<DialogMes> getDialogMesById(Integer id);
}
