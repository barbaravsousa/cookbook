package cookbook.domain;

import cookbook.exception.InvalidRecipeTitleException;

public class RecipeTitle {

    private String title;

    /**
     * Constructor.
     *
     * @param title of the recipe
     * @throws InvalidRecipeTitleException if title has invalid characters or numbers
     */
    public RecipeTitle(String title) throws InvalidRecipeTitleException {
        isTitleValid(title);
        this.title = title;
    }

    /**
     * Method that checks if the title is valid and only has letters.
     *
     * @param title of the recipe
     * @throws InvalidRecipeTitleException if the title isn't valid
     */
    private void isTitleValid(String title) throws InvalidRecipeTitleException {
        if (title == null || title.trim().length() == 0 || !title.matches("[A-zÀ-ÿ\\s']*")) {
            throw new InvalidRecipeTitleException("This title doesn't seem correct. Try again!");
        }
    }


}
