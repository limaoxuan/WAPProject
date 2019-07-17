package model;

public class BookBeanHelp {
    private String id;
    private int number;

    public BookBeanHelp(String id, int number) {
        this.id = id;
        this.number = number;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "BookBeanHelp{" +
                "id='" + id + '\'' +
                ", number=" + number +
                '}';
    }
}
