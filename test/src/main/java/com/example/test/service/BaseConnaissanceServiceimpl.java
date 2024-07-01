package com.example.test.service;

import com.example.test.model.BaseConnaissance;
import com.example.test.repository.BaseConnaissanceRepository;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter
@Service
@AllArgsConstructor
public class BaseConnaissanceServiceimpl implements BaseConnaissanceService{

    private final BaseConnaissanceRepository BaseConnaissanceRepository;

    @Override
    public BaseConnaissance ajouterBaseConnaissance(BaseConnaissance baseConnaissance) {
        return BaseConnaissanceRepository.save(baseConnaissance);
    }

    @Override
    public String supprimerBaseConnaissance(Long id) {
         BaseConnaissanceRepository.deleteById(id);
         return "BASE DE CONNAISSANCE SUPPRIME";
    }

    @Override
    public List<BaseConnaissance> lireBaseConnaissance() {
        return BaseConnaissanceRepository.findAll();
    }

    /**
     * @return
     */
    @Override
    public List<BaseConnaissance> getAllBaseConnaissances() {
        return List.of();
    }
}
