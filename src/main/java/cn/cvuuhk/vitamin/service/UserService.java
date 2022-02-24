package cn.cvuuhk.vitamin.service;

import cn.cvuuhk.vitamin.dao.UserRepository;
import cn.cvuuhk.vitamin.entity.User;
import cn.cvuuhk.vitamin.exception.LoginFailedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class UserService {
  @Resource UserRepository repository;

  @Transactional
  public User getUserById(String userId) {
    return repository.findById(userId).get();
  }

  @Transactional
  public boolean login(String userId, String password) {
    repository
        .findById(userId)
        .ifPresentOrElse(
            (user -> {
              if (!user.getPassword().equals(password)) throw new LoginFailedException("用户名或密码错误");
            }),
            () -> {
              throw new LoginFailedException("用户名或密码错误");
            });
    return true;
  }

  @Transactional
  public void logout(String userId) {}
}
