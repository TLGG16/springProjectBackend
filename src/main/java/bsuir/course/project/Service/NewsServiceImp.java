package bsuir.course.project.Service;

import bsuir.course.project.Entity.News;
import bsuir.course.project.Interfaces.NewsService;
import bsuir.course.project.Repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewsServiceImp implements NewsService {
    @Autowired
    private NewsRepository newsRepository;

    @Override
    public void createNews(News news) {
        newsRepository.save(news);
    }

    @Override
    public void deleteNews(News news) {
        newsRepository.delete(news);
    }

    @Override
    public void deleteNewsById(Integer id) {
        newsRepository.deleteById(id);
    }

    @Override
    public void updateNews(News news) {
        newsRepository.save(news);
    }

    @Override
    public List<News> getAllNews() {
        return newsRepository.findAll();
    }

    @Override
    public Optional<News> getNewsById(Integer id) {
        return newsRepository.findById(id);
    }
}
