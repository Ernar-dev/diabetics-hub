package kz.codeforensics.diabetics_hub.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kz.codeforensics.diabetics_hub.domain.dto.PatientDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Patient", description = "Пациент")

public interface PatientApi {

    @Operation(
            operationId = "create",
            summary = "Создать"
    )
    ResponseEntity<PatientDto> create(@RequestBody PatientDto patientDto);

    @Operation(
            operationId = "get",
            summary = "Просмотр"
    )
    ResponseEntity<PatientDto> get();

}
