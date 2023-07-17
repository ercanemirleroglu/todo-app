package ist.pinsoft.todo.service;

import ist.pinsoft.todo.dto.NoteDto;
import ist.pinsoft.todo.entity.NoteEntity;
import ist.pinsoft.todo.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<NoteDto> getAllNotes() {
        return noteRepository.findAll().stream().map(NoteEntity::toDto)
                .collect(Collectors.toList());
    }

    public NoteDto getNoteById(Long id) {
        return noteRepository.findById(id).map(NoteEntity::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Note could not be found. NoteId: " + id));
    }

    public void createNote(NoteDto noteDto) {
        NoteEntity noteEntity = new NoteEntity();
        noteEntity.setContent(noteDto.getContent());
        noteEntity.setCreatedDate(LocalDateTime.now());
        noteEntity.setStatus("TODO");
        noteRepository.save(noteEntity);
    }

    public void completeNote(Long id) {
        NoteEntity noteEntity = noteRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Note could not be found. NoteId: " + id));
        noteEntity.setStatus("DONE");
        noteRepository.save(noteEntity);
    }

    public void deleteNote(Long id) {
        NoteEntity noteEntity = noteRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Note could not be found. NoteId: " + id));
        noteRepository.delete(noteEntity);
    }

    public void updateNote(Long id, NoteDto noteDto) {
        NoteEntity noteEntity = noteRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Note could not be found. NoteId: " + id));
        noteEntity.setContent(noteDto.getContent());
        noteRepository.save(noteEntity);
    }
}
