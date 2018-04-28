package com.SmartHomeSystem;

import javax.persistence.*;

@Entity
@Table(name="UserTable")
public class User extends Person //implements DisplayList
{
	public int viewPage()
	{
		return DisplayView.viewUserFirstPage();
	}
}