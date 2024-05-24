package com.siferga.back2Xperience.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.siferga.back2Xperience.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<Map<String, Object>> callSpProjectCollaboratorsByService(int serviceId) {
        //La méthode renvoie une liste de maps.
        return userRepository.callSpProjectCollaboratorsByService(serviceId);
    }

    //méthode qui convertit une liste de maps en une chaîne JSON utilisant ObjectMapper de Jackson.
    // Chaque map dans la liste représente une ligne de données, où les clés sont les noms de colonnes et les valeurs sont les valeurs de colonnes.
    public static String convertListMapToJson(List<Map<String, Object>> list) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(list);
        } catch (Exception e) {
            // Si la conversion échoue, elle imprime la trace de la pile et renvoie null.
            e.printStackTrace();
            return null;
        }
    }
}
