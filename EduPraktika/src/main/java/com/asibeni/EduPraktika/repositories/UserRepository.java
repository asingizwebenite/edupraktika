package com.asibeni.EduPraktika.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.asibeni.EduPraktika.model.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT u FROM User u WHERE u.firstName = :firstName AND u.lastName = :lastName")
    List<User> findByFullName(@Param("firstName") String firstName, @Param("lastName") String lastName);

    @Query("SELECT u FROM User u WHERE u.email = :email")
    User findByEmail(@Param("email") String email);

    @Query("SELECT u FROM User u WHERE u.phone = :phone")
    User findByPhone(@Param("phone") String phone);

    @Query("SELECT u FROM User u WHERE u.id = :id")
    User findByIdCustom(@Param("id") Integer id);

    @Query(value = "SELECT * FROM User u WHERE u.email LIKE %:email%", nativeQuery = true)
    List<User> findByEmailContains(@Param("email") String email);

    @Query(value = "SELECT * FROM User u WHERE u.first_name LIKE :firstNamePrefix%", nativeQuery = true)
    List<User> findByFirstNameStartsWith(@Param("firstNamePrefix") String firstNamePrefix);

    @Query(value = "SELECT COUNT(*) FROM User u WHERE u.phone = :phone", nativeQuery = true)
    boolean existsByPhoneNative(@Param("phone") String phone);

    @Query("SELECT u FROM User u WHERE u.firstName = :firstName OR u.lastName = :lastName")
    List<User> findByNameOrLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);

    Optional<User> findByUsername(String username);

}