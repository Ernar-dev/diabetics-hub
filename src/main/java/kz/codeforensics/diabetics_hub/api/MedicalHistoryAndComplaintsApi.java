package kz.codeforensics.diabetics_hub.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kz.codeforensics.diabetics_hub.domain.dto.MedicalHistoryAndComplaintsDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "MedicalHistoryAndComplaints", description = "История болезни и жалобы")

public interface MedicalHistoryAndComplaintsApi {

    @Operation(
            operationId = "create",
            summary = "Создать анализ"
    )
    ResponseEntity<MedicalHistoryAndComplaintsDto> create(@RequestBody MedicalHistoryAndComplaintsDto dto);

}
