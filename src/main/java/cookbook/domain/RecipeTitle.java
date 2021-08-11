package cookbook.domain;

import cookbook.exception.InvalidNameException;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeTitle that = (RecipeTitle) o;
        return Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public String toString() {
        return title;
    }
}
