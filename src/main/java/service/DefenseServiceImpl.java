package service;

import api.DefenseDTO;
import api.DefenseRequest;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import repository.DefenseRepositoryImpl;

@ApplicationScoped
public class DefenseServiceImpl implements DefenseService {
    private DefenseRepositoryImpl defenseRepository;

    public DefenseServiceImpl(DefenseRepositoryImpl defenseRepository) {
        this.defenseRepository = defenseRepository;
    }

    @Override
    @Transactional
    public String createDefense(DefenseRequest defenseRequest) {
        return defenseRepository.createDefense(defenseRequest);
    }

    @Override
    @Transactional
    public DefenseDTO updateDefense(String defenseId, DefenseRequest defenseRequest) {
    return defenseRepository.updateDefense(defenseId, defenseRequest);
    }

    @Override
    @Transactional
    public boolean deleteDefense(String defenseId) {
        return defenseRepository.deleteDefenseByDefenseId(defenseId);
    }
}