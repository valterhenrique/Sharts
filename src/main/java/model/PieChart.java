package model;

import javax.persistence.*;

/**
 * Author: Valter
 */
@Entity
@Table(name = "pie_chart")
public class PieChart
{
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String country;

	private Double weight;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getCountry()
	{
		return country;
	}

	public void setCountry(String country)
	{
		this.country = country;
	}

	public Double getWeight()
	{
		return weight;
	}

	public void setWeight(Double weight)
	{
		this.weight = weight;
	}

	@Override
	public String toString()
	{
		return "PieChart{" +
				"id=" + id +
				", country='" + country + '\'' +
				", weight=" + weight +
				'}';
	}
}
