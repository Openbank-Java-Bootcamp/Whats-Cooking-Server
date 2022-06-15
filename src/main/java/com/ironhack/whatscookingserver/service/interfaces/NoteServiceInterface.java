package com.ironhack.whatscookingserver.service.interfaces;

import com.ironhack.whatscookingserver.DTO.NoteDTO;
import com.ironhack.whatscookingserver.DTO.UpdateNoteDTO;
import com.ironhack.whatscookingserver.models.Note;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface NoteServiceInterface {

    void saveNote(NoteDTO noteDTO);

    List<Note> getNotesByUserId(Long userId);

    //void updateNote(Long id, String newContent);

    void updateNote(Long id, UpdateNoteDTO updateNoteDTO, Authentication authentication);

    void deleteNote(Long id, Authentication authentication);
}
