package com.goormTable.login.repository;

import com.goormTable.login.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login,Long> {
    public Login findByAdminIdAndPasswordAndAdminYn(String adminId,String password,String yn);

}
