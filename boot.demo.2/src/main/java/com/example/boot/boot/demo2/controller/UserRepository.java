package com.example.boot.boot.demo2.controller;

import org.springframework.data.repository.CrudRepository;

import com.example.boot.boot.demo2.model.User;

public interface UserRepository extends CrudRepository<User,Integer> {

	

}
