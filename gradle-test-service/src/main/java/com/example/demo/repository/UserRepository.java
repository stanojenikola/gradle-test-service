package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByName(String name);

}


/*
version: '3.8'

services:
h2:
image: h2database/h2
container_name: h2
ports:
        - "8082:8082"  # Port for accessing H2 Console
      - "1521:1521"  # Default H2 port
volumes:
        - ./h2-data:/h2-data  # Volume to persist H2 database files

postgres:
image: postgres
container_name: postgres
environment:
POSTGRES_DB: your_database_name
POSTGRES_USER: your_username
POSTGRES_PASSWORD: your_password
ports:
        - "5432:5432"  # Default PostgreSQL port
volumes:
        - ./postgres-data:/var/lib/postgresql/data  # Volume to persist PostgreSQL data
*/
