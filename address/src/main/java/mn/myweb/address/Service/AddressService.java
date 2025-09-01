package mn.myweb.address.Service;

import mn.myweb.address.model.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AddressService {
    Page<Address> getPaged(Pageable pageable);

    List<Address> findAll();
    Address findById(Long id);
    Address save(Address address);
    void delete(Long id);
}
