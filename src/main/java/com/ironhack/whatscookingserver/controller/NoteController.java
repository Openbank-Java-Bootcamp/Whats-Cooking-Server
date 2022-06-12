package com.ironhack.whatscookingserver.controller;

import com.ironhack.whatscookingserver.DTO.NoteDTO;
import com.ironhack.whatscookingserver.models.Note;
import com.ironhack.whatscookingserver.service.interfaces.NoteServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class NoteController {

    @Autowired
    NoteServiceInterface noteService;


    @PostMapping("/notes")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveNote(@RequestBody @Valid NoteDTO noteDTO) {
        noteService.saveNote(noteDTO);
    }

    @GetMapping("/user-notes/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Note> getNotesByUserId(@PathVariable Long userId) {
        return noteService.getNotesByUserId(userId);
    }

    @PatchMapping("/notes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateNote(@PathVariable Long id, @RequestParam String content) {
        noteService.updateNote(id, content);
    }

    @DeleteMapping("/notes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
    }
}
