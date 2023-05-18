package bsuir.course.project.Controller;

import bsuir.course.project.Entity.Dialog;
import bsuir.course.project.Entity.DialogMes;
import bsuir.course.project.Entity.Discussion;
import bsuir.course.project.Entity.DiscussionComment;
import bsuir.course.project.Interfaces.DialogMesService;
import bsuir.course.project.Interfaces.DialogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class DialogController {

    @Autowired
    private DialogService dialogService;
    @Autowired
    private DialogMesService dialogMesService;

    @PostMapping("/dialog/create")
    public HttpStatus dialogCreate(@RequestBody Dialog dialog){
        System.out.println("Созданно dialog");

        dialogService.createDialog(dialog);
        return HttpStatus.ACCEPTED;
    }
    @PostMapping("/dialogmes")
    public HttpStatus dialogMesCreate(@RequestBody DialogMes dialogMes){
        List<Dialog> dialogList = dialogService.getAllDialogs();
        for (Dialog d: dialogList
             ) {
            if (d.getUser().getUser_id() == dialogMes.getDialog().getUser().getUser_id() &&
                    d.getAdvert().getAdvert_id().equals(dialogMes.getDialog().getAdvert().getAdvert_id())
            ){
                dialogMes.setDialog(d);
            }
        }
        System.out.println(dialogMes.getDialog().getDialog_id());
        System.out.println(dialogMes.getUser().getUser_id());
        dialogMesService.createDialogMes(dialogMes);
        System.out.println("Созданно dialogMes");
        return HttpStatus.ACCEPTED;
    }

    @GetMapping("/dialogmenu/{id}")
    public ResponseEntity<List<Dialog>> dialogmenuGet(@PathVariable Integer id){
        System.out.println("Получен get запрос для Dialog " + LocalDateTime.now());
        List<Dialog> dialogList = dialogService.getAllDialogs().stream().filter(item -> item.getAdvert().getUser().getUser_id() == id).collect(Collectors.toList());
        List<Dialog> answ = new ArrayList<>();
        for (Dialog d: dialogList
             ) {
            if (dialogMesService.getDialogMesByDialogId(d.getDialog_id())!=null){
                answ.add(d);
            }
        }
        return new ResponseEntity<>( answ, HttpStatus.OK);
    }
    @GetMapping("/dialog/{id}")
    public ResponseEntity<List<DialogMes>> dialogMesGetById(@PathVariable Integer id){
        System.out.println("Получен get запрос для Dialog " + LocalDateTime.now());
        return new ResponseEntity<>( dialogMesService.getDialogMesByDialogId(id), HttpStatus.OK);
    }
    @GetMapping("/dialogget/{id}")
    public ResponseEntity<Dialog> dialogGetById(@PathVariable Integer id){
        System.out.println("Получен get запрос для Dialog " + LocalDateTime.now());
        return new ResponseEntity<>( dialogService.getDialogById(id).get(), HttpStatus.OK);
    }


    @PostMapping("/dialog")
    public ResponseEntity<List<DialogMes>> dialogIsExist(@RequestBody Dialog dialog){
        System.out.println("Получен post запрос для Dialog " + LocalDateTime.now());
        List<Dialog> dialogList = dialogService.getAllDialogs();
        for (Dialog d: dialogList
             ) {
            if (d.getAdvert().getAdvert_id().equals(dialog.getAdvert().getAdvert_id())
                    && (d.getUser().getUser_id() ==dialog.getUser().getUser_id())
            ){
                return new ResponseEntity<>( dialogMesService.getDialogMesByDialogId(d.getDialog_id()), HttpStatus.OK);
            }
        }
        dialogService.createDialog(dialog);
        return new ResponseEntity<>( null, HttpStatus.OK);

    }

    @DeleteMapping("/dialog/{id}")
    public HttpStatus dialogDelete(@PathVariable Integer id){
        System.out.println("Получен delete запрос для Dialog для id "+ id);
        dialogService.deleteDialogById(id);
        return HttpStatus.OK;
    }

}
