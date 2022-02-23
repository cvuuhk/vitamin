package cn.cvuuhk.vitamin.dao;

import cn.cvuuhk.vitamin.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {}
