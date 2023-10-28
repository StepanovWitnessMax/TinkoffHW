package edu.hw3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

class Task8BackwardIteratorTest {

    @Test
    @DisplayName("Проверка корректного вызова")
    void correctInput1() {
        //given
        var iterator = new Task8BackwardIterator<>(List.of(1, 2, 3));
        //when
        assertEquals(3, iterator.next());
        assertEquals(2, iterator.next());
        assertEquals(1, iterator.next());
        assertFalse(iterator.hasNext());
        //then
        Assertions.assertThatThrownBy(iterator::next).isInstanceOf(NoSuchElementException.class);
    }

    @Test
    @DisplayName("Проверка корректного вызова")
    void correctInput2() {
        //given
        var iterator = new Task8BackwardIterator<>(List.of(1));
        //when
        //then
        assertEquals(1, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    @DisplayName("Проверка пустого списка")
    void emptyList() {
        //given
        var iterator = new Task8BackwardIterator<Integer>(List.of());
        //when
        //then
        assertFalse(iterator.hasNext());
    }

    @Test
    @DisplayName("Проверка удаления")
    void testRemove() {
        //given
        var iterator = new Task8BackwardIterator<>(List.of(1));
        //when
        //then
        assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

}
