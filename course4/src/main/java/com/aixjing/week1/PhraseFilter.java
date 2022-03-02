package com.aixjing.week1;

public class PhraseFilter implements Filter {
    private final String where;
    private final String phrase;

    public PhraseFilter(String where, String phrase) {
        this.where = where;
        this.phrase = phrase;
    }

    @Override
    public boolean satisfies(QuakeEntry qe) {
        switch (where) {
            case "start": return qe.getInfo().startsWith(phrase);
            case "end": return qe.getInfo().endsWith(phrase);
            default: return qe.getInfo().contains(phrase);
        }
    }

    @Override
    public String getName() {
        return "Phrase";
    }
}
