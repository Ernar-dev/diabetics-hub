package kz.codeforensics.diabetics_hub.api;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kz.codeforensics.diabetics_hub.domain.dto.PatientHistoryDto;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Tag(name = "PatientHistory", description = "История пациента")

public interface PatientHistoryApi {

    @Operation(
            operationId = "create",
            summary = "Создать"
    )
    ResponseEntity<PatientHistoryDto> create(@RequestBody PatientHistoryDto patientHistoryDto);

    @Operation(
            operationId = "getAll",
            summary = "Просмотр всех поциентов"
    )
    ResponseEntity<Page<PatientHistoryDto>> getAll(@RequestParam(defaultValue = "0") int page,
                                                   @RequestParam(defaultValue = "10") int size);

    @Operation(
            operationId = "getRegistrationNumber",
            summary = "Просмотр через рег. номер"
    )
    ResponseEntity<PatientHistoryDto> getRegistrationNumber(@PathVariable Long registrationNumber);

    @Operation(
            operationId = "getUserId",
            summary = "Просмотр через профиль"
    )
    ResponseEntity<PatientHistoryDto> getUserId();

    @Operation(
            operationId = "update",
            summary = "Обнавление история поциента"
    )
    ResponseEntity<PatientHistoryDto> update(@RequestBody PatientHistoryDto patientHistoryDto);

    @Operation(
            operationId = "deleteRegistrationNumber",
            summary = "Удалить через рег. номер"
    )
    ResponseEntity<Void> deleteRegistrationNumber(@PathVariable Long registrationNumber);

}
