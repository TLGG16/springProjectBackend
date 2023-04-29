package bsuir.course.project.Service;

import bsuir.course.project.Entity.Advert;
import bsuir.course.project.Interfaces.AdvertService;
import bsuir.course.project.Repository.AdvertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdvertServiceImp implements AdvertService {

    @Autowired
    private AdvertRepository advertRepository;

    @Override
    public void createAdvert(Advert advert) {
        advertRepository.save(advert);
    }

    @Override
    public void deleteAdvert(Advert advert) {
        advertRepository.delete(advert);
    }

    @Override
    public void deleteAdvertById(Integer id) {
        advertRepository.deleteById(id);
    }

    @Override
    public void updateAdvert(Advert advert) {
        advertRepository.save(advert);
    }

    @Override
    public List<Advert> getAllAdverts() {
        return advertRepository.findAll();
    }

    @Override
    public Optional<Advert> getAdvertById(Integer id) {
        return advertRepository.findById(id);
    }
}
