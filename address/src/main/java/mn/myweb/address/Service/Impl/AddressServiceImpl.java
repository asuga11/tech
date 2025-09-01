package mn.myweb.address.Service.Impl;

import mn.myweb.address.model.Address;
import mn.myweb.address.Repository.AddressRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements mn.myweb.address.Service.AddressService {


    @Override
    public Page<Address> getPaged(Pageable pageable) {
        return addressRepository.findAll(pageable);
    }


    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository AddressRepository) {
        this.addressRepository = AddressRepository;
    }

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address findById(Long id) {
        Optional<Address> optional = addressRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public void delete(Long id) {
        addressRepository.deleteById(id);
    }
}
