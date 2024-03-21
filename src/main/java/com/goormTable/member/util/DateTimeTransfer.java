package com.goormTable.member.util;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class DateTimeTransfer {

    private static final String dateRegex = "\\d{4}[-/.](0?[1-9]|1[0-2])[-/.](0?[1-9]|[12]\\d|3[01])";
    private static final String splitRegex = "[-/.]";
    private static final Integer defaultNum = 0;

    public static LocalDateTime dayParseLocalDateTime(String day){
        if(day.equals("0")){
            return LocalDateTime.now();
        }
        if(!day.matches(dateRegex)){
            throw new IllegalArgumentException("구분은 \"/\", \".\", \"-\" 만..");
        }
        List<Integer> splitDay = Arrays.stream(day.split(splitRegex))
                .map(Integer::parseInt)
                .toList();
        return LocalDateTime.of(splitDay.get(0), splitDay.get(1), splitDay.get(2),defaultNum,defaultNum,defaultNum);
    }

}
