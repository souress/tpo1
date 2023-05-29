package klmnkki.task3.bot;

import klmnkki.task3.Person;
import klmnkki.task3.enums.Place;
import klmnkki.task3.exception.IllegalStateException;

public interface IBot
{
    String sit(Place where) throws IllegalStateException;

    String getUp(Place from, String how) throws IllegalStateException;

    String comeToPerson(Place from, Place through, Person to) throws IllegalStateException;

    String goTo(Place from, Place through, Place where) throws IllegalStateException;

    String lookAt(Person person, String how);
}
