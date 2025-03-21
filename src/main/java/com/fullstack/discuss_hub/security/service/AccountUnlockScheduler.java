package com.fullstack.discuss_hub.security.service;

import com.fullstack.discuss_hub.security.repository.LoginAttemptRepository;
import com.fullstack.discuss_hub.feature.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Slf4j
@Component
@RequiredArgsConstructor
public class AccountUnlockScheduler {

    private final LoginAttemptRepository loginAttemptRepository;
    private final UserRepository userRepository;

    @Scheduled(cron = "0 */1 * * * *") //every 5min
    @Transactional
    public void unlockAccounts() {
        try {
            log.info("AccountUnlockScheduler: Starting scheduled task");
            LocalDateTime now = LocalDateTime.now();
            userRepository.unLockUsers(now);
            loginAttemptRepository.resetLoginAttempts(now);
            log.info("AccountUnlockScheduler: Finished scheduled task");
        } catch (Exception e) {
            log.error("AccountUnlockScheduler: Error while unlocking accounts", e);
        }

    }

}
