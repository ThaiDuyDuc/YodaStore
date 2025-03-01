package com.yoda.yodatore.repository;

import com.yoda.yodatore.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);

    @Query("""
            SELECT CASE WHEN COUNT(e) > 0 THEN true ELSE false END FROM Role e WHERE e.id = :id AND e.deleted = false
            """)
    Boolean checkSoftDelete(@Param("id") Long id);
}