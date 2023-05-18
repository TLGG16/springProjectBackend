package bsuir.course.project.Service;

import bsuir.course.project.Entity.Dialog;
import bsuir.course.project.Interfaces.DialogService;
import bsuir.course.project.Repository.DialogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DialogServiceImp implements DialogService {
    @Autowired
    private DialogRepository dialogRepository;

    @Override
    public void createDialog(Dialog dialog) {
        dialogRepository.save(dialog);
    }

    @Override
    public void deleteDialog(Dialog dialog) {
        dialogRepository.delete(dialog);
    }

    @Override
    public void deleteDialogById(Integer id) {
        dialogRepository.deleteById(id);
    }

    @Override
    public void updateDialog(Dialog dialog) {
        dialogRepository.save(dialog);
    }

    @Override
    public List<Dialog> getAllDialogs() {
        return dialogRepository.findAll();
    }

    @Override
    public Optional<Dialog> getDialogById(Integer id) {
        return dialogRepository.findById(id);
    }
}
