package com.example.test.service;

import com.example.test.model.BaseConnaissance;

import java.util.List;

public interface BaseConnaissanceService {

    BaseConnaissance ajouterBaseConnaissance(BaseConnaissance baseConnaissance);
    String supprimerBaseConnaissance(Long id);
    List<BaseConnaissance> lireBaseConnaissance();

    List<BaseConnaissance> getAllBaseConnaissances();
}
