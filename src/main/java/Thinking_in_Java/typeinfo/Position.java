package Thinking_in_Java.typeinfo;

/**
 * @author dreamyao
 *         Created by dreamyao on 16-9-21.
 *         P342
 */
public class Position {
    private String title;
    private Person person;

    public Position(String jobTitle,Person employee) {
        title = jobTitle;
        person = employee;
        if (person == null) {
            person = Person.NULL;
        }
    }

    public Position(String jobTitle) {
        title = jobTitle;
        this.person = Person.NULL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String newTitle) {
        title = newTitle;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person newPerson) {
        person = newPerson;
        if (person == null) {
            person = Person.NULL;
        }
    }

    public String toString() {
        return "Person: " + title + " " + person;
    }
}
