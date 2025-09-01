package mn.myweb.address.Controller;

import mn.myweb.address.model.Address;
import mn.myweb.address.Service.AddressService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
@CrossOrigin
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    // 🔹 Бүх хаягуудыг авах
    @GetMapping
    public List<Address> getAll() {
        return addressService.findAll();
    }

    // 🔹 ID-р хайх
    @GetMapping("/{id}")
    public Address getById(@PathVariable Long id) {
        return addressService.findById(id);
    }

    // 🔹 Хаяг шинээр нэмэх
    @PostMapping
    public Address create(@RequestBody Address address) {
        return addressService.save(address);
    }

    // 🔹 Хаяг засах
    @PutMapping("/{id}")
    public Address update(@PathVariable Long id, @RequestBody Address address) {
        Address existing = addressService.findById(id);
        if (existing == null) return null;
        address.setId(id);
        return addressService.save(address);
    }

    // 🔹 Хаяг устгах
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        addressService.delete(id);
    }

    // ✅ ШИНЭ: Хуудаслаж авах API
    @GetMapping("/paged")
    public Page<Address> getPagedAddresses(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());
        return addressService.getPaged(pageable);
    }
}
