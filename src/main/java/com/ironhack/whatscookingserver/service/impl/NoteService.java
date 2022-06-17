package com.ironhack.whatscookingserver.service.impl;

import com.ironhack.whatscookingserver.DTO.NoteDTO;
import com.ironhack.whatscookingserver.DTO.UpdateNoteDTO;
import com.ironhack.whatscookingserver.models.Cookbook;
import com.ironhack.whatscookingserver.models.Note;
import com.ironhack.whatscookingserver.models.Recipe;
import com.ironhack.whatscookingserver.models.User;
import com.ironhack.whatscookingserver.repository.NoteRepository;
import com.ironhack.whatscookingserver.repository.RecipeRepository;
import com.ironhack.whatscookingserver.repository.UserRepository;
import com.ironhack.whatscookingserver.service.interfaces.NoteServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Slf4j
public class NoteService implements NoteServiceInterface {

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RecipeRepository recipeRepository;

    public void saveNote(NoteDTO noteDTO) {
        //create new Note object
        log.info("Saving a new note to the database");
        Recipe recipe = recipeRepository.findById(noteDTO.getRecipeId()).get();
        Note note = new Note(noteDTO.getUserId(), recipe, noteDTO.getContent());
        noteRepository.save(note);
    }

    public List<Note> getNotesByUserId(Long userId) {
        return noteRepository.findByUserId(userId);
    }

    public void updateNote(Long id, UpdateNoteDTO updateNoteDTO, Authentication authentication) {
        //verify that user is the note owner
        String email = (String) authentication.getPrincipal();
        User userFromDb = userRepository.findByEmail(email);
        Note noteFromDb = noteRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Note not found"));

        if (userFromDb.getId() != noteFromDb.getUserId()) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "User not authorized for this request.");
        } else {
            noteFromDb.setContent(updateNoteDTO.getContent());
            noteRepository.save(noteFromDb);
        }
    }

    public void deleteNote(Long id, Authentication authentication) {
        //verify that user is the note owner
        String email = (String) authentication.getPrincipal();
        User userFromDb = userRepository.findByEmail(email);
        Note noteFromDb = noteRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Note not found"));

        if (userFromDb.getId() != noteFromDb.getUserId()) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "User not authorized for this request.");
        } else {
            noteRepository.delete(noteFromDb);
        }
    }
}
