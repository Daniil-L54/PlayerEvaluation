CREATE DATABASE player_evaluation;
USE player_evaluation;

CREATE TABLE indexer (
  index_id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(64),
  valueMin FLOAT,
  valueMax FLOAT
);

CREATE TABLE player (
  player_id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(64),
  full_name VARCHAR(128),
  age INT,
  index_id INT,
  FOREIGN KEY (index_id) REFERENCES indexer(index_id)
);

CREATE TABLE player_index (
  id INT AUTO_INCREMENT PRIMARY KEY,
  player_id INT,
  index_id INT,
  value FLOAT,
  FOREIGN KEY (player_id) REFERENCES player(player_id),
  FOREIGN KEY (index_id) REFERENCES indexer(index_id)
);
