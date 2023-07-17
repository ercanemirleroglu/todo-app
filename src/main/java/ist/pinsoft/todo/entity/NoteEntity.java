package ist.pinsoft.todo.entity;

import ist.pinsoft.todo.dto.NoteDto;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "note")
public class NoteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "content")
    private String content;

    @Column(name = "status")
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public NoteDto toDto() {
        NoteDto noteDto = new NoteDto();
        noteDto.setId(id);
        noteDto.setCreatedDate(createdDate);
        noteDto.setContent(content);
        noteDto.setStatus(status);
        return noteDto;
    }
}
