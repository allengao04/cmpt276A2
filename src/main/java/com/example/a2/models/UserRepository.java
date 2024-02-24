package com.example.a2.models;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Integer>{
    User findByUid(int uid);
    List<User> findByName(String name);
    List<User> findByGpa(double gpa);
    List<User> findByHeightAndWeight(int height,int weight);
    List<User> findByHaircolour(String haircolour);
    List<User> findByOrderByUidAsc();
}

