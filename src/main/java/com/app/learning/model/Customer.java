package com.app.learning.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {

	@Id
	@GeneratedValue
	private Long custId;

	private String name;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "customer")
	private Set<Ticket> tickets = new HashSet<>();

	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	public Set<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (custId == null ? 0 : custId.hashCode());
		result = prime * result + (name == null ? 0 : name.hashCode());
		result = prime * result + (tickets == null ? 0 : tickets.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Customer other = (Customer) obj;
		if (custId == null) {
			if (other.custId != null) {
				return false;
			}
		} else if (!custId.equals(other.custId)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (tickets == null) {
			if (other.tickets != null) {
				return false;
			}
		} else if (!tickets.equals(other.tickets)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", name=" + name + ", tickets="
				+ tickets + "]";
	}

}
