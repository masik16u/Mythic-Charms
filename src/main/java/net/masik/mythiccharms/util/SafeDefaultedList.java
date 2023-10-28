package net.masik.mythiccharms.util;

import net.minecraft.util.collection.DefaultedList;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Wrapper for a list to return default value if getter index is out of bounds.
 *
 * @param <E> list element
 */
public class SafeDefaultedList<E> extends DefaultedList<E> {
    private final E initialElement;

    public SafeDefaultedList(Collection<E> delegate, E initialElement) {
        super(new ArrayList<>(delegate), initialElement);
        this.initialElement = initialElement;
    }

    @NotNull
    @Override
    public E get(int index) {
        return isInBounds(index) ? super.get(index) : this.initialElement;
    }

    private boolean isInBounds(int index) {
        return index < size();
    }
}
