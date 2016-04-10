package com.ericpol.lab.java.examples.threads.comm;

/**
 * Created by xdzm on 2016-02-17.
 */
public class WaitNotify {

    public static void main(String[] args) {
        Chat c = new Chat();
        String[] questions = {"Hi", "How are you?", "Fine too."};
        String[] answers = {"Hi", "Fine. You?", "Great!"};
        Thread q = new Thread(new ConversationPart(c, true, questions), "questions");
        Thread a = new Thread(new ConversationPart(c, false, answers), "answers");
        a.start();
        q.start();

    }

}
