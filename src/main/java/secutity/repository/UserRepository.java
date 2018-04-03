package secutity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import secutity.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findOneByLoginId(String loginId);
}
