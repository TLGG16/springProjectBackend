package bsuir.course.project.Repository;

import bsuir.course.project.Entity.Advert;
import bsuir.course.project.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertRepository extends JpaRepository<Advert, Integer> {
}
