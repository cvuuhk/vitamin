package cn.cvuuhk.vitamin.dao;

import cn.cvuuhk.vitamin.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {}
