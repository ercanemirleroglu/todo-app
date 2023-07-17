package ist.pinsoft.todo.controller;

import ist.pinsoft.todo.dto.NoteDto;
import ist.pinsoft.todo.service.NoteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notes")
public class NoteController {
    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping
    public ResponseEntity<List<NoteDto>> listNotes() {
        return ResponseEntity.ok().body(noteService.getAllNotes());
    }

    @GetMapping("/{noteId}")
    public ResponseEntity<NoteDto> getNote(@PathVariable("noteId") Long noteId) {
        return ResponseEntity.ok().body(noteService.getNoteById(noteId));
    }

    @PostMapping
    public ResponseEntity<Void> createNote(@RequestBody NoteDto noteDto) {
        noteService.createNote(noteDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{noteId}/done")
    public ResponseEntity<Void> completeNote(@PathVariable("noteId") Long noteId) {
        noteService.completeNote(noteId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{noteId}")
    public ResponseEntity<Void> updateNote(@PathVariable("noteId") Long noteId,
                                           @RequestBody NoteDto noteDto) {
        noteService.updateNote(noteId, noteDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{noteId}")
    public ResponseEntity<Void> deleteNote(@PathVariable("noteId") Long noteId) {
        noteService.deleteNote(noteId);
        return ResponseEntity.ok().build();
    }
}
