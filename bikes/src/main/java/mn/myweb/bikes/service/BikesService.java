package mn.myweb.bikes.service;

import mn.myweb.bikes.model.Bikes;

import java.util.List;
import java.util.Optional;

public interface BikesService {

    List<Bikes> getAllBikes();

    Optional<Bikes> getBikeById(Long id);

    Bikes createBike(Bikes bike);

    Bikes updateBike(Long id, Bikes bike);

    void deleteBike(Long id);
}
