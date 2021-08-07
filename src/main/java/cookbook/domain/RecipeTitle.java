package cookbook.domain;

import cookbook.exception.InvalidNameException;

public class RecipeTitle {

    private String title;

    /**
     * Constructor.
     *
     * @param title of the recipe
     * @throws InvalidNameException if title has invalid characters or numbers
     */
    public RecipeTitle(String title) throws InvalidNameException {
        isTitleValid(title);
        this.title = title;
    }

    /**
     * Method that checks if the title is valid and only has letters.
     *
     * @param title of the recipe
     * @throws InvalidNameException if the title isn't valid
     */
    private void isTitleValid(String title) throws InvalidNameException {
        if (title == null || title.trim().length() == 0 || !title.matches("[A-zÀ-ÿ\\s']*")) {
            throw new InvalidNameException("This title doesn't seem correct. Try again!");
        }
    }


}
