package seedu.address.logic;

import java.nio.file.Path;

import javafx.beans.property.ReadOnlyProperty;
import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.ReadOnlyContactList;
import seedu.address.model.ReadOnlyTaskList;
import seedu.address.model.ReadOnlyWorkoutBook;
import seedu.address.model.ReadOnlyExpenditureList;
import seedu.address.model.ReadOnlyHabitTrackerList;
import seedu.address.model.habit.Habit;
import seedu.address.model.person.Person;
import seedu.address.model.purchase.Purchase;
import seedu.address.model.task.Task;
import seedu.address.model.workout.Workout;

/**
 * API of the Logic component
 */
public interface Logic {
    /**
     * Executes the command and returns the result.
     * @param commandText The command as entered by the user.
     * @return the result of the command execution.
     * @throws CommandException If an error occurs during command execution.
     * @throws ParseException If an error occurs during parsing.
     */
    CommandResult execute(String commandText) throws CommandException, ParseException;

    /**
     * Returns the ContactList.
     *
     * @see seedu.address.model.Model#getContactList()
     */
    ReadOnlyContactList getContactList();

    ReadOnlyTaskList getTaskList();

    ReadOnlyTaskList getTickedTaskList();

    ObservableList<Task> getFilteredTaskList();

    ObservableList<Task> getFilteredTickedTaskList();

    /** Returns an unmodifiable view of the filtered list of persons */
    ObservableList<Person> getFilteredPersonList();

    ObservableList<Workout> getFilteredWorkoutList();
    /**
     * Returns an unmodifiable view of the list of commands entered by the user.
     * The list is ordered from the least recent command to the most recent command.
     */
    ObservableList<String> getHistory();

    /**
     * Returns the user prefs' contact list file path.
     */
    Path getContactListFilePath();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Set the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    /**
     * Selected person in the filtered person list.
     * null if no person is selected.
     *
     * @see seedu.address.model.Model#selectedPersonProperty()
     */
    ReadOnlyProperty<Person> selectedPersonProperty();

    /**
     * Sets the selected person in the filtered person list.
     *
     * @see seedu.address.model.Model#setSelectedPerson(Person)
     */
    void setSelectedPerson(Person person);

    /**
     * Selected task in the filtered task list
     * @return null if no person is selected.
     */
    ReadOnlyProperty<Task> selectedTaskProperty();

    /**
     * Sets the selected task in the filtered task list.
     *
     */
    void setSelectedTask(Task task);



    /**
     * Returns the ExpenditureList.
     *
     * @see seedu.address.model.Model#getExpenditureList()
     */
    ReadOnlyExpenditureList getExpenditureList();

    /** Returns an unmodifiable view of the filtered list of purchases */
    ObservableList<Purchase> getFilteredPurchaseList();

    /**
     * Selected purchase in the filtered purchase list.
     * null if no purchase is selected.
     *
     * @see seedu.address.model.Model#selectedPurchaseProperty()
     */
    ReadOnlyProperty<Purchase> selectedPurchaseProperty();

    /**
     * Sets the selected person in the filtered purchase list.
     *
     * @see seedu.address.model.Model#setSelectedPurchase(Purchase)
     */
    void setSelectedPurchase(Purchase purchase);

    /**
     * Returns the user prefs' contact list file path.
     */
    Path getExpenditureListFilePath();

    ReadOnlyProperty<Workout> selectedWorkoutProperty();

    void setSelectedWorkout(Workout workout);

    ReadOnlyWorkoutBook getWorkoutList();

    ReadOnlyProperty<Habit> selectedHabitProperty();

    void setSelectedHabit(Habit habit);

    ReadOnlyHabitTrackerList getHabitTrackerList();

    ObservableList<Habit> getFilteredHabitList();





}
