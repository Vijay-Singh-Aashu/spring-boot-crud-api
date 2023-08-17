package com.excellence.springbootcrudapisecurity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excellence.springbootcrudapisecurity.models.ImageData;

public interface StorageRepository extends JpaRepository<ImageData, Long> {
	Optional<ImageData> findByName(String fileName);
}
