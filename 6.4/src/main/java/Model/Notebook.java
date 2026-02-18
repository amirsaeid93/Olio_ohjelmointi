package Model;

import Model.Note;

import java.util.ArrayList;
import java.util.List;

public class Notebook {
    private final List<Note> notes;

    public Notebook() {
        this.notes = new ArrayList<>();
    }

    public void addNote(Note note) {
        notes.add(note);
    }

    public List<Note> getNotes() {
        return notes;
    }
}