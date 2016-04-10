package com.ericpol.lab.java.examples.threads.comm;

/**
 * Created by xdzm on 2016-02-17.
 */
public class ConversationPart implements Runnable {
    boolean question = true;
    String[] parts;
    Chat c;

    public ConversationPart(Chat c, boolean question, String[] parts) {
        this.question = question;
        this.parts = parts;
        this.c = c;
    }

    public void run() {
        for(String part : parts){
            if(question) c.question(part); else c.answer(part);
        }
    }
}
