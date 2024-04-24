package com.example.gift.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.gift.model.Giftmodel;
import com.example.gift.service.GiftServices;

import  java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class GiftController {
    @Autowired
    private GiftServices giftService;

    @PostMapping("/post")
    public String postMethodName(@RequestBody Giftmodel Gift) {
        giftService.saveGift(Gift);
        return "saved";
    }
    @GetMapping("/Gift/{itemNo}")
    public Giftmodel getMethodName(@PathVariable ("itemNo") int a) {
        return giftService.getGift(a);
    }
    @GetMapping("/Gifts")
    public List<Giftmodel> getAllMethodName() {
        return giftService.getAllGift();
    }
    @PutMapping("/Gift/{itemNo}")
    public String putMethodName(@PathVariable int itemNo, @RequestBody Giftmodel UpdatedGift){
          Giftmodel existGift= giftService.getGift(itemNo);
          if(existGift!=null){
            existGift.setItemNo(UpdatedGift.getItemNo());
            existGift.setName(UpdatedGift.getName());
            existGift.setNos(UpdatedGift.getNos());
            existGift.setPrice(UpdatedGift.getPrice());
            giftService.saveGift(existGift);
            return "updated";
          }
          else{
            return "No Data Found";
          }
    }
    @DeleteMapping("/Gift/{itemNo}")
    public String deleteGift(@PathVariable("itemNo") int itemNo)
    {
        Giftmodel existGift = giftService.getGift(itemNo);
        if(existGift != null)
        {
            giftService.deleteGift(itemNo);
            return "Gift deleted";
        }
        return "not found";
    } 
    
}