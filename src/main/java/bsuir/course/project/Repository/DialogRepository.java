package bsuir.course.project.Repository;

import bsuir.course.project.Entity.Dialog;
import bsuir.course.project.Entity.Discussion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DialogRepository extends JpaRepository<Dialog, Integer> {
}
