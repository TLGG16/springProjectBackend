package bsuir.course.project.Service;

import bsuir.course.project.Entity.Favourite;
import bsuir.course.project.Interfaces.FavouriteService;
import bsuir.course.project.Repository.FavouriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FavouriteServiceImp implements FavouriteService {
    @Autowired
    private FavouriteRepository favouriteRepository;

    @Override
    public void createFavourite(Favourite favourite) {
        favouriteRepository.save(favourite);
    }

    @Override
    public void deleteFavourite(Favourite favourite) {
        favouriteRepository.delete(favourite);
    }

    @Override
    public void deleteFavouriteById(Integer id) {
        favouriteRepository.deleteById(id);
    }

    @Override
    public void updateFavourite(Favourite favourite) {
        favouriteRepository.save(favourite);
    }

    @Override
    public List<Favourite> getAllFavourites() {
        return favouriteRepository.findAll();
    }

    @Override
    public Optional<Favourite> getFavouriteById(Integer id) {
        return favouriteRepository.findById(id);
    }
}
