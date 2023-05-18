package bsuir.course.project.Service;

import bsuir.course.project.Entity.DialogMes;
import bsuir.course.project.Entity.DiscussionComment;
import bsuir.course.project.Interfaces.DialogMesService;
import bsuir.course.project.Repository.DialogMesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DialogMesServiceImp implements DialogMesService {
    @Autowired
    private DialogMesRepository dialogMesRepository;


    @Override
    public List<DialogMes> getDialogMesByDialogId(Integer id) {
        List<DialogMes> discussionCommentList = dialogMesRepository.findAll();
        List<DialogMes> answ = new ArrayList<>();
        for (DialogMes com: discussionCommentList
        ) {
            if (com.getDialog().getDialog_id().equals(id)){
                answ.add(com);
            }
        }
        return answ;
    }

    @Override
    public void createDialogMes(DialogMes dialogMes) {
        dialogMesRepository.save(dialogMes);
    }

    @Override
    public void deleteDialogMes(DialogMes dialogMes) {
        dialogMesRepository.delete(dialogMes);
    }

    @Override
    public void deleteDialogMesById(Integer id) {
        dialogMesRepository.deleteById(id);
    }

    @Override
    public void updateDialogMes(DialogMes dialogMes) {
        dialogMesRepository.save(dialogMes);
    }

    @Override
    public List<DialogMes> getAllDialogMes() {
        return dialogMesRepository.findAll();
    }

    @Override
    public Optional<DialogMes> getDialogMesById(Integer id) {
        return dialogMesRepository.findById(id);
    }
}
