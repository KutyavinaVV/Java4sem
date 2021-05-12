package ru.kpfu.itis.kutyavina.styleweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import ru.kpfu.itis.kutyavina.styleweb.dto.CapsuleDto;
import ru.kpfu.itis.kutyavina.styleweb.dto.ProductDto;
import ru.kpfu.itis.kutyavina.styleweb.servise.CapsuleService;
import ru.kpfu.itis.kutyavina.styleweb.servise.ProductService;

import java.util.List;

@RestController
public class CapsuleRestController {

    @Autowired
    CapsuleService capsuleService;

    @Autowired
    ProductService productService;

    @GetMapping("/capsule/get/{id}")
    public CapsuleDto getCapsule(@PathVariable Long id) {
        return CapsuleDto.from(capsuleService.getCapsule(id));
    }

    @GetMapping("/capsules/{userid}")
    public List<CapsuleDto> getAllCapsules(@PathVariable Long userid) {
        return CapsuleDto.from(capsuleService.getCapsules(userid));
    }
    @PutMapping("/capsule")
    public CapsuleDto addCapsule(@RequestBody CapsuleDto capsule) {
        return CapsuleDto.from(capsuleService.createCapsule(capsule));
    }

    @DeleteMapping("/capsule/{id}")
    public ResponseEntity deleteCapsule(@PathVariable Long id) {
        capsuleService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/capsule")
    public CapsuleDto updateIdol(@RequestBody CapsuleDto capsule) {
        return CapsuleDto.from(capsuleService.updateCapsule(capsule));
    }

    @PutMapping("capsules/{capsule-id}/product")
    public CapsuleDto addProduct(@PathVariable("capsule-id") Long capsuleId, @RequestBody ProductDto productDto) {
        productService.addProductInList(capsuleId, productDto.getId());
        return CapsuleDto.from(capsuleService.getCapsule(capsuleId));
    }

    @DeleteMapping("capsules/{capsule-id}/product")
    public CapsuleDto deleteProduct(@PathVariable("capsule-id") Long capsuleId, @RequestBody ProductDto productDto) {
        productService.removeProductFromList(capsuleId, productDto.getId());
        return CapsuleDto.from(capsuleService.getCapsule(capsuleId));
    }


}
