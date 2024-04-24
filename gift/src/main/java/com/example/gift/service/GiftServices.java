package com.example.gift.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gift.model.Giftmodel;
import com.example.gift.repository.GiftRepository;

@Service
public class GiftServices {
    @Autowired
    private GiftRepository giftRepository;

    public Giftmodel saveGift(Giftmodel Gift)
    {
        return giftRepository.save(Gift);
    }
    public Giftmodel getGift(int itemNo)
    {
        return giftRepository.findById(itemNo).orElse(null);
    }
    public List<Giftmodel> getAllGift()
    {
        return giftRepository.findAll();
    }
    public void deleteGift(int id)
    {
        giftRepository.deleteById(id);
    }
}