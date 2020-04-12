package ua.lviv.iot.spring.business;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ua.lviv.iot.spring.dataaccess.ShopRepository;
import ua.lviv.iot.spring.rest.model.Shop;

@Service
public class ShopService {

    @Autowired
    private ShopRepository shopRepository;

    public Shop create(Shop shop) {
        return shopRepository.save(shop);
    }

    public List<Shop> findAll() {
        return shopRepository.findAll();
    }

    public Shop find(Integer shopId) {
        return shopRepository.findById(shopId).get();
    }

    public HttpStatus update(Integer shopId, Shop shop) {
        HttpStatus status;
        shop.setId(shopId);
        if (shopRepository.existsById(shopId)) {
            status = HttpStatus.CREATED;
            shopRepository.save(shop);
        } else {
            status = HttpStatus.NOT_FOUND;
        }
        return status;
    }

    public HttpStatus delete(Integer shopId) {
        HttpStatus status = shopRepository.existsById(shopId) ? HttpStatus.OK
                : HttpStatus.NOT_FOUND;
        shopRepository.deleteById(shopId);
        return status;

    }
}
