package gstudingandroidproject.voicetransplate;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import com.memetix.mst.language.Language;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

/**
 * Created by Admin on 30/03/2016.
 */
public class LanguageAndLocale implements Serializable {
    HashMap<Language, Locale> hashMap1;
    HashMap<Locale, Language> hashMap2;
    ArrayList<Locale> locales;

    public HashMap<Language, Locale> getHashMap1() {
        return hashMap1;
    }

    public HashMap<Locale, Language> getHashMap2() {
        return hashMap2;
    }

    public ArrayList<Locale> getLocales() {
        return locales;
    }

    public void setHashMap(ArrayList<String> arrayList) {
        Log.e("Araylist", " " + arrayList.size());
        hashMap1 = new HashMap<>();
        hashMap2 = new HashMap<>();

        setListLoacle(arrayList);
        Log.e("ListLocale", " " + locales.size());


        // locale tinh chỉnh
        ArrayList<Locale> localeArrayList = new ArrayList<>();


        for (Language language : Language.values()) {
            for (Locale locale : locales) {
                if (language.toString().equalsIgnoreCase(locale.getLanguage())) {

                    hashMap1.put(language, locale);
                    hashMap2.put(locale, language);

                    locales.remove(locale);
                    localeArrayList.add(locale);
                    break;
                }

            }


        }
        locales = localeArrayList;
        Log.e("ListLocale", " " + locales.size());

    }

    public Locale getLocaleVoice(Language language) {
        Locale locale = hashMap1.get(language);
        return locale;
    }

    public Language getLanguage(Locale locale) {
        Language language = hashMap2.get(locale);
        return language;
    }

    public ArrayList<Language> getListLanguageSupportvoice() {
        ArrayList<Language> arrayList = new ArrayList<>();
        Log.e("Locales", "size = " + locales.size());
        for (Locale locale : locales) {
            try {
                Language language = hashMap2.get(locale);
                arrayList.add(language);
            } catch (Exception e) {

            }
        }
        Log.e("arraylist", " " + arrayList.size());
        return arrayList;
    }

    private void setListLoacle(ArrayList<String> arrayList) {
        locales = new ArrayList<>();
        for (String str : arrayList) {
            Log.e("Locale", str);
            String lg;
            if (str.equals("jpn-jpn")) lg = "ja";
            else if (str.equals("zho-chn")) lg = "zh-CHS";
            else if (str.equals("zho-twn")) lg = "zh-CHT";
            else lg = str.substring(0, 2);

            Locale locale = new Locale(lg);
            locales.add(locale);
        }

    }


//    protected LanguageAndLocale(Parcel in) {
//        hashMap1 = (HashMap) in.readValue(HashMap.class.getClassLoader());
//        hashMap2 = (HashMap) in.readValue(HashMap.class.getClassLoader());
//        if (in.readByte() == 0x01) {
//            locales = new ArrayList<Locale>();
//            in.readList(locales, Locale.class.getClassLoader());
//        } else {
//            locales = null;
//        }
//    }
//
//    @Override
//    public int describeContents() {
//        return 0;
//    }
//
//    @Override
//    public void writeToParcel(Parcel dest, int flags) {
//        dest.writeValue(hashMap1);
//        dest.writeValue(hashMap2);
//        if (locales == null) {
//            dest.writeByte((byte) (0x00));
//        } else {
//            dest.writeByte((byte) (0x01));
//            dest.writeList(locales);
//        }
//    }
//
//    @SuppressWarnings("unused")
//    public static final Parcelable.Creator<LanguageAndLocale> CREATOR = new Parcelable.Creator<LanguageAndLocale>() {
//        @Override
//        public LanguageAndLocale createFromParcel(Parcel in) {
//            return new LanguageAndLocale(in);
//        }
//
//        @Override
//        public LanguageAndLocale[] newArray(int size) {
//            return new LanguageAndLocale[size];
//        }
//    };

}
