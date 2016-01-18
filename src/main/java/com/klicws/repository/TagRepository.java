package com.klicws.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klicws.model.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {

}
