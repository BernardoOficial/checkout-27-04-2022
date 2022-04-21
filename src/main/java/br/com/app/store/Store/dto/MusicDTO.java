package br.com.app.store.Store.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class MusicDTO {

	@NotNull
	@NotBlank
	private String name;
	@NotNull
	@NotBlank
	private String artist;
	@NotNull
	@NotBlank
	private String musicStyle;
	@NotNull
	private Integer duration;
	@NotNull
	private Integer releaseYear;

	public MusicDTO(String name, String artist, String musicStyle, Integer duration, Integer releaseYear) {
		this.name = name;
		this.artist = artist;
		this.musicStyle = musicStyle;
		this.duration = duration;
		this.releaseYear = releaseYear;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getMusicStyle() {
		return musicStyle;
	}

	public void setMusicStyle(String musicStyle) {
		this.musicStyle = musicStyle;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Integer getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}

}
