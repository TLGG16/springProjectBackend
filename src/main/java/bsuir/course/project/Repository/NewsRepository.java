package bsuir.course.project.Repository;

import bsuir.course.project.Entity.Discussion;
import bsuir.course.project.Entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends JpaRepository<News, Integer> {
}
