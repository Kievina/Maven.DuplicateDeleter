package com.zipcodewilmington.looplabs;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by leon on 1/29/18.
 *
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class IntegerDuplicateDeleter extends DuplicateDeleter<Integer> {

    public IntegerDuplicateDeleter(Integer[] intArray) {
        super(intArray);
    }

    @Override
    public Integer[] removeDuplicates(int maxNumberOfDuplications) {
        List<Integer> integerList = Stream.of(array).filter(n -> getNumberOfOccurrences(array, n) < maxNumberOfDuplications)
                .collect(Collectors.toList());
        return integerList.toArray(new Integer[0]);
    }

    @Override
    public Integer[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        List<Integer> integerList = Stream.of(array).filter(n -> getNumberOfOccurrences(array, n) != exactNumberOfDuplications)
                .collect(Collectors.toList());
        return integerList.toArray(new Integer[0]);
    }

    @Override
    public Integer getNumberOfOccurrences(Integer[] intArray, Integer numToCount) {
        int numOfOccurrences = 0;
        for (Integer num : intArray) {
            if (num == numToCount)
                numOfOccurrences = numOfOccurrences + 1;
        }
        return numOfOccurrences;
    }
}
