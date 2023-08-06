package com.poly.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.poly.models.Users;

public interface UsersRepository extends JpaRepository<Users, String> {
    // Các phương thức CRUD sẽ được tự động triển khai bởi Spring Data JPA.
    
    // Tìm kiếm người dùng bằng email
    Users findByEmail(String email);

    // Tìm kiếm người dùng theo tên đầy đủ
    List<Users> findByFullname(String fullname);

    // Tìm kiếm người dùng theo email hoặc tên đầy đủ
    List<Users> findByEmailOrFullname(String email, String fullname);

    // Truy vấn tùy chỉnh sử dụng @Query
    @Query("SELECT u FROM Users u WHERE u.email = :email")
    Users findUserByEmail(@Param("email") String email);

    // Truy vấn tùy chỉnh sử dụng @Query và native SQL
    @Query(value = "SELECT * FROM users u WHERE u.full_name LIKE %:name%", nativeQuery = true)
    List<Users> findUsersByFullNameContaining(@Param("name") String name);

    // Xóa người dùng bằng email
    void deleteByEmail(String email);
}
