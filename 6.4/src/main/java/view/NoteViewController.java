package view;

import controller.NoteController;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class NoteViewController {
    @FXML
    private TextField titleField;
    @FXML
    private TextArea contentArea;
    @FXML
    private TextArea notesDisplay;

    private NoteController noteController;

    public void initialize() {
        noteController = new NoteController();
    }

    @FXML
    private void handleAddNote() {
        String title = titleField.getText();
        String content = contentArea.getText();
        noteController.addNote(title, content);

        notesDisplay.setText(noteController.getAllNotes());
        titleField.clear();
        contentArea.clear();
    }
}