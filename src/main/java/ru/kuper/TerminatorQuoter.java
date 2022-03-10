package ru.kuper;

/**
 * @author Ilya V. Kupriyanov
 * @version 10.03.2022
 */
public class TerminatorQuoter implements Quoter {
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public void sayQuote() {
        System.out.println(message);
    }

}
