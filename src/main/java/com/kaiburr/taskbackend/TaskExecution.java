package com.kaiburr.taskbackend;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskExecution {
    private Date startTime;
    private Date endTime;
    private String output;
}
