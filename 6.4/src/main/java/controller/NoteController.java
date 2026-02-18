package controller;

import Model.Note;
import Model.Notebook;

public class NoteController {
    private final Notebook notebook = new Notebook();

    public void addNote(String title, String content) {
        if (title != null && !title.isEmpty() && content != null && !content.isEmpty()) {
            Note note = new Note(title, content);
            notebook.addNote(note);
        }
    }

    public String getAllNotes() {
        StringBuilder allNotes = new StringBuilder();
        for (Note note : notebook.getNotes()) {
            allNotes.append(note.toString()).append("\n");
        }
        return allNotes.toString();
    }
}