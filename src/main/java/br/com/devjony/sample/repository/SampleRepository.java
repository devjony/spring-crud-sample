package br.com.devjony.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.devjony.sample.domain.SampleDomain;

@Repository
public interface SampleRepository extends JpaRepository<SampleDomain, Integer> {
}
