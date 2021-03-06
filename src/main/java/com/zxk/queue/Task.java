package com.zxk.queue;

public class Task implements Comparable<Task>{
	private  Integer id;
	private String name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int compareTo(Task task) {
		
		return this.id > task.id ? 1 :(this.id < task.id ? -1 : 0);
	}
	
	public String toString(){
		return this.id +","+ this.name; 
	}
	
}
