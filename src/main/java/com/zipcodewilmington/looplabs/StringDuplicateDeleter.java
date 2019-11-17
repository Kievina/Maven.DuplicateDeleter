package com.zipcodewilmington.looplabs;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by leon on 1/28/18.
 *
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class StringDuplicateDeleter extends DuplicateDeleter<String> {
    public StringDuplicateDeleter(String[] stringArray) {
        super(stringArray);
    }

    @Override
    public String[] removeDuplicates(int maxNumberOfDuplications) {
        List<String> stringList = Arrays.stream(array).filter(value -> getNumberOfOccurrences(array, value) < maxNumberOfDuplications)
                .collect(Collectors.toList());
        return stringList.toArray(new String[0]);
    }

    @Override
    public String[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        List<String> stringList = Arrays.stream(array).filter(value -> getNumberOfOccurrences(array, value) != exactNumberOfDuplications)
                .collect(Collectors.toList());
        return stringList.toArray(new String[0]);
    }

    @Override
    public Integer getNumberOfOccurrences(String[] stringArray, String valueToCount) {
        int numOfOccurrences = 0;
        for (String value : stringArray) {
            if (value.equals(valueToCount))
                numOfOccurrences = numOfOccurrences + 1;
        }
        return numOfOccurrences;
    }
}
