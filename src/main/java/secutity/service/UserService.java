package secutity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import secutity.domain.User;
import secutity.repository.UserRepository;
import secutity.utils.Encryption;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	public User login(String loginId, String password) {
		User user = userRepository.findOneByLoginId(loginId);
		if (user == null)
			return null;
		String pw = Encryption.encrypt(password, Encryption.MD5);
		if (user.getPassword().equals(pw) == false)
			return null;
		return user;
	}
}
