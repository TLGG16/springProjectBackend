package bsuir.course.project.Repository;

import bsuir.course.project.Entity.Favourite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface FavouriteRepository extends JpaRepository<Favourite, Integer> {
}
