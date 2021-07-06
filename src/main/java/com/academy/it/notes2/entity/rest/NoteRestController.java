package com.academy.it.notes2.entity.rest;

import com.academy.it.notes2.entity.Note;
import com.academy.it.notes2.entity.repository.NoteJpaRepository;
import com.academy.it.notes2.exception.ResourceNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//   localhost:8080/api
@RestController
@RequestMapping("/api")
public class NoteRestController {

    @Autowired
    private NoteJpaRepository noteJpaRepository;

    @GetMapping("/notes/all")
    public List<Note> getAllNotes() {
        return noteJpaRepository.findAll();
    }

    @GetMapping("/notes/{noteId}")
    public Note findNoteById(@PathVariable(value = "noteId") Integer id) {
        /* Optional<Note> note = noteJpaRepository.findById(id);
        if (note.isPresent()) {
            return note.get();
        } else {
            throw new ResourceNotFoundException("Note", "noteId", id);
        }*/
        return noteJpaRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("note", "noteId", id));
    }

    @PutMapping("/notes/{noteId}")
    public Note updateNote(@PathVariable(value = "noteId") Integer id, @Validated @RequestBody Note updatedNote) {
        Note note = noteJpaRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("note", "noteId", id));
        note.setContent(updatedNote.getContent());
        note.setTitle(updatedNote.getTitle());
        return noteJpaRepository.save(note);
    }

    @PostMapping("/add")
    public Note createNote(@Validated @RequestBody Note newNote) {
        return noteJpaRepository.save(newNote);
    }

    @DeleteMapping("/notes/{noteId}")
    public ResponseEntity deleteNote(@PathVariable(value = "noteId") Integer id) {
        Note note = noteJpaRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("note", "noteId", id));
        noteJpaRepository.delete(note);
        return ResponseEntity.ok().build();
    }
}
