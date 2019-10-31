package dataaccess;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import models.Note;

public class NoteDB {
    
    public int insert(Note note){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(note);
            trans.commit();
            return 1;
        } catch (Exception e) {
            trans.rollback();
            return 0;
        } finally {
            em.close();
        }
    }
    
    public int update(Note note){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.merge(note);
            trans.commit();
            return 1;
        } catch (Exception e) {
            trans.rollback();
            return 0;
        } finally {
            em.close();
        }
    }
    
    public List<Note> getAll(){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            List<Note> notes = em.createNamedQuery("User.findAll", Note.class).getResultList();
            return notes;
        } finally {
            em.close();
        }
    }
    
    public Note get(int noteId){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            Note note = em.find(Note.class, noteId);
            return note;
        } finally {
            em.close();
        }
    }
    
    public int delete(Note note){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.remove(em.merge(note));
            trans.commit();
            return 1;
        } catch (Exception e) {
            trans.rollback();
            return 0;
        } finally {
            em.close();
        }
    }
}
