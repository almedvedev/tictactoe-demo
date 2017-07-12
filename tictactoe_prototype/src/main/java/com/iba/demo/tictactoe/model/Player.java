package com.iba.demo.tictactoe.model;

public class Player {
	
	private String id;
	
	private PlayerMark mark;
	
	public Player(String id, PlayerMark mark) {
		super();
		this.id = id;
		this.mark = mark;		
	}
	
	public String getId() {
		return id;
	}

	public PlayerMark getMark() {
		return mark;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
//		result = prime * result + ((mark == null) ? 0 : mark.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
//		if (mark != other.mark)
//			return false;
		return true;
	}

}
