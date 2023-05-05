package service;

import api.DefenseDTO;
import api.DefenseRequest;

public interface DefenseService {
    String createDefense(DefenseRequest defenseRequest);
    DefenseDTO updateDefense(String defenseId, DefenseRequest defenseRequest);
    boolean deleteDefense(String defenseId);
}
