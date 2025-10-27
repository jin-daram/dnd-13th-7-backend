package com.moyeoit.domain.job.presentation;

import com.moyeoit.domain.job.application.dto.JobsDto;
import com.moyeoit.global.response.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;

public interface JobAPI {

    @Operation(summary = "직군 조회 API", description = "서버에 등록된 전체 직군을 조회합니다.")
    ResponseEntity<ApiResponse<JobsDto>> getJobs();

}
