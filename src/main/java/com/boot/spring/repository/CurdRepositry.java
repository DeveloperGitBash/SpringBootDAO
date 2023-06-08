package com.boot.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.spring.beans.Department;

public interface CurdRepositry extends JpaRepository<Department, Long>{

}
