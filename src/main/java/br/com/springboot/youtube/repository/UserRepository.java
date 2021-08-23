package br.com.springboot.youtube.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.springboot.youtube.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
//	@Query("SELECT u FROM user WHERE u.id > :id")
//	public List<User> findAllMoreThan(@Param("id") Long id);
	
	public List<User> findByIdGreaterThan(Long id);
	public List<User> findByName(String name);
	public List<User> findByNameIgnoreCase(String name);
}
