package com.capgemini.tms.dto;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Admin {

	int testId;
	String testTitle;
	LocalTime testduration;
	LocalDateTime starttime;
	LocalDateTime endtime;
	
	@Override
	public String toString() {
		return "Admin [testId=" + testId + ", testTitle=" + testTitle + ", testduration=" + testduration
				+ ", starttime=" + starttime + ", endtime=" + endtime + "]";
	}

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public String getTestTitle() {
		return testTitle;
	}

	public void setTestTitle(String testTitle) {
		this.testTitle = testTitle;
	}

	public LocalTime getTestduration() {
		return testduration;
	}

	public void setTestduration(LocalTime testduration) {
		this.testduration = testduration;
	}

	public LocalDateTime getStarttime() {
		return starttime;
	}

	public void setStarttime(LocalDateTime starttime) {
		this.starttime = starttime;
	}

	public LocalDateTime getEndtime() {
		return endtime;
	}

	public void setEndtime(LocalDateTime endtime) {
		this.endtime = endtime;
	}

	public void admin() {
	}

	public void admin(int testId, String testTitle, LocalTime testduration, LocalDateTime starttime,
			LocalDateTime endtime) {

		this.testId = testId;
		this.testTitle = testTitle;
		this.testduration = testduration;
		this.starttime = starttime;
		this.endtime = endtime;
	}

}
