package bsuir.course.project.Repository;

import bsuir.course.project.Entity.DialogMes;
import bsuir.course.project.Entity.Discussion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DialogMesRepository extends JpaRepository<DialogMes, Integer> {
}
