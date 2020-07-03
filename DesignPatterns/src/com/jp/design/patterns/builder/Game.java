package com.jp.design.patterns.builder;

public class Game {

	private String homeTeam;
	private String awayTeam;
	private String weather;
	private String stadium;

	private Game(GameBuilder gameBuilder) {
		this.homeTeam = gameBuilder.homeTeam;
		this.awayTeam = gameBuilder.awayTeam;
		this.weather = gameBuilder.weather;
		this.stadium = gameBuilder.stadium;
	}

	static final class GameBuilder {
		private String homeTeam;
		private String awayTeam;
		private String weather;
		private String stadium;

		GameBuilder(){}
		public GameBuilder stadium(String stadium) {
			this.stadium = stadium;
			return this;
		}

		public GameBuilder homeTeam(String homeTeam) {
			this.homeTeam = homeTeam;
			return this;
		}

		public GameBuilder awayTeam(String awayTeam) {
			this.awayTeam = awayTeam;
			return this;
		}

		public GameBuilder weather(String weather) {
			this.weather = weather;
			return this;
		}

		public Game build() {
			if (this.homeTeam == null)
				throw new IllegalStateException("Home Team can't be empty");
			if (this.awayTeam == null)
				throw new IllegalStateException("Away Team can't be empty");
			if (this.stadium == null)
				throw new IllegalStateException("Stadium can't be empty");
			else
				return new Game(this);
		}

	}
}
