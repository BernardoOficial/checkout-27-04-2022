package br.com.app.store.Store.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class GameDTO {

	@NotNull
	@NotBlank
	private String name;
	@NotNull
	@NotBlank
	private String description;
	@NotNull
	@NotBlank
	private String releaseDate;
	@NotNull
	@NotBlank
	private String category;
	@NotNull
	private Integer parentalRating;

	public GameDTO(String name, String description, String releaseDate, String category, Integer parentalRating) {
		this.name = name;
		this.description = description;
		this.releaseDate = releaseDate;
		this.category = category;
		this.parentalRating = parentalRating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getParentalRating() {
		return parentalRating;
	}

	public void setParentalRating(Integer parentalRating) {
		this.parentalRating = parentalRating;
	}

}
