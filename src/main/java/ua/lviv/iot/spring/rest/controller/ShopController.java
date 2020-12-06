package ua.lviv.iot.spring.rest.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.spring.business.ShopService;
import ua.lviv.iot.spring.rest.model.Shop;

@RestController
@RequestMapping("/shops")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @GetMapping
    public List<Shop> getShops() {
        return shopService.findAll();
    }

    @GetMapping(path = "/{id}")
    public Shop getShop(@PathVariable("id") Integer shopId) {
        return shopService.find(shopId);
    }

    @PostMapping
    public Shop createShop(@RequestBody Shop shop) {
        return shopService.create(shop);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Shop> updateShop(@PathVariable("id") Integer shopId,
            @RequestBody Shop shop) {
        return ResponseEntity.status(shopService.update(shopId, shop)).build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Shop> deleteShop(@PathVariable("id") Integer shopId) {
        return ResponseEntity.status(shopService.delete(shopId)).build();
    }
}
