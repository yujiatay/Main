package seedu.address.logic.anakincommands;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_CARDS;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_DECKS;

import seedu.address.logic.CommandHistory;
import seedu.address.logic.anakincommands.exceptions.CommandException;
import seedu.address.model.Model;

/**
 * Reverts the {@code model}'s address book to its previously undone state.
 */
public class RedoCommand extends Command {

    public static final String COMMAND_WORD = "redo";
    public static final String MESSAGE_SUCCESS = "Redo success!";
    public static final String MESSAGE_FAILURE = "No more commands to redo!";

    @Override
    public CommandResult execute(Model model, CommandHistory history) throws CommandException {
        requireNonNull(model);

        if (!model.canRedoAnakin()) {
            throw new CommandException(MESSAGE_FAILURE);
        }

        model.redoAnakin();
        model.updateFilteredCardList(PREDICATE_SHOW_ALL_CARDS);
        model.updateFilteredDeckList(PREDICATE_SHOW_ALL_DECKS);

        return new CommandResult(MESSAGE_SUCCESS);
    }
}