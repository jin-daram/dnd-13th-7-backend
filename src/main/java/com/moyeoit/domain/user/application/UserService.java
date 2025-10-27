package com.moyeoit.domain.user.application;

import com.moyeoit.domain.app_user.controller.request.ActivateRequest;
import com.moyeoit.domain.app_user.controller.response.ActivateResponse;
import com.moyeoit.domain.app_user.domain.Term;
import com.moyeoit.domain.job.domain.repository.JobRepository;
import com.moyeoit.domain.user.application.dto.UserDto;
import com.moyeoit.domain.user.domain.entity.User;
import com.moyeoit.domain.user.domain.repository.UserRepository;
import com.moyeoit.global.exception.AppException;
import com.moyeoit.global.exception.code.UserErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final JobRepository jobRepository;
    private final TermService termService;

    /**
     * 유저 활성화
     *
     * @param userId 유저 ID
     * @param req    활성 요청 객체
     * @return
     */
    public UserDto activateUser(Long userId, ActivateRequest req) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new AppException(UserErrorCode.NOT_FOUND));

        if (!jobRepository.existsById(req.getJobId()))
            throw new AppException(UserErrorCode.NOT_FOUND_JOB);

        user.activate(req.getNickname(), req.getJobId());
        termService.createTerm(user, req);
        return UserDto.of(user);
    }

    public ActivateResponse getActivateResponse(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new AppException(UserErrorCode.NOT_FOUND));

        if (user.isActive()) {
            Term termOfUser = termService.getTerm(user.getId());

            return ActivateResponse.of(user, termOfUser);
        }

        return ActivateResponse.of(user);
    }

    // TODO : 2025년 10월 27일 23:30 에 위까지 Migration 했음

}
