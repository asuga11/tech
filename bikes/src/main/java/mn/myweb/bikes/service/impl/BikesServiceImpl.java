package mn.myweb.bikes.service.impl;

import mn.myweb.bikes.model.Bikes;
import mn.myweb.bikes.repository.BikesRepository;
import mn.myweb.bikes.service.BikesService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BikesServiceImpl implements BikesService {

    private final BikesRepository bikesRepository;

    public BikesServiceImpl(BikesRepository bikesRepository) {
        this.bikesRepository = bikesRepository;
    }

    @Override
    public List<Bikes> getAllBikes() {
        return bikesRepository.findAll();
    }

    @Override
    public Optional<Bikes> getBikeById(Long id) {
        return bikesRepository.findById(id);
    }

    @Override
    public Bikes createBike(Bikes bike) {
        return bikesRepository.save(bike);
    }

    @Override
    public Bikes updateBike(Long id, Bikes updatedBike) {
        return bikesRepository.findById(id)
                .map(bike -> {
                    bike.setBrand(updatedBike.getBrand());
                    bike.setModel(updatedBike.getModel());
                    bike.setPrice(updatedBike.getPrice());
                    bike.setType(updatedBike.getType());
                    bike.setAvailable(updatedBike.isAvailable());
                    return bikesRepository.save(bike);
                })
                .orElseThrow(() -> new RuntimeException("Bike not found with id " + id));
    }

    @Override
    public void deleteBike(Long id) {
        bikesRepository.deleteById(id);
    }
}
