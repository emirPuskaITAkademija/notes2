package com.academy.it.notes2.entity.repository;

import com.academy.it.notes2.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteJpaRepository extends JpaRepository<Note, Integer>{
    //GRATIS smo dobili mnogo toga
}
