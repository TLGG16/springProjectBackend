package bsuir.course.project.Interfaces;



import bsuir.course.project.Entity.News;

import java.util.List;
import java.util.Optional;

public interface NewsService {
    void createNews(News news );
    void deleteNews(News news);
    void deleteNewsById(Integer id);
    void updateNews(News news);
    List<News> getAllNews();
    Optional<News> getNewsById(Integer id);
}
