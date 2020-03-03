package com.company;

public class Task {
    String taskTitle;
    String taskDescription;
    int taskPriority;
    public Task(String taskTitle, String taskDescription, int taskPriority ){
        this.taskTitle = taskTitle;
        this.taskDescription = taskDescription;
        this.taskPriority = taskPriority;
    }
    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public int getTaskPriority() {
        return taskPriority;
    }

    public void setTaskPriority(int taskPriority) {
        this.taskPriority = taskPriority;
    }
    public void taskDisplay(){
        System.out.println("Title: " + this.taskTitle + "\nDescription: " + this.taskDescription + "\nPriority: " + this.taskPriority);
    }

}
