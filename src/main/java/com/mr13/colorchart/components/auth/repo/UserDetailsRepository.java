package com.mr13.colorchart.components.auth.repo;

import com.mr13.colorchart.components.auth.domain.ColorChartUserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepository extends JpaRepository<ColorChartUserDetails, String> {

}
