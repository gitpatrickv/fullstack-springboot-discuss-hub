package com.fullstack.discuss_hub.feature.user.repository;

import com.fullstack.discuss_hub.feature.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String username);
    @Query("SELECT u FROM User u WHERE u.email = :name OR u.username = :name")
    Optional<User> findByEmailOrUsername(@Param("name") String name);
    @Modifying
    @Query(nativeQuery = true,
            value = """
                    UPDATE users u
                    SET account_non_locked = :isLocked
                    WHERE u.email = :email
                    """)
    void accountNonLock(@Param("email") String email, @Param("isLocked") boolean isLocked);
    @Modifying
    @Query(nativeQuery = true,
            value = """
                    UPDATE users u
                    SET account_non_locked = true
                    WHERE u.email IN (
                          SELECT la.email
                          FROM login_attempts la
                          WHERE la.is_user_locked = true
                          AND la.expiration_time <= :now
                          )
                    """)
    void unLockUsers(@Param("now") LocalDateTime now);

}
