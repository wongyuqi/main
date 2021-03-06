package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalPersons.getTypicalContactList;
import static seedu.address.testutil.TypicalHabits.getTypicalHabitTrackerList;
import static seedu.address.testutil.TypicalPurchases.getTypicalExpenditureList;
import static seedu.address.testutil.TypicalTasks.getTypicalTaskList;
import static seedu.address.testutil.TypicalWorkouts.getTypicalWorkoutList;

import org.junit.Test;

import seedu.address.logic.CommandHistory;
import seedu.address.model.ContactList;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;

public class ClearCommandTest {

    private CommandHistory commandHistory = new CommandHistory();

    @Test
    public void execute_emptyContactList_success() {
        Model model = new ModelManager();
        Model expectedModel = new ModelManager();
        expectedModel.commitContactList();

        assertCommandSuccess(new ClearCommand(), model, commandHistory, ClearCommand.MESSAGE_SUCCESS, expectedModel);
    }

    @Test
    public void execute_nonEmptyContactList_success() {
        Model model = new ModelManager(getTypicalContactList(), new UserPrefs(),
                getTypicalTaskList(), getTypicalExpenditureList(), getTypicalWorkoutList(), getTypicalHabitTrackerList());
        Model expectedModel = new ModelManager(getTypicalContactList(), new UserPrefs(),
                getTypicalTaskList(), getTypicalExpenditureList(), getTypicalWorkoutList(), getTypicalHabitTrackerList());
        expectedModel.setContactList(new ContactList());
        expectedModel.commitContactList();

        assertCommandSuccess(new ClearCommand(), model, commandHistory, ClearCommand.MESSAGE_SUCCESS, expectedModel);
    }

}
