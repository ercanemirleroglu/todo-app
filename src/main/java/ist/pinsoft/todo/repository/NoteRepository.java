package ist.pinsoft.todo.repository;

import ist.pinsoft.todo.entity.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<NoteEntity, Long> {
}
