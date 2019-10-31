package services;

import dataaccess.NoteDB;
import java.util.List;
import models.Note;
import java.util.Date;

public class NoteService {
    
    public Note get(int noteId){
        NoteDB db = new NoteDB();
        return db.get(noteId);
    }
    
    public List<Note> getAll(){
        NoteDB db = new NoteDB();
        return db.getAll();
    }
    
    public int update(int noteId, String title, String contents){
        NoteDB db = new NoteDB();
        Note note = db.get(noteId);
        note.setTitle(title);
        note.setContents(contents);
        return db.update(note);
    }
    
    public int delete(int noteId){
        NoteDB db = new NoteDB();
        return db.delete(db.get(noteId));
    }
    
    public int insert(String contents, String title){
        NoteDB db = new NoteDB();
        Date datecreated = new Date();
        Note note = new Note(0, datecreated, title, contents);
        return db.insert(note);
    }
}
