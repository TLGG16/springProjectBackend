package bsuir.course.project.Interfaces;

import bsuir.course.project.Entity.Dialog;
import bsuir.course.project.Entity.DialogMes;
import bsuir.course.project.Entity.Discussion;

import java.util.List;
import java.util.Optional;

public interface DialogService {
    void createDialog(Dialog dialog);
    void deleteDialog(Dialog dialog);
    void deleteDialogById(Integer id);
    void updateDialog(Dialog dialog);
    List<Dialog> getAllDialogs();
    Optional<Dialog> getDialogById(Integer id);
}
