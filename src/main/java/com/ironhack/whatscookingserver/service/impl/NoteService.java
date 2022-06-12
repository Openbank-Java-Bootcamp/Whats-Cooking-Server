package com.ironhack.whatscookingserver.service.impl;

import com.ironhack.whatscookingserver.DTO.NoteDTO;
import com.ironhack.whatscookingserver.models.Note;
import com.ironhack.whatscookingserver.models.Recipe;
import com.ironhack.whatscookingserver.models.User;
import com.ironhack.whatscookingserver.repository.NoteRepository;
import com.ironhack.whatscookingserver.repository.RecipeRepository;
import com.ironhack.whatscookingserver.repository.UserRepository;
import com.ironhack.whatscookingserver.service.interfaces.NoteServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        User author = userRepository.findById(noteDTO.getUserId()).get();
        //Recipe recipe = recipeRepository.findById(noteDTO.getRecipeId()).get();
        Note note = new Note(author, noteDTO.getRecipeId(), noteDTO.getContent());
        noteRepository.save(note);
    }

    public List<Note> getNotesByUserId(Long userId) {
        return noteRepository.findByUserId(userId);
    }

    public void updateNote(Long id, String newContent) {
        Note noteFromDb = noteRepository.findById(id).get();
        noteFromDb.setContent(newContent);
        noteRepository.save(noteFromDb);
    }

    public void deleteNote(Long id) {
        Note noteFromDb = noteRepository.findById(id).get();
        noteRepository.delete(noteFromDb);
    }
}
