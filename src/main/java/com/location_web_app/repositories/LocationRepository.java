package com.location_web_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.location_web_app.entities.Location;

public interface LocationRepository extends JpaRepository<Location , Long> {

}
