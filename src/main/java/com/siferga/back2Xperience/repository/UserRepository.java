package com.siferga.back2Xperience.repository;


import com.siferga.back2Xperience.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository

public class UserRepository {
    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Map<String, Object>> callSpProjectCollaboratorsByService(int serviceId) {
        String sql = "CALL spRepartition(?)";
        return jdbcTemplate.queryForList(sql, serviceId);
    }
}
