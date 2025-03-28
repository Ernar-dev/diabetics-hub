package kz.codeforensics.diabetics_hub.service;

import kz.codeforensics.diabetics_hub.domain.dto.GlucoseMonitoringDto;
import kz.codeforensics.diabetics_hub.domain.dto.MeasurementDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MeasurementService {

    MeasurementDto create(MeasurementDto measurementDto);

    Page<MeasurementDto> getAll(Pageable pageable, String iin);

    Page<GlucoseMonitoringDto> getGlucoseMonitoring(Pageable pageable, String iin);
}
