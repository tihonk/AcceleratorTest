package com.example.accelerator.repository;

import com.example.accelerator.domain.Text;
import org.springframework.data.repository.CrudRepository;

public interface TextRepository extends CrudRepository<Text, Long> {
}
