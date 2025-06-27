package org.example.toyproject.Repository;

import org.example.toyproject.Entity.LocationReport;
import org.example.toyproject.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationReportRepository extends JpaRepository<LocationReport, Long> {
    List<LocationReport> findAllByUser(User user);
}
