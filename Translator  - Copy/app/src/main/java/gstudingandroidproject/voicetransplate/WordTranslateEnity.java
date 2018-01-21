package gstudingandroidproject.voicetransplate;

import com.memetix.mst.language.Language;

/**
 * Created by Admin on 29/04/2016.
 */
public class WordTranslateEnity {
    private int id;
    private String language;
    private String text;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
