package com.klicws.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klicws.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
